package com.peter.service;

import com.peter.bean.Area;

public interface AreaService {
	Area getAreaById(Integer areaId);
	Area getAreaByName(String name);
}
