package com.peter.parse;

import java.util.List;

import com.peter.bean.CrawlJob;

public interface Parser {
	List<CrawlJob> parse();
}
