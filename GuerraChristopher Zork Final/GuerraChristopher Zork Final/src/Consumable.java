public class Consumable extends InventoryItem{
	private int heal;
	public Consumable(String name, double weight, String description, int heal){
		super(name, weight, description);
		this.heal = heal;
	}
	public int getHealth(){
		return heal;
	}
	public String toString(){
		return super.toString() + "\nHealth Value: " + heal;
	}
}
