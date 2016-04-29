package org.ysh.domain;

import java.util.Date;

/**
 * 用户管理表
 * @author Administrator
 *
 */
public class Administrator implements Entity {
	private Integer id;
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码(使用MD5算法加密)
	 */
	private String passwd;
	
	/**
	 * 用户创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户的有效标识(0 无效 1 有效)
	 */
	private boolean validFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isValidFlag() {
		return validFlag;
	}

	public void setValidFlag(boolean validFlag) {
		this.validFlag = validFlag;
	}

	@Override
	public String toString() {
		return "Adminstrator [id=" + id + ", userName=" + userName
				+ ", passwd=" + passwd + ", createTime=" + createTime
				+ ", validFlag=" + validFlag + "]";
	}
	
}
