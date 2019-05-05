package com.peter.run;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.context.ApplicationContext;

import com.peter.bean.Collect;
import com.peter.bean.House;
import com.peter.bean.Log;
import com.peter.bean.Phone;
import com.peter.bean.User;
import com.peter.damake.UserMaker;
import com.peter.mapper.CollectMapper;
import com.peter.mapper.HouseMapper;
import com.peter.mapper.ImgMapper;
import com.peter.mapper.LogMapper;
import com.peter.mapper.PhoneMapper;
import com.peter.mapper.UserMapper;
import com.peter.parser.HouseFileParser;
import com.peter.parser.InfoParser;
import com.peter.utils.CrawlConfig;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ApplicationContext context;
	private static int userCount=1800;

	private static void init() {
		context = CrawlConfig.getApplicationContext();
	}
    public static void main( String[] args )
    {
        init();
        System.out.println("log make start");
        getLogFromRandom();
        System.out.println("log make finish");
        System.out.println("Collect make start");
        getCollectFromRandom();
        System.out.println("Collect make finish");
        System.out.println("Phone make start");
        getPhoneFromRandom();
        System.out.println("Phone make finish");
    }
	public static void getPhoneFromRandom() {
        PhoneMapper phoneMapper = context.getBean(PhoneMapper.class);
        int houseCount=24716;
        Random random=new Random();
        Phone phone=new Phone();
        for (int i = 1; i <= userCount; i++) {
			Set<Integer> records=new HashSet<>();
			phone.setId(null);
			phone.setUserId(i);
			int counts=random.nextInt(5)+3;
			while(records.size()<counts)
			{
				records.add(random.nextInt(houseCount)+1);
			}
			for(int r:records)
			{
				phone.setHouseId(r);
				phoneMapper.insertSelective(phone);
			}
			System.out.println(i+"--"+records.size());
			if(i%100==0) System.gc();
		}
	}
	public static void getCollectFromRandom() {
        CollectMapper collectMapper = context.getBean(CollectMapper.class);
        int houseCount=24716;
        Random random=new Random();
        Collect collect=new Collect();
        for (int i = 1; i <= userCount; i++) {
			Set<Integer> records=new HashSet<>();
			collect.setId(null);
			collect.setUserId(i);
			int counts=random.nextInt(7)+7;
			while(records.size()<counts)
			{
				records.add(random.nextInt(houseCount)+1);
			}
			for(int r:records)
			{
				collect.setHouseId(r);
				collectMapper.insertSelective(collect);
			}
			System.out.println(i+"--"+records.size());
			if(i%50==0) System.gc();
		}
	}
	public static void getLogFromRandom() {
        LogMapper logMapper = context.getBean(LogMapper.class);
        int houseCount=24716;
        Random random=new Random();
        Log log=new Log();
        for (int i = 1; i <= userCount; i++) {
			Set<Integer> records=new HashSet<>();
			log.setId(null);
			log.setUserId(i);
			int counts=random.nextInt(11)+15;
			while(records.size()<counts)
			{
				records.add(random.nextInt(houseCount)+1);
			}
			for(int r:records)
			{
				log.setHouseId(r);
				logMapper.insertSelective(log);
			}
			System.out.println(i+"--"+records.size());
			if(i%25==0) System.gc();
		}
	}
	public static void getUsersFromRandom() {
		UserMapper userMapper = context.getBean(UserMapper.class);
        Random random=new Random();
        User user=new User();
        UserMaker userMaker=new UserMaker(random);
        for (int i = 0; i < userCount; i++) {
        	userMaker.make(user);
        	userMapper.insertSelective(user);
		}
	}
	public static void getHouseWithImgFromFiles() {
		InfoParser infoParser=new HouseFileParser(context, "F:/houses/天津/天津");
        infoParser.parser();
	}
}
