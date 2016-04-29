package org.ysh.domain;

import java.util.Date;
import java.util.List;

/**
 * ��Ӱ����Ϣʵ����
 * @author Administrator
 *
 */
public class Cinema implements Entity {
	
	private long id;
	
	/**
	 * ��Ӱ����
	 */
	private String cinemaName;
	
	/**
	 * ����
	 */
	private String director;
	
	/**
	 * ��Ա
	 */
	private List<String> actor;
	
	/**
	 * ����
	 */
	private String address;
	
	/**
	 * ��ӳʱ��
	 */
	private Date playTime;
	
	/**
	 * ��Ӱ���
	 */
	private char[] describe;
	
	/**
	 * ����
	 */
	private byte[] poster;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActor() {
		return actor;
	}

	public void setActor(List<String> actor) {
		this.actor = actor;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public char[] getDescribe() {
		return describe;
	}

	public void setDescribe(char[] describe) {
		this.describe = describe;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", cinemaName=" + cinemaName
				+ ", director=" + director + ", actor=" + actor + ", address="
				+ address + ", playTime=" + playTime + "]";
	}
	
}
