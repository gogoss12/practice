package com.collection.list.music.view;

import java.util.Scanner;

import com.collection.list.music.controller.MusicManager;

public class MusicMenu {

	private Scanner sc = new Scanner(System.in);
	MusicManager manager = new MusicManager();


	public void mainMenu() {

		while (true) {
			System.out.println("================ Music Playlist Menu ================");
			System.out.println("1.목록보기");
			System.out.println("2.마지막에 음악추가");
			System.out.println("3.맨처음에 음악추가");
			System.out.println("4.곡삭제");
			System.out.println("5.곡변경");
			System.out.println("6.곡명검색");
			System.out.println("7.가수검색");
			System.out.println("8.목록정렬(곡명오름차순)");
			System.out.println("0.종료");
			System.out.println("=======================================================");

			int Menu = sc.nextInt();
			sc.nextLine();

			switch (Menu) {
			
			case 1:
				
			
			
			
			
			

			case 8:
				

					

				
			};

		};

	};

};
