package com.peter.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.peter.bean.House;
import com.peter.bean.Img;
import com.peter.mapper.HouseMapper;
import com.peter.mapper.ImgMapper;

public class HouseFileParser extends InfoParser {
	private String root = null;

	public HouseFileParser(ApplicationContext context, String root) {
		super(context);
		this.root = root;
	}

	@Override
	public void parser() {
		HouseMapper houseMapper = context.getBean(HouseMapper.class);
		ImgMapper imgMapper = context.getBean(ImgMapper.class);
		Img img = new Img();
		File rootDire = new File(root);
		for (String areaPath : rootDire.list()) {
			// System.out.println(rootDire.getAbsolutePath()+File.separator+areaPath);
			File areaDire = new File(rootDire.getAbsolutePath() + File.separator + areaPath);
			// System.out.println(areaDire.getAbsolutePath());
			for (String streetPath : areaDire.list()) {
				File streetDire = new File(areaDire.getAbsolutePath() + File.separator + streetPath);
				System.out.println(streetDire.getAbsolutePath());
				for (String housePath : streetDire.list()) {
					String page = housePath.substring(0, housePath.indexOf("."));
					File pageTxt = new File(streetDire.getAbsolutePath() + File.separator + housePath);
					List<House> houses = getHousesFromTxt("天津", areaDire.getName(), streetDire.getName(), page,
							pageTxt);
					for (House house : houses) {
						houseMapper.insertSelective(house);
						for (String url : house.getImgUrls()) {
							img.setId(null);
							img.setHouseId(house.getId());
							img.setUrl(url);
							imgMapper.insertSelective(img);
						}
						//System.out.println(house);
					}
					//return;
				}
			}
		}
	}

	private List<House> getHousesFromTxt(String city, String area, String street, String page, File pageTxt) {
		List<House> houses = new ArrayList<>();
		try {
			List<String> lines = null;
			lines = IOUtils.readLines(new FileInputStream(pageTxt), "utf-8");
			for (String line : lines) {
				House house = JSONObject.parseObject(line, House.class);
				house.setId(null);
				house.setCity(city);
				house.setAreaCity(area);
				house.setStreet(street);
				house.setPage(Integer.parseInt(page));
				houses.add(house);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return houses;
	}
}
