package com.kh.log.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.kh.log.controller.SignUpController;
import com.kh.log.model.Person;

public class Login implements Serializable {

	// 개별 회원 조회 추가해보기
	// 회원 탈퇴 추가하기

	SignUpController su = new SignUpController();
	Scanner sc = new Scanner(System.in);

	// 로그인 상태값 관리.
	boolean loginStatus = false;
	Person loginUser = null;

	public void Menu() {

		while (true) {
			System.out.println("======================= MENU ======================");
			if (loginStatus) {
				System.out.println("3. 로그아웃");
			} else {
				System.out.println("1. 회원 가입");
				System.out.println("2. 전체 회원 조회");
				System.out.println("3. 로그인");
			}
			// 로그인시 main메뉴 등장
			if (loginStatus) {
				System.out.println("4. 회원탈퇴");
				System.out.println("5. 내 정보보기");
				System.out.println("6. 인바디(InBody) 확인");
				System.out.println("7. 희망의 로또 번호 출력(1등당첨 0회)");
			}
			System.out.println("0. 프로그램 종료!");
			System.out.println("===================================================");
			System.out.print("번호를 입력해주세요 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				signUp();
				break;
			case 2:
				getPerson();
				break;
			case 3:
				if (loginStatus) {
					LogOut();
				} else {
					login();
				}
				break;
			case 4:
				DeletePersonProfile();
				break;
			case 5:
				if (loginUser != null) {
					System.out.println(loginUser);
				}
				break;
			case 6:
				InBody();
				break;
			case 7:
				LottoNumber();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	public void signUp() {
		System.out.println("======================= 회원 가입 ====================");
		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("성별 : ");
		char gender = sc.nextLine().charAt(0);
		if (gender == '남' || gender == '여') {

		} else {
			System.out.println("성별을 다시 입력해주세요");
			return;
		}

		System.out.print("ID : ");
		String iD = sc.nextLine();

		System.out.print("PassWard : ");
		String passWord = sc.nextLine();

		su.Person(name, age, gender, iD, passWord);
		//
	}

	public void getPerson() {

		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("회원 정보.dat"))) {

			List<Person> su = ((List) ois.readObject());
			for (Person person : su) {
				System.out.println(person);
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("회원 정보가 없습니다.");
		}
	}

	public void login() {

		System.out.println("아이디를 입력하세요");
		String iD = sc.nextLine();

		System.out.println("비밀번호를 입력하세요");
		String passWord = sc.nextLine();
		
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("회원 정보.dat"))) {

			List<Person> p = (List) oi.readObject();

			for (int i = 0; i < p.size(); i++) {
				if (p.get(i).getPassWord().equals(passWord) && p.get(i).getID().equals(iD)) {
					loginUser = p.get(i);
					System.out.println("로그인성공!");
					loginStatus = true;
					return;
				}
			}
			for (int i = 0; i < p.size(); i++) {
				if (!p.get(i).getPassWord().equals(passWord) || !p.get(i).getID().equals(iD)) {
					System.out.println("로그인 실패!");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LogOut() {

		if (loginStatus) {
			System.out.println("로그아웃되었습니다.");
			loginStatus = false;
			loginUser = null;
		} else {
			login();
		}
	}

	public void DeletePersonProfile() {

		char answer;

		// 로그인시 메뉴가 나타남
		// 회원탈퇴를 누르면 아이디, 비밀번호를 입력함
		// 회원을 탈퇴하시겠습니까? 출력
		// 탈퇴완료 => 파일 정보 삭제
		System.out.println("======================= DeletePersonProfile ====================");

		System.out.println("이름을 입력해주세요 : ");
		String name = sc.nextLine();

		System.out.print("아이디를 입력하세요 : ");
		String iD = sc.nextLine();

		System.out.print("비밀번호를 입력하세요 : ");
		String passWord = sc.nextLine();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("회원 정보.dat"))) {

			List<Person> p = (List) ois.readObject();

			for (int i = 0; i < p.size(); i++) {
				if (p.get(i).getPassWord().equals(passWord) && p.get(i).getID().equals(iD)
						&& (p.get(i).getName().equals(name))) {
					System.out.println("정보가 일치합니다.");
					System.out.println("---------------------------------------");
					System.out.println("회원 탈퇴를 계속 진행하시겠습니까? (Y/N)");
					answer = sc.nextLine().charAt(0);
					
					if (answer == 'Y' || answer == 'y') {

						p.remove(i);
						LogOut();

						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("회원 정보.dat"));
						for (int j = 0; j < p.size(); j++) {
							oos.writeObject(p.get(j));
							oos.close();
						}

					} else if (answer == 'N' || answer == 'n') {
						return;
					} else {
						System.out.println("잘못입력하셨습니다.");
						return;
					}

				} else {
					System.out.println("정보가 일지하지 않습니다.");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void InBody() {

		System.out.println("======================= InBody =====================");
		System.out.print("성별(남/여) : ");
		char gender = sc.nextLine().charAt(0);

		System.out.print("몸무게 : ");
		double weight = sc.nextDouble();

		System.out.print("키 : ");
		double height = sc.nextDouble();

		while (true) {
			System.out.println("=============================================");
			System.out.println("궁금하신 메뉴를 선택해주세요");
			System.out.println("1. 표준체중");
			System.out.println("2. BMI");
			System.out.println("3. 체지방량");
			System.out.println("4. 프로그램을 종료합니다.");
			System.out.print("번호를 입력해주세요 : ");

			int mainMenu = sc.nextInt();
			sc.nextLine();

			switch (mainMenu) {

			case 1:
				Double standardWeight = (((height / 100) * (height / 100)));
				if ((gender == '남')) {
					System.out.printf(" 남성 표준 체중은 :" + " %.2f ", standardWeight * 22);
					System.out.println();
				} else if ((gender == '여')) {
					System.out.printf(" 여성 표준 체중은 :" + " %.2f ", standardWeight * 21);
					System.out.println();
				}
				break;

			case 2:
				Double BMI = weight / (((height / 100) * (height / 100)));
				System.out.printf(" 평균 BMI는 :" + " %.2f ", BMI);
				System.out.println();
				break;

			case 3:
				Double FatMass = weight - ((1.10 * weight)
						- (128 * (((weight / 100) * (weight / 100)) / ((height / 100) * (height / 100)))));
				if ((gender == '남')) {
					System.out.printf(" 남성 체지방량은 :" + " %.2f ", FatMass);
					System.out.println();
				} else if ((gender == '여')) {
					System.out.printf(" 여성 체지방량은 :" + " %.2f ", FatMass);
					System.out.println();
				}
				break;

			case 4:
				System.out.println("시스템을 종료합니다.");
				return;
			}
		}
	}

	public void LottoNumber() {

		int[] num = new int[6];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 45 + 1);

			for (int j = 0; j < i; j++) {

				if (num[i] == num[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < num.length; i++) {
			Arrays.sort(num);
			System.out.print(num[i] + ",");
		}
	}
}
