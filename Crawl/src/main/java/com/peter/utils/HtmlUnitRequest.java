package com.peter.utils;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitRequest  {

    private List<String> userAgentList=CrawlConfig.getUserAgent();

    public String request(String url) throws Exception {
        try (
                WebClient client = new WebClient()
        ) {
            int randomIndex = RandomUtils.nextInt(0, userAgentList.size());
            client.removeRequestHeader("user-agent");
            client.addRequestHeader("user-agent", userAgentList.get(randomIndex));
            HtmlPage page = client.getPage(url);
            return page.getTextContent();
        }
    }
}
