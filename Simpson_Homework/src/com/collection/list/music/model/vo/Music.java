package com.collection.list.music.model.vo;

public class Music {
//1. vo클래스 작성
//@com.collection.list.music.model.vo.Music.java
//-title:String
//-singer:String
//
//getter/setter, 기본생성자/파라미터있는생성자, toString 오버라이드
	
	private String title;
	private String singer;
	
	public Music() {
	}
	
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", singer=" + singer + "]";
	}

	
	
}
