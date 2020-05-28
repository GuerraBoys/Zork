
//TODO: Create a public class named "Room"   
import java.util.*;
public class Room{

	/*
	 *TODO:  Create the following private instance variables: 
	 *
	 * canGo<Direction> - type Boolean - stores the ability to move in a given direction
	 *  <Direction> should be replaced with North, South, East, West (example, canGoEast)
	 * description - type String - will store the description of the Room
	 * name - type String - will store the name of the Room
	 * be sure to encapsulate aka make you fields private
	 */
	
	private boolean canGoNorth;  //canGoNorth is completed for you
	private boolean canGoEast;
	private boolean canGoSouth;
	private boolean canGoWest;
	private String description;
	private String secondLookDescription;
	private String name;
	private ArrayList<InventoryItem> items;
	private Enemy enemy;
	private boolean fight = false;
	private boolean secondLook = false;

	
	
	
	
	/**
	 * Default Room constructor
	 * sets all canGo<Direction> fields to false  (i.e.  canGoSouth = false)
	 * sets the name of the room to "Not a room"
	 * sets the description of the room to "This is not a room, you shouldn't be here!!!"
	 */
	 
	 //TODO: make the Room default constructor

	public Room(){
		canGoNorth = false;
		canGoEast = false;
		canGoSouth = false;
		canGoWest = false;
		name = "Not a room";
		description = "This is not a room, shouldn't be here!!!";
	}






	
	/**
	 * Custom Room constructor 
	 * this allows the client code to build a Room a room with custom parameters
	 * populates all fields using parameters
	 * 
	 * @param canGoNorth
	 * @param canGoSouth
	 * @param canGoEast
	 * @param canGoWest
	 * @param name
	 * @param description
	 */
	 
	 //TODO: make the custom Room constructor


	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description){
		this.canGoNorth = canGoNorth;
		this.canGoEast = canGoEast;
		this.canGoSouth = canGoSouth;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		items = new ArrayList<>();
	}
	
	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description, Enemy enemy){
		this.canGoNorth = canGoNorth;
		this.canGoEast = canGoEast;
		this.canGoSouth = canGoSouth;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		items = new ArrayList<>();
		this.enemy = enemy;
		fight = true;
	}
	
	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description, InventoryItem item){
		this.canGoNorth = canGoNorth;
		this.canGoEast = canGoEast;
		this.canGoSouth = canGoSouth;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		items = new ArrayList<>();
		items.add(item);
	}

	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description, InventoryItem item, Enemy enemy, String secondLookDescription){
		this.canGoNorth = canGoNorth;
		this.canGoEast = canGoEast;
		this.canGoSouth = canGoSouth;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		this.secondLookDescription = secondLookDescription;
		items = new ArrayList<>();
		items.add(item);
		this.enemy = enemy;
		fight = true;
	}
	
	public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String name, String description, ArrayList<InventoryItem> list){
		this.canGoNorth = canGoNorth;
		this.canGoEast = canGoEast;
		this.canGoSouth = canGoSouth;
		this.canGoWest = canGoWest;
		this.name = name;
		this.description = description;
		items = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			items.add(list.get(i));
		}
	}

	public String getNameOfObjectsInRoom(){
		if(items.size() == 0) {
			return "none";
		}
		String temp = "";
		for(int i = 0; i  < items.size(); i ++){
			temp += items.get(i) + "\n";
		}
		return temp;
	}
	
	public Boolean hasObject(InventoryItem item){
		return items.contains(item);
	}
	
	public Boolean getFight(){
		return fight;
	}
	public void switchFight(){
		fight = false;
	}
	/**
	 * Accessor method called getDescription
	 * It gets the room description
	 * @return the description
	 */
	 
	 //TODO: make the getDescription method

	public String getDescription(){
		return description;
	}
	


	
	/**
	 * Accessor method called getName
	 * It gets the room name
	 * @return the name
	 */
	 
	 //TODO: make the getName method

	public String getName(){
		return name;
	}



	
	/**
	 * Mutator method called setDescription
	 * It updates the room description
	 * @param d is the description of the room
	 */
	 
	 //TODO: make the setDescription method

	public void setDescription(String description){
		this.description = description;
	}



	
	/**
	 * Mutator method called setName
	 * It updates the room name
	 * @param n is the name you want the room to have
	 */
	 
	 //TODO: make the setName method


	public void setName(String name){
		this.name = name;
	}


	
	
	/**
	 * Accessor method called getCanGoNorth
	 * used to determine if the player can move North
	 * @return the value of canGoNorth
	 */
	 
	 //TODO: make the getCanGoNorth method

	public boolean getCanGoNorth(){
		return canGoNorth;
	}



	

	/**
	 * Accessor method called getCanGoSouth
	 * used to determine if the player can move South
	 * @return the value of canGoSouth
	 */
	 
	 //TODO: make the getCanGoSouth method

	public boolean getCanGoSouth(){
		return canGoSouth;
	}



	
	/**
	 * Accessor method called getCanGoEast
	 * used to determine if the player can move East
	 * @return the value of canGoEast
	 */
	 
	 //TODO: make the getCanGoEast method

	public boolean getCanGoEast(){
		return canGoEast;
	}



	
	/**
	 * Accessor method called getCanGoWest
	 * used to determine if the player can move West
	 * @return the value of canGoWest
	 */
	 
	 //TODO: make the getCanGoWest method

	public boolean getCanGoWest(){
		return canGoWest;
	}



	
	/**
	 * Mutator method called setCanGoNorth
	 * used to change the ability to move North
	 * @param b a boolean value that changes the canGoNorth field
	 */
	 
	 //TODO: make the setCanGoNorth method

	public void setCanGoNorth(boolean canGoNorth){
		this.canGoNorth = canGoNorth;
	}




	/**
	 * Mutator method called setCanGoSouth
	 * used to change the ability to move South
	 * @param b a boolean value that changes the canGoSouth field
	 */
	 
	 //TODO: make the setCanGoSouth method

	public void setCanGoSouth(boolean canGoSouth){
		this.canGoSouth = canGoSouth;
	}



	
	/**
	 * Mutator method called setCanGoEast
	 * used to change the ability to move East
	 * @param b a boolean value that changes the canGoEast field
	 */
	 
	 //TODO: make the setCanGoEast method

	public void setCanGoEast(boolean canGoEast){
		this.canGoEast = canGoEast;
	}



	
	/**
	 * Mutator method called setCanGoWest
	 * used to change the ability to move West
	 * @param b a boolean value that changes the canGoWest field
	 */
	 
	 //TODO: make the setCanGoWest method


	public void setCanGoWest(boolean canGoWest){
		this.canGoWest = canGoWest;
	}


	
	/**
	 * Accessor method called toString
	 * used to retrive the current state of the room
	 * 
	 * example output:  
	 * Kitchen
	 * There is a strange smell coming from the partially opened refrigerator door
	 * canGoNorth: true  canGoSouth: false canGoEast: false canGoWest: true
	 * 
	 * @return a String with the Room Name, Description, and the ability to move each direction 
	 * 
	 */
	 
	 //TODO: make the toString method

	public String toString(){
		return name + "\n " + description + "\ncanGoNorth: " + canGoNorth + "  canGoSouth: " + canGoSouth + "  canGoEast: " + canGoEast + "  canGoWest " + canGoWest;
	}

	public void drop(InventoryItem item){
		items.add(item);
	}
	
	public void add(InventoryItem item){
		items.remove(item);
	}
	public String tellItems(){
		String temp = "";
		for(int i = 0; i < items.size() - 1; i ++){
			temp = temp + items.get(i) + "\n";
		}
		return temp;
	}
	
	public boolean checkItem(InventoryItem item){
		return items.contains(item);
	}
	public int getEnemyHealth(){
		return enemy.getCurrentHealth();
	}
	public void changeEnemyHealth(int x){
		enemy.changeHealth(x);
	}
	public int getEnemyAccuracy(){
		return enemy.getAccuracy();
	}
	public int getEnemyAttack(){
		return enemy.getAttack();
	}
	public int getEnemyCritical(){
		return enemy.getCritical();
	}
	public void switchSecondLook() {
		secondLook = true;
	}
	public boolean getSecondLook() {
		return secondLook;
	}
	public String getSecondDescription() {
		return secondLookDescription;
	}
}
