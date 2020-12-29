package first.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class timeMethod {

	public static void main(String[] args) {
		
		// 현재 날짜 + 시간
		LocalDateTime today = LocalDateTime.now(); 
//		System.out.println(today);
//		
//		System.out.println(today.getYear()); // 현재 년도
//		System.out.println(today.getMonth()); // 현재 월(영어)
//		System.out.println(today.getMonthValue()); // 현재 월(숫자)
//		System.out.println(today.getDayOfWeek()); // 현재 요일
//		System.out.println(today.getHour()); // 현재 시간
//		System.out.println(today.getSecond()); // 현재 분
		
		// 원하는 시간 지정
		LocalDateTime OF = LocalDateTime.of(1993, 11, 27, 15, 38);        
		
//		System.out.println(OF);
		
		//현재 시간(시, 분, 초 , 소수점)
		LocalTime hour = LocalTime.now();
//		System.out.println(hour);
		
		
		//현재 날짜(년, 월, 일)
		LocalDate day = LocalDate.now();
		System.out.println(day);
		
		
		// 그 외에 메소드는 검색해서 사용해도 충분할듯
	}
}
