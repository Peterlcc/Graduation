package com.peter.bean;

import java.util.List;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String sex;

    private Integer age;

    private String email;

    private Integer majorId;
    private Major major;
    
    private List<Log> logs;
    private List<Collect> collects;
    private List<Phone> phones;

    public User(Integer id, String name, String password, String sex, Integer age, String email, Integer majorId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.majorId = majorId;
    }

    public User() {
    }
    
	public void clone(User user) {
		this.id = user.id;
        this.name = user.name;
        this.password = user.password;
        this.sex = user.sex;
        this.age = user.age;
        this.email = user.email;
        this.majorId = user.majorId;
	}


	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Collect> getCollects() {
		return collects;
	}

	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", age=" + age
				+ ", email=" + email + ", majorId=" + majorId + ", major=" + major.getName() + "]";
	}

}