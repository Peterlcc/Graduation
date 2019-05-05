package com.peter.damake;

import java.util.Random;

import com.peter.bean.User;

public class UserMaker {
	private static char[] words=new char[52];
	private static char[] nums=new char[10];
	static {
		int index=0;
		for (char i = 'a'; i <='z'; i++) {
			words[index++]=i;
		}
		for (char i = 'A'; i <='Z'; i++) {
			words[index++]=i;
		}
		index=0;
		for (char i = '0'; i <='9'; i++) {
			nums[index++]=i;
		}
	}
	private Random random=null;
	public UserMaker(Random random) {
		this.random = random;
	}
	private String getName(int len)
	{
		
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < len; i++) {
			stringBuilder.append(words[random.nextInt(words.length)]);
		}
		return stringBuilder.toString();
	}
	private String getEmail(int len)
	{
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < len; i++) {
			stringBuilder.append(nums[random.nextInt(nums.length)]);
		}
		stringBuilder.append('@');
		for (int i = 0; i < 3; i++) {
			stringBuilder.append(nums[random.nextInt(nums.length)]);
		}
		return stringBuilder.toString();
	}
	public void make(User user) {
		user.setId(null);
		user.setName(getName(random.nextInt(3)+3));
		user.setPassword(getName(random.nextInt(5)+5));
		user.setSex(random.nextInt()%2==0?"男":"女");
		user.setAge((int)(random.nextGaussian()*Math.sqrt(64)+28));
		while(user.getAge()<18||user.getAge()>45) user.setAge(random.nextInt(20)+20);
		user.setEmail(getEmail(random.nextInt(5)+10)+".com");
		user.setMajorId(random.nextInt(8)+1);
	}
}
