
public class Weapon extends InventoryItem{
	private int attack;
	private int critical;
	private int accuracy;
	public Weapon(String name, double weight, String description, int attack, int critical, int accuracy){
		super(name, weight, description);
		this.attack = attack;
		this.critical = critical;
		this.accuracy = accuracy;
	}
	public int getAttack(){
		return attack;
	}
	public int getCritical(){
		return critical;
	}
	public int getAccuracy(){
		return accuracy;
	}
	public String toString(){
		return super.toString() + "\nDamage: " + getAttack() + "\nChance of Critical Hit: " + getCritical() + "%\nAccuracy: " + getAccuracy() + "%";
	}
}
