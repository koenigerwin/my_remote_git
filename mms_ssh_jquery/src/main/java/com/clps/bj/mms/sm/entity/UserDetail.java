package com.clps.bj.mms.sm.entity;

import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

import javax.persistence.*;
/**
 * 
 * @description：用户详情模型
 * @className：UserDetail
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月19日 下午3:28:58
 */
@Entity
@Table(name="user_detail")
public class UserDetail implements Serializable{
	
    /**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 835558469048264647L;
	private Integer userId;						//用户编号
	private String password;					//用户密码 MD5
    private String phoneNumber;					//用户手机
    private int sex;							//用户性别
    private String birthday;					//用户生日
    private String postNumber;					//用户邮编
    private String address;						//用户地址
    private String registerTime;				//用户注册日期

    
    

    /**
	 * @return the userId
	 */
    @Id
    @GenericGenerator(name = "generator", strategy = "assigned")
    @GeneratedValue(generator = "generator")
    @Column(name="id")
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
    
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name="sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Column(name="birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Column(name="post_number")
    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="register_time")
    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
	/* 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", password=" + password + ", phoneNumber=" + phoneNumber + ", sex=" + sex
				+ ", birthday=" + birthday + ", postNumber=" + postNumber + ", address=" + address + ", registerTime="
				+ registerTime + "]";
	}
    
    
}
