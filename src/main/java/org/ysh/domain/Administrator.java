package org.ysh.domain;

import java.util.Date;

/**
 * �û������
 * @author Administrator
 *
 */
public class Administrator implements Entity {
	private Integer id;
	/**
	 * �û���
	 */
	private String userName;
	
	/**
	 * ����(ʹ��MD5�㷨����)
	 */
	private String passwd;
	
	/**
	 * �û�����ʱ��
	 */
	private Date createTime;
	
	/**
	 * �û�����Ч��ʶ(0 ��Ч 1 ��Ч)
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
