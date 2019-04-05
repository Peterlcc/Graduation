package com.peter.utils;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientRequest {

    private List<String> userAgentList=CrawlConfig.getUserAgent();

    public String request(String url) throws Exception {
        try (
                CloseableHttpClient client = HttpClientBuilder.create().build();
        ) {
            int randomIndex = RandomUtils.nextInt(0, userAgentList.size());

            HttpGet request = new HttpGet(url);
            request.setHeader("user-agent", userAgentList.get(randomIndex));
            CloseableHttpResponse response = client.execute(request);
            return IOUtils.toString(response.getEntity().getContent());
        }
    }
}
