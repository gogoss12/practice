package streamtest;

public class User {
	
	private String name;
	private int money;
	private int atk;

	
	public User() {
		
	}
	
	public User(String name, int money, int atk) {
		this.name = name;
		this.money = money;
		this.atk = atk;
	}

	public void Battle(Monster monster) {
		if(atk > monster.getatk()) {
			money += monster.getReward();
		}
		
	}
}
