import java.util.ArrayList;

public class Player {
	
	private int currentHealth;
	private int maxHealth;
	private int attack;
	private int accuracy;
	private int critical;
	private ArrayList<InventoryItem> inventory = new ArrayList<>();
	private double totalWeight;
	
	public Player(){
		currentHealth = 20;
		maxHealth = 20;
		attack = 1;
		accuracy = 75;
		critical = 10;
	}
	public Player(int health, int attack, int accuracy, int critical){
		this.maxHealth = health;
		this.currentHealth = health;
		this.attack = attack;
		this.accuracy = accuracy;
		this.critical = critical;
		totalWeight = 0.0;
	}
	public void setHealth(int health){
		if(health <= maxHealth){
			this.currentHealth = health;
		}
	}
	public void changeHealth(int health){
		if(health + currentHealth < 0){
			currentHealth = 0;
		}else if(health + currentHealth < maxHealth) {
			currentHealth += health;
		}
		else{
			currentHealth = maxHealth;
		}
	}
	public void setAttack(int attack){
		this.attack = attack;
	}
	public void setAccuracy(int accuracy){
		this.accuracy = accuracy;
	}
	public void setCritical(int critical){
		this.critical = critical;
	}
	public int getCurrentHealth(){
		return currentHealth;
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public int getAttack(){
		return attack;
	}
	public int getAccuracy(){
		return accuracy;
	}
	public int getCritical(){
		return critical;
	}
	public void addItem(InventoryItem item){
		inventory.add(item);
	}
	public void dropItem(InventoryItem item){
		inventory.remove(item);
	}
	public boolean checkItem(InventoryItem item){
		return inventory.contains(item);
	}
	public boolean checkWeight(InventoryItem item){
		return (totalWeight + item.getWeight() < 10.0);
	}
	public String inventoryItems(){
		String temp = "";
		for(int i = 0; i < inventory.size(); i ++){
			temp += inventory.get(i) + "\n\n";
		}
		return temp;
	}
	public boolean checkWeapon(){
		for(int i = 0; i < inventory.size(); i ++){
			if((inventory.get(i)) instanceof Weapon){
				return false;
			}
		}
		return true;
	}
}
