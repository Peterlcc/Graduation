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
    	CloseableHttpClient client =null;
        try {
            int randomIndex = RandomUtils.nextInt(0, userAgentList.size());
        	client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            request.setHeader("user-agent", userAgentList.get(randomIndex));
            request.setHeader("Accept", "  text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            request.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
            request.setHeader("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
            //System.out.print(" [user-agent:"+userAgentList.get(randomIndex)+"] ");
            CloseableHttpResponse response = client.execute(request);
            System.out.println(" response:"+response.getProtocolVersion()+" ");
            String text = IOUtils.toString(response.getEntity().getContent());
            response.close();
            return text;
        }
        catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        finally {
			client.close();
		}
    }
}
