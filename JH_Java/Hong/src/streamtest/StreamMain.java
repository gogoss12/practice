package streamtest;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.management.remote.SubjectDelegationPermission;

public class StreamMain {

	public static void main(String[] args) {

		ArrayList<Monster> monsters =new ArrayList<Monster>();
		
		for(int i = 1; i <= 100; i++) {
			monsters.add(new Monster("몬스터"+i, (int)(Math.random() * 100) +1, (int)(Math.random() * 100) +1));
		};
		//1. 모든 몬스터 뽑아보기
//		monsters.stream().forEach(m -> System.out.println(m));
		
		//2. 공경력이 50이상인 몬스터만
//		monsters.stream().filter(a -> a.getatk() >= 50).forEach(m -> System.out.println(m));
		
		//3. 공격력이 50이상이면서 보상도 50이상
		monsters.stream()
		.filter(a -> a.getatk() >= 50)
		.filter(a -> a.getReward() >= 50)
		.forEach(m -> System.out.println(m));
		
		//4. 3번의 개수
		System.out.println(
		monsters.stream()
		.filter(a -> a.getatk() >= 50)
		.filter(a -> a.getReward() >= 50)
		.count());

		
		int[] sumAtk = {0};
	      monsters.stream().forEach(m -> sumAtk[0] += m.getatk());
	      avg = sumAtk[0]/(double)monsters.size();
	      System.out.println("공격력 평균  : " + avg);
	      
	      
	      int[] sumReward = {0};
	      monsters.stream().forEach(m -> sumReward[0] += m.getReward());
	      System.out.println("보상 합계  : " + sumReward[0]);
	}
}
