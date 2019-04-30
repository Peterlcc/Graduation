package com.peter.parse;

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
import com.peter.mapper.HouseMapper;

public class HouseFileParser extends InfoParser{
	private String root=null;
	
	public HouseFileParser(ApplicationContext context,String root) {
		super(context);
		this.root=root;
	}

	@Override
	public void parser() {
		HouseMapper houseMapper = context.getBean(HouseMapper.class);
		File rootDire=new File(root);
		for (String areaPath : rootDire.list()) {
			File areaDire=new File(rootDire.getAbsolutePath()+areaPath);
			for (String streetPath : areaDire.list()) {
				File streetDire=new File(areaDire.getAbsolutePath()+streetPath);
				for(String housePath:streetDire.list())
				{
					String page = housePath.substring(0, housePath.indexOf("."));
					File pageTxt=new File(streetDire.getAbsolutePath()+housePath);
					List<House> houses=getHousesFromTxt("天津",areaDire.getName(),streetDire.getName(),page,pageTxt);
					for (House house : houses) {
						//houseMapper.insertSelective(house);
						System.out.println(house);
					}
					return;
				}
			}
		}
	}

	private List<House> getHousesFromTxt(String city, String areaDire, String streetDire, String page,File pageTxt) {
		List<House> houses=new ArrayList<>();
		try {
			List<String> lines=null;
			lines = IOUtils.readLines(new FileInputStream(pageTxt), "utf-8");
			for (String line : lines) {
				houses.add(JSONObject.parseObject(line, House.class));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return houses;
	}
}
