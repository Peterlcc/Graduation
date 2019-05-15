package com.peter.service;

import java.util.List;
import java.util.Map;

public interface AnalyzeService {
	List<Map<String, String>> analyzeByProperty(String userProperty, String houseProperty, String middleTable);
}
