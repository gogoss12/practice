package streamtest;

public class Monster {

	private String name;
	private int atk;
	private int reward;
	
	public Monster() {
		
	}
	
	public Monster(String name, int atk, int reward) {
		this.name = name;
		this.atk = atk;
		this.reward = reward;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getatk() {
		return atk;
	}
	public void setatk(int atk) {
		this.atk = atk;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "Monster 내 이름은 " + name + ", [공격력 : " + atk + ", 보상 : " + reward + "]";
	}
	
	
	
}
