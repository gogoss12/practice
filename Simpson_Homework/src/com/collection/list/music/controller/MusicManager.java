package com.collection.list.music.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.model.vo.Music;

public class MusicManager {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Music> mList = new ArrayList<Music>() {
		{
			add(new Music("노래1","가수1"));
			add(new Music("노래2","가수2"));
			add(new Music("노래3","가수3"));
			add(new Music("노래4","가수4"));
			add(new Music("노래5","가수5"));
		}
	};
	
	//음악리스트 리턴
	public List<Music> selectList() {
		
		return mList;
	};
	//2. 마지막에 음악추가 : 사용자로부터 곡명과 가수를 입력받아 리스트에 저장하는 메소드.
	public void addList(Music music) {
		mList.add(music);
	};
	
	//3. 맨처음에 음악추가 : 리스트 최상위(0번지)에 음악을 추가하는 메소드
	public void addAtZero(Music music) {
		mList.add(0, music);
	};
	
	//4. 특정곡을 삭제하는 메소드(제목을 전달받아 검색후, 최초로 검색된 음악을 삭제)
	public boolean removeMusic(String title) {
		
		if(mList.equals(new Music(title,""))){ 
			mList.remove(title);
			System.out.println("삭제되었습니다.");
			return true;
		} else {
			System.out.println("삭제할 곡이 없습니다.");
			return false;
		}
		
	};
	
	//5. 특정곡을 바꾸는 메소드(이전 음악객체, 새 음악객체를 전달해서 교체)
	public boolean replaceMusic(Music oldMusic, Music newMusic) {
		
		if()
		
		return false;
	};
	//6. 특정곡이 있는지 검사하는 메소드 : 복수개의 결과가 나올수 있음. 
	public List<Music> searchMusicByTitle(String title){
		
		
		return null;
	};
	//7. 가수명으로 검색 메소드 : 복수개의 결과가 나올수 있음.
	public List<Music> searchMusicBySinger(String singer){
		
		return null;
	};
	//8. 서브메뉴 - 각 정렬 메소드 : Comparable/Comparator 인터페이스를 적절히 활용할 것
	public List<Music> orderBy(Comparator<Music> c){
		
		return null;
	};
	
	
};
