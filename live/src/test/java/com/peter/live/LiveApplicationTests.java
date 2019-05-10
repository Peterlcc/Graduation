package com.peter.live;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.peter.bean.House;
import com.peter.bean.Log;
import com.peter.bean.User;
import com.peter.mapper.HouseMapper;
import com.peter.mapper.LogMapper;
import com.peter.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LiveApplicationTests {

	@Autowired
	private LogMapper logMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HouseMapper houseMapper;
	
	@Test
	public void contextLoads() {
		/*Log log = logMapper.selectByPrimaryKey(1);
		System.out.println(log);
		System.out.println(log.getHouse());
		
		List<Log> logs = logMapper.selectLogsByUserId(1);
		System.out.println(logs.size());
		System.out.println(logs.get(0).getHouse());*/
		
		List<User> users= userMapper.selectByName("Cakr");
		User user = users.get(0);
		System.out.println(user);
		System.out.println(user.getRecommands());
	}

}
