package com.peter.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.peter.bean.Area;
import com.peter.bean.City;
import com.peter.bean.House;
import com.peter.bean.HouseUrl;
import com.peter.bean.Page;
import com.peter.bean.Street;
import com.peter.mapper.HouseUrlMapper;
import com.peter.mapper.PageMapper;
import com.peter.utils.JouspRequest;
import com.peter.utils.StringUtil;

public class HouseInfoParser extends InfoParser {

	private String root=null;
	private int sleepTime=20;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final String midUrl1 = "aj/house/brokers?house_codes=";
	private final String midUrl2 = "&position=bottom&ucid=";
	
	public int getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	public HouseInfoParser(ApplicationContext context,String root) {
		super(context);
		this.root=root;
	}
	private String getBasicMsgFromString(String msg) {
		int index = msg.indexOf("：");
		return msg.substring(index + 1);
	}
	private boolean isJson(String dealerPhoneMsg) {
		if (dealerPhoneMsg == null)
			return false;
		try {
			JSONObject.parseObject(dealerPhoneMsg);
			return true;
		} catch (Exception e) {
			System.out.print(" not json ");
			return false;
		}
	}
	private House getHouseFromUrl(HouseUrl houseUrl) throws ParseException, InterruptedException {
		System.out.println();
		System.out.print("houseurl:" + houseUrl.getId());
		House house = new House();
		String url = houseUrl.getUrl();
		JouspRequest request = new JouspRequest();
		// HttpClientRequest request = new HttpClientRequest();
		// HtmlUnitRequest request = new HtmlUnitRequest();
		System.out.print(" html crawling");
		Document doc = request.request(url);
		int htmlCount = 1;
		while (doc == null) {
			System.out.println(houseUrl.getId() + " html sleep " + sleepTime + "s");
			TimeUnit.SECONDS.sleep(sleepTime);
			doc = request.request(url);
			if ((htmlCount++) > 5) {
				System.out.println("houseurl :" + houseUrl.getId() + "<->" + houseUrl.getUrl() + " can't request");
				System.exit(1);
			}
		}

		System.out.print(" doc crawled");

		house.setId(houseUrl.getId());
		house.setUrl(houseUrl.getUrl());
		house.setPageId(houseUrl.getPageId());

		// house title
		Element titleEle = doc.selectFirst("body > div.wrapper > div> div.content.clear.w1150 > p.content__title");
		if (titleEle != null)
			house.setTitle(titleEle.ownText());
		else {
			return null;
		}

		// house code
		Element codeEle = doc.selectFirst(
				"body > div.wrapper > div > div.content.clear.w1150 > div.content__subtitle > i.house_code");
		if (codeEle != null) {
			String codeStr = codeEle.ownText();
			String code = codeStr.substring(codeStr.indexOf("：") + 1);
			house.setHouseCode(code);
		} else
			house.setHouseCode("code");

		// house releaseTime
		Element releaseTimeEle = doc
				.selectFirst("body > div.wrapper > div:nth-child(1) > div.content.clear.w1150 > div.content__subtitle");
		if (releaseTimeEle != null) {
			String timeMsg = releaseTimeEle.ownText();
			String[] timeMsgs = StringUtils.split(timeMsg, " ");

			house.setReleaseTime(simpleDateFormat.parse(timeMsgs[timeMsgs.length - 1]));
		} else
			house.setReleaseTime(new Date());

		// house businessLicense
		Element businessLicenseEle = doc.selectFirst(
				"body > div.wrapper > div > div.content.clear.w1150 > div.content__subtitle > ul > li > img");
		if (businessLicenseEle != null)
			house.setBusinessLicense(businessLicenseEle.attr("src"));
		else
			house.setBusinessLicense("businessLicense");

		// house price
		Element priceEle = doc.selectFirst("#aside > p.content__aside--title > span");
		if (priceEle != null)
			house.setPrice(new BigDecimal(priceEle.ownText()));
		else
			house.setPrice(new BigDecimal(0));

		// house payType
		Element payTypeEle = doc.selectFirst("#aside > p.content__aside--title");
		try {
			if (payTypeEle != null) {
				String payType = payTypeEle.ownText();
				house.setPayType(payType.substring(payType.indexOf("(") + 1, payType.indexOf("价")));
			} else
				house.setPayType("不限");
		} catch (Exception e) {
			house.setPayType("不限");
		}

		// tags
		Elements tags = doc.select("#aside > p.content__aside--tags > i");
		StringBuilder tagsBuilder = new StringBuilder();
		for (Element tag : tags) {
			tagsBuilder.append(tag.ownText() + "%%");
		}
		house.setTags(tagsBuilder.toString());

		// rentType roomType area direction
		Elements asideList = doc.select("#aside > ul.content__aside__list > p.content__article__table > span");
		for (Element aside : asideList) {
			Element i = aside.selectFirst("i");
			if (i.className().equals("house")) {
				house.setRentType(aside.ownText());
			} else if (i.className().equals("typ")) {
				house.setRoomType(aside.ownText());
			} else if (i.className().equals("area")) {
				String areaStr = StringUtil.getNumbersFromString(aside.ownText());
				house.setArea(Double.parseDouble(areaStr));
			} else if (i.className().equals("orient")) {
				house.setDirection(aside.ownText());
			}
		}

		// dealerName
		// Element dealerNameEle = doc.selectFirst(
		// "#aside > ul.content__aside__list > li >
		// div.content__aside__list--title.oneline > span.contact_name");
		// house.setDealerName(dealerNameEle.attr("title"));

		//
		Element dealerMsgEle = doc
				.selectFirst("#aside > ul.content__aside__list > li > p.content__aside__list--subtitle.oneline");
		String dealerMsg = dealerMsgEle.ownText();
		String[] msgs = StringUtils.split(dealerMsg, "\r\n|\n| ");
		if (msgs == null || msgs.length == 0) {
			house.setDealerCompany("no msg");
			house.setDealerType("no msg");
		} else if (msgs.length < 2) {
			house.setDealerCompany(msgs[0]);
			house.setDealerType("no msg");
		} else {
			house.setDealerCompany(msgs[0]);
			house.setDealerType(msgs[1]);
		}

		// dealerPhone
		Element phoneEle = doc.selectFirst(
				"#aside > ul.content__aside__list > li > div.phone__hover--wrapper > span.contact__im.im__online");
		if (phoneEle != null) {
			String host = houseUrl.getUrl().substring(0,
					houseUrl.getUrl().indexOf("/", houseUrl.getUrl().indexOf("zufang") + 1) + 1);
			String house_code = phoneEle.attr("data-id");
			String phoneUrl = host + midUrl1 + house_code + midUrl2 + phoneEle.attr("data-info");
			
			//HttpClientRequest jsonRequest = new HttpClientRequest();
			System.out.print(" phone crawling");
			String dealerPhoneMsg = request.text(phoneUrl);
			int phoneCount = 1;
			while (!isJson(dealerPhoneMsg)) {
				System.out.println(houseUrl.getId()+" <-> "+phoneUrl + " phone sleep " + sleepTime + "s");
				TimeUnit.SECONDS.sleep(sleepTime);
				if ((phoneCount++) > 5) {
					try {
						IOUtils.write(dealerPhoneMsg, new FileOutputStream("D:/test.html"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("phoneurl :" + phoneUrl + "<->" + houseUrl.getUrl()
							+ " dealerPhone request can't request or isn't json");
					System.exit(1);
				}
				dealerPhoneMsg = request.text(phoneUrl);
			}
			System.out.print(" phone crawled");
			Map<String, Object> dealerPhoneMsgMap = JSONObject.parseObject(dealerPhoneMsg, Map.class);
			Map<String, Object> phoneMap = (Map<String, Object>) dealerPhoneMsgMap.get("data");
			Map<String, Object> housePhoneMap = (Map<String, Object>) phoneMap.get(house_code);
			Map<String, Object> houseCodeMap = (Map<String, Object>) housePhoneMap.get(house_code);
			String phoneStr = (String) houseCodeMap.get("tp_number");
			house.setDealerPhone(phoneStr.replace(",", "转"));
			// dealerName
			house.setDealerName((String) houseCodeMap.get("contact_name"));
		}else {
			house.setDealerPhone("无");
			house.setDealerName("无");
		}

		// basic msg
		Elements basicMsgEle = doc.select(
				"body > div.wrapper > div:nth-child(1) > div.content.clear.w1150 > div.content__article.fl > div.content__article__info > ul > li");
		List<String> basicMsgs = new ArrayList<>();
		for (Element basicMsg : basicMsgEle) {
			String bmsg = basicMsg.ownText();
			if (!bmsg.contains("："))
				continue;
			basicMsgs.add(bmsg);
		}
		house.setCheckinType(getBasicMsgFromString(basicMsgs.get(1)));
		house.setRentTime(getBasicMsgFromString(basicMsgs.get(2)));
		house.setLookType(getBasicMsgFromString(basicMsgs.get(3)));
		house.setFloor(getBasicMsgFromString(basicMsgs.get(4)));
		house.setElevator(getBasicMsgFromString(basicMsgs.get(5)));
		house.setCarPos(getBasicMsgFromString(basicMsgs.get(6)));
		house.setWater(getBasicMsgFromString(basicMsgs.get(7)));
		house.setElectricity(getBasicMsgFromString(basicMsgs.get(8)));
		house.setGas(getBasicMsgFromString(basicMsgs.get(9)));

		// faculty
		Elements facultyEle = doc.select(
				"body > div.wrapper > div:nth-child(1) > div.content.clear.w1150 > div.content__article.fl > ul > li");
		StringBuilder facultyBuider = new StringBuilder();
		for (int j = 1; j < facultyEle.size(); j++) {
			Element faculty = facultyEle.get(j);
			Set<String> classNames = faculty.classNames();
			boolean haveno = false;
			for (String className : classNames) {
				if (className.contains("no")) {
					haveno = true;
					break;
				}
			}
			if (haveno)
				continue;
			facultyBuider.append(faculty.ownText() + "%%");
		}
		house.setFacility(facultyBuider.toString());

		// nearby
		Elements nearbyEles = doc.select("#around > ul > li");
		StringBuilder nearbyBuilder = new StringBuilder();
		for (Element nearby : nearbyEles) {
			Element dis = nearby.selectFirst("span");
			nearbyBuilder.append(dis.ownText() + "%%");
		}
		house.setNearby(nearbyBuilder.toString());

		// imgUrls
		List<String> imgUrls = new ArrayList<>();
		Elements imgs = doc.select("#prefix > li");
		for (Element imgli : imgs) {
			Elements img = imgli.select("img");
			imgUrls.add(img.attr("src"));
		}
		house.setImgUrls(imgUrls);
		return house;
	}
	private void doParser() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		HouseUrlMapper houseUrlMapper = context.getBean(HouseUrlMapper.class);
		PageMapper pageMapper = context.getBean(PageMapper.class);
		for (int i = 1; i <= 28228; i++) {//22975      277 - 22937，24051- 28228

			List<HouseUrl> houseUrls = houseUrlMapper.selectByPageId(i);
			System.out.println();
			System.out.println("pageId:" + i);
			List<String> houseOutputs = new ArrayList<>();
			for (HouseUrl houseUrl : houseUrls) {
				House house = getHouseFromUrl(houseUrl);
				if (house != null)
					houseOutputs.add(JSONObject.toJSONString(house));
			}
			Page page = pageMapper.selectByPrimaryKey(i);
			Street street = page.getStreet();
			Area area = street.getArea();
			City city = area.getCity();
			String dire = root + city.getProvince() + "/" + city.getName() + "/" + area.getName() + "/"
					+ street.getName() + "/";
			File directory = new File(dire);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			String path = page.getSerialNumber() + ".txt";
			IOUtils.writeLines(houseOutputs, IOUtils.LINE_SEPARATOR, new FileOutputStream(dire + path, true));
			System.out.println(path+" writed!");
			if(i%10==0) System.gc();
		}
		System.out.println();
		System.out.println("all crawled success");
	}
	@Override
	public void parser() {
		try {
			doParser();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
