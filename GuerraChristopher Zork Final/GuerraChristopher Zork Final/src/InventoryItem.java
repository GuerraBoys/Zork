
public class InventoryItem {
	private String name;
	private double weight;
	private String description;
	public InventoryItem(String name, double weight, String description){
		this.name = name;
		this.weight = weight;
		this.description = description;
	}
	public String getName(){
		return name;
	}
	public double getWeight(){
		return weight;
	}
	public String getDescription(){
		return description;
	}
	public String toString(){
		return "Item: " + name + "\nWeight: " + weight + "\nDescription: " + description;
	}
}
