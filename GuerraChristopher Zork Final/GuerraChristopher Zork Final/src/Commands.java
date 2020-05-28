import java.util.*;

//import the needed libraries HINT you will need a scanner 



/*
* In Checkpoint 2, we are going to Stub the methods for your game.
* Do not try to make the actual responses, create rooms, objects, etc...
* We will be learning more about objects, arrays, and more throughout the semester
* 
* Once you have complete all the methods in this Class, be sure to test
* them out thoroughly.  Test all of the commands, try them in UPPERCASE,
* LOWERCASE, and MixeDCAse.
*/


/*
* Create a class called:  Commands
* it must be named exactly that
* be sure to add the ending } at the end of this file
*/
public class Commands{

	private static int row = 0;
	private static int column = 2;
	private static int rcSum;
	
	static Player user = new Player();
	
	static Enemy darkBot = new Enemy(10, 5, 50 , 25);
	
	static Enemy bossBot = new Enemy(40, 4, 75, 25);
	static Room[][] map = new Room[5][5];
	static Room currentRoom;
	
	static Key govKey = new Key("Goverment Key Card", "Use this card to enter into the lobby of the government building", "Front of Government Building", "South");
	
	static Weapon laserBlaster = new Weapon("Laser Blaster", 3.0, "Use this weapon to defeat your enemies", 5, 20, 60);
	
	static Consumable firstAidKit = new Consumable("First Aid Kit", 2.0, "Use this to restore you health", 10);
	
	static Consumable stimpak = new Consumable("Stimpak", 1.0, "Use this to restore a little health", 5);
	
	static Weapon laserSword = new Weapon("Laser Sword", 5.0, "Use this weapons to slice and dice through your enemies", 8, 10, 90);

	static ArrayList<InventoryItem> haven = new ArrayList<>();
	
	static ArrayList<InventoryItem> closet = new ArrayList<>();
	/*, 
* Main Method is used only to initiate your code.  Often times, the main method 
* is only to test your class, but we currently use it as our mechanism to run your program
* DO NOT CHANGE OR ADD TO THIS METHOD
*/
	public static void main(String[] args) {
		//Calls start to game, nothing else should be in here
  
		//DO NOT TOUCH THIS AREA
		runGame();
		
		
	}
	
	
	

	
/*
* Method "gameIntro" that is the text for the game intro
* You will populate the string with however your story
* begins
* @return the string that sets the stage for your game
*/

public static String gameIntro(){
	String intro = "You have awoken in the a dark alley, and you do not rember how you got there. You are surronded by walls on all sides except for the south side, which leads to the middle of a street.\n";
	return intro;
}
	
public static String walkthrough() {
	String walkthrough = "In order to win the game, you must go south then east, where you can get a weapon and heals. Then go west twice, where you will encounter an enemy which you will have to fight to unlock the key card into the building. Then go east, and then south. There, you must use your key to enter the building. Then go south twice to enter a closet, where you can upgrade your weapon. After that, you must go north, and then west twice to encounter the boss. Once you defeat the boss, you win the game. If you need help with the commands are how fighting works, type help.";
	return walkthrough;
}
	
/*
* getFirstWord should pull the first word out of any phrase (1 or more words)
* @param a string that contains the commands from the user
* @return a string that is only the first word with no spaces, returns a blank string if nothing entered
*/
	
public static String getFirstWord(String phrase){
	String first = "";
	if(phrase.indexOf(" ")>-1){
		first = phrase.substring(0, phrase.indexOf(" "));
	}else{
		first = phrase;
	}
	return first;
}

	
	
	
	

/*
* Method named "getRestOfSentence" removes the first word out of any phrase and returns what is left
* @param a string that contains the phrase from the user
* @return a string that is everything after the first word and the space that follows
*         if only 1 word is entered, this returns an empty string ""
*/

public static String getRestOfSentence(String phrase){
	String rest = "";
	if(phrase.indexOf(" ")>-1){
		rest = phrase.substring(phrase.indexOf(" ")+1);
	}else{
		rest = "";
	}
	return rest;
}
	
	
	
	
	

/*
* Method named "north" to state that you moved North	
* @return a string that states "You moved North." 	
*/

public static String north(){
	if(currentRoom.getCanGoNorth()){
		row--;
		updateRoom();
		return "You moved North.";
	}
	else{
		return"You cannot move North.";
	}
}

	
	
	

/*
* Method named "south" to state that you moved South
* @return a string that states "You moved South."
*/	

public static String south(){
	if(currentRoom.getCanGoSouth()){
		row++;
		updateRoom();
		return "You moved South.";
	}
	else{
		return"You cannot move South.";
	}
}
	
	
	
/*
* Method named "east" to state the you moved East
* @return a string that states "You moved East."
*/	

public static String east(){
	if(currentRoom.getCanGoEast()){
		column++;
		updateRoom();
		return "You moved East.";
	}
	else{
		return"You cannot move East.";
	}
}
	
	
	

/*
* Method named "west" to state the you moved West
* @return a string that states "You moved West."
*/

public static String west(){
	if(currentRoom.getCanGoWest()){
		column--;
		updateRoom();
		return "You moved West.";
	}
	else{
		return"You cannot move West.";
	}
}
	
	
	
/* Method named "take" that allows you to take an approved item
* eventually this will only pick up an item that is present in a room 
* where you are present
*  @param takes in a string to determine what object was picked up
*  @return a string that states "You took the {itemName}."
*/	


	
	
	
	
	
/* Method named "drop" that allow you to drop an approved item
* eventually this will go through your inventory and drop the item
*  @param takes in a string to determine what object was dropped
*  @return a string that states "You dropped the {itemName}"
*/	


	
	
	
	
/* Method named "look" to allow you to look around the room
* This will change to the room description eventually
*  @return a string that states "You looked around the room."
*/	

public static String look(){
	if(!currentRoom.getSecondLook())
		return (currentRoom.getDescription() + "\nThe objects in this room are " + currentRoom.getNameOfObjectsInRoom());
	else
		return (currentRoom.getSecondDescription() + "\nThe objects in this room are " + currentRoom.getNameOfObjectsInRoom());
}
	
	
	
/* Method named "inventory" to display the items in your inventory
* This will eventually include the names of the items in our inventory
*  @return a string that says "The current items in your inventory are: "
*/	

public static String inventory(){
	return ("The current items in your inventory are: " + user.inventoryItems());
}
	
	
	
	
/* Method named "examine" that returns the description on an item in your inventory
*  eventually this will give a description of the item
*  @param takes in a string to determine what item you want the description of
*  @return a string that says "Description of {itemName}."
*/	

public static String examine(InventoryItem item){
	if(user.checkItem(item)){
		return (item.getDescription());
	}
	else{
		return "You cannot examine items that are not in your inventory";
	}
}
	
	
	
	

/* Method named "eat" that allows you to eat an item it
*  it will eventually remove it from your inventory, but not drop it in the room
*  if you add health, you would update that here
*  @param takes in a string to determine what item you want to eat
*  @return a string that states "You ate the {itemName}."
*/	

public static String use(InventoryItem item){
	if(user.checkItem(item)){
		if(item instanceof Consumable){
			user.dropItem(item);
			if(((Consumable)item).getHealth() + user.getCurrentHealth() <= user.getMaxHealth()){
				user.changeHealth(((Consumable)item).getHealth());
				return ("You used the " + item + "\nYou gained " + ((Consumable)item).getHealth() + " health.");
			}
			else{
				user.setHealth(user.getMaxHealth());
				return("You used the " + item + "\nYou are now at full health."); 
			}
		}
		else if(item instanceof Key){
			if(currentRoom.getName().equals(((Key)item).getRoom())){
				if(((Key)item).getDircetion().equals("North")){
					currentRoom.setCanGoNorth(true);
				}
				else if(((Key)item).getDircetion().equals("East")){
					currentRoom.setCanGoEast(true);
				}
				else if(((Key)item).getDircetion().equals("South")){
					currentRoom.setCanGoSouth(true);
				}
				else{
					currentRoom.setCanGoWest(true);
				}
				return "You used the key to unlock the room " + ((Key)item).getDircetion();
			}
			else{
				return "This key does not work in this room";
			}
		}
		else{
			return "You cannot use this item";
		}
	}
	else{
		return "You cannot use items that are not in your inventory";
	}
}
	
	
	
	
	

/* Method named "use" that allows you to use an item it
*  it will eventually trigger an event when used in the proper room only
*  The room trigger will be implemented later
*  @param takes in a string to determine what item you want to use
*  @return a string that says "You used the {itemName}."
*/	


	
	
	
	
/*Method named "help" that returns all of the commands and what they do
*  refer to student handout for required methods: hint they are stubbed in this file
* 	@return the all the command names, an example of it being used, and a description of what they do
*/

public static String help(){
	return ("Command      Example          Description\nNorth        north            you move north\nSouth        south            you move south\nEast         east             you move east\nWest         west             you move west\nTake         take bread       take an item\nDrop         drop bread       drop an item in your inventory\nLook         look             look around the area\nInventory    inventory        shows your inventory\nExamine      examine bread    examines an item\nEat          eat bread        you eat an item\nUse          use blaster      uses an item in your inventory\nQuit         quit             leaves the game\nHelp         help             provides a list of what each command does\nCombat        In combat, you have three options; attack, critical, or heal. If you choose attack, you are attacking you oppenent with no stat boosts. If you choose to critical, you are choosing to decrease your accuracy for the turn, and increaes your chance of a critical hit for the turn. If you choose heal, you will gain five health, but not be able to attack for that turn. You will always attack first.");
}
		
		
		
		

/*Method named "quit" that allows states you have quit your game
* 	@return a message that says "You have decided to quit the game."
*/

public static String quit(){
	return ("You have decided to quit the game.");
}
	
	
	
/*Method named "invalid" that produces the invalid response
* 	@return a message thats says "I do not understand."
*/

public static String invalid(){
	return ("I do not understand.");
}
	
	
	
/*
* This method "executeCommand" uses the first word to determine the appropriate method
* to call.  It is just meant to pass the work to the proper method
* @param  it needs the String command and the String item
* @return a String passed back from a method called inside this method 
*/
public static String executeCommand(String command){
	String word = "";
	if (command.equals("north")){
		word = north();
	}
	else if (command.equals("south")){
		word = south();
	}
	else if (command.equals("east")){
		word = east();
	}
	else if (command.equals("west")){
		word = west();
	}
	else if (command.equals("look")){
		word = look();
	}
	else if (command.equals("inventory")){
		word = inventory();
	}
	else if (command.equals("help")){
		word = help();
	}
	else if (command.equals("quit")){
		word = quit();
	}
	else if(command.equals("stats")){
		word = stats();
	}
	else{
		word = invalid();
	}
	return word;
}		
public static String executeCommand(String command, InventoryItem item){
	String word = "";
	if (command.equals("take")){
		word = take(item);
	}
	else if (command.equals("drop")){
		word = drop(item);
	}
	else if (command.equals("examine")){
		word = examine(item);
	}
	else if (command.equals("use")){
		word = use(item);
	}
	else{
		word = invalid();
	}
	return word;
}		
		
		
	public static String drop(InventoryItem item){
		if(user.checkItem(item)){
			user.dropItem(item);
			currentRoom.drop(item);
			return "You droppped the " + item + ".";
		}
		else{
			return "You cannot drop this item because it is not in your inventory.";
		}
	}
	public static String take(InventoryItem item){
		if(currentRoom.checkItem(item)){
			if(user.checkWeight(item)){
				if(item instanceof Weapon){
					if(user.checkWeapon()){
						currentRoom.add(item);
						user.addItem(item);
						String temp = "You picked up the " + item + ". This weapon changed your attack by " + (((Weapon)item).getAttack()-user.getAttack()) + ".\nThis weapon changed your critical by " + (((Weapon)item).getCritical()-user.getCritical()) + ".\nThis weapon changed your accuracy by " + (((Weapon)item).getAccuracy()-user.getAccuracy());
						user.setAttack(((Weapon)item).getAttack());
						user.setCritical(((Weapon)item).getCritical());
						user.setAccuracy(((Weapon)item).getAccuracy());
						return temp;
					}
					else{
						return "You cannot hold more than one weapon at a time";
					}
				}
				else{
					currentRoom.add(item);
					user.addItem(item);
					return "You picked up the " + item + ".";
				}
			}
			else{
				return "You cannot pick up this item because you cannot hold this much weight";
			}
		}
		else{
			return "You cannot pick up this item because it is not in the room.";
		}
	}
		
		
	
/*
* Create a method called "runGame"
* This method officially runs your game.  We don't put this in the main method
* because we will learn later that we want to be able to reference it from other
* classes.  there are no parameters or return variables for this method and 
* the name must match the one in the main method.	
*  
* This method must: 
*    repeatedly get an input from the user  
*    break up the input utilizing the methods from above (abstraction)
*    pass the user input to the appropriate method from above
*    stop the game from running when "quit" is entered
*/
public static void updateRoom(){
	currentRoom = map[row][column];
	System.out.println(currentRoom.getName());
	System.out.println(currentRoom.getDescription());
}

public static String stats(){
	return ("Health: " + user.getCurrentHealth() + "\nAttack: " + user.getAttack() + "\nAccuracy: " + user.getAccuracy() + "\nCritical: " + user.getCritical());
}
public static Room getCurrentRoom(){
	return currentRoom;
}

public static void initializeMap(){
	haven.add(firstAidKit);
	haven.add(laserBlaster);
	closet.add(stimpak);
	closet.add(laserSword);
	map[0][0] = new Room();
	map[0][1] = new Room();
	map[0][2] = new Room(false, false, true, false, "Alley", "You are in the corner of an alley, surrounded by brick on all sides of you except of south. To the south, you can see an abandoned street, with light posts flickering on and off.");
	map[0][3] = new Room();
	map[0][4] = new Room();
	map[1][0] = new Room();
	map[1][1] = new Room(false, true, false, false, "Dark Alley", "You enter into a dark alley, and you start to make out the outline of an old, seemingly broken down robot holding a government key card. As you approach the robot to better examine it, it suddenly is filled with life, and you are sent stumbling back in astonishment. As you regain your balance, you look at the robot and see the infamous government logo over its chest. As soon as you realize this, the robot lunges at you, ready to fight.", govKey, darkBot, "You are in a dark alley, with walls surronding you on all sides except for the east. You can see the remains of the government robot that you just destroyed, and can see that it dropped a government key card.");
	map[1][2] = new Room(true, true, true, true, "Street", "You enter into the middle of an empty, barren street. You can see to your west a dark and suspicious looking alley. To your east, you can see a safe haven for the survivors of this robot apocalypse.  To your south, you can see the entrance of the government building with the mainframe controlling all of the robots.");
	map[1][3] = new Room(false, false, false, true, "Refuge Safe Haven", "When you enter into the safe haven, you are warmly greeted by fellow survivors of the robot onslaught that the government had created. They have offered you gifts of a first aid kit and a laser balster so that you my keep safe in this dangerous world. They allow you to stay at the refuge for as long as you like. You are surrounded by walls on all sides except for the west, which leads back into the street.", haven);
	map[1][4] = new Room();
	map[2][0] = new Room();
	map[2][1] = new Room();
	map[2][2] = new Room(true, false, false, false, "Front of Government Building", "As you approach the front of the government building, you notice that it is one of the few buildings left that is still in good condition. You notice that the door to enter the building is locked with a key card system. There are fences on the east and west sides of the entrance, so getting inside through a back way is not an option.");
	map[2][3] = new Room();
	map[2][4] = new Room();
	map[3][0] = new Room(false, true, false, false, "Mainframe Server Room", "You wearily enter into the mainframe server room, unsure of what might be guarded the heart of all of the robots. When you enter the room, you can see the mainframe and the end of the room. In excitement, you start to run over to it to quickly destroy it. As you are running, you get knocked to ground from an object that suddenly appeared in front of your path. As you stand back up, you notice that the object that knocked you down was a government robot. But this wasn’t just any robot; this robot was at least twice as big as the one that you encountered in the dark alley. You quickly draw your weapon to defeat it, knowing that it is the only thing standing between you and the destruction of all of the government robots.", bossBot);
	map[3][1] = new Room(false, true, false, true, "Hallway", "As you walk down the hallway, you notice a sign at the end of the hallway to the east the reads “Mainframe Server Room.” You can see lights flashing on and off in the room through the small window on the door. There are no doors or passageways to your south or north, but you do notice a first aid kit hanging on the side of the wall in the hallway.", firstAidKit);
	map[3][2] = new Room(true, false, true, true, "Government Building Lobby", "You wearily enter into the government building, fearing that it may be guarded with some of the government guard robots. To your surprise, there is nobody in the lobby, and the building is eerily quiet. To your south, you can see a dark closet with the door slightly cracked open. To your west, you see a hallway with a directory saying that it leads the mainframe. There is also a door north, which you just entered from. There is a wall blocking you from going to the east.");
	map[3][3] = new Room();
	map[3][4] = new Room();
	map[4][0] = new Room();
	map[4][1] = new Room();
	map[4][2] = new Room(true, false, false, false, "Closet", "You enter into a small, dark room filled with cabinets and buckets filled with random stuff. You think you see a stimpak and a laser sword hidding in some cabinets.", closet);
	map[4][3] = new Room();
	map[4][4] = new Room();
	currentRoom = map[row][column];
}
public static void runGame(){
	boolean run = true;
	System.out.println(walkthrough());
	System.out.print(gameIntro());
	
	initializeMap();
	
	
	
	while(run){
		rcSum = row + column;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nInput a command.");
		String phrase = scan.nextLine();
		String first = getFirstWord(phrase);
		first = first.toLowerCase();
		String rest = getRestOfSentence(phrase);
		rest = rest.toLowerCase();
		String output = "";
		phrase = getFirstWord(phrase);
		phrase = phrase.toLowerCase();
		if(phrase.equals("quit")){
			run = false;
		}else if(rest.equals("laser sword")){
			output = executeCommand(first, laserSword);
			System.out.println(output);
		}else if(rest.equals("laser blaster")){
			output = executeCommand(first, laserBlaster);
			System.out.println(output);
		}else if(rest.equals("first aid kit")){
			output = executeCommand(first, firstAidKit);
			System.out.println(output);
		}else if(rest.equals("stimpak")){
			output = executeCommand(first, stimpak);
			System.out.println(output);
		}else if(rest.equals("government key card")){
			output = executeCommand(first, govKey);
			System.out.println(output);
		}else if(rest.equals("")){
			output = executeCommand(first);
			System.out.println(output);
		}else{
			output = invalid();
			System.out.println(output);
		}
		if(currentRoom.getFight()){
			System.out.println("You are about to engage in combat. Prepare to fight!");
		}
		while(currentRoom.getFight()){
			System.out.println("You have " + user.getCurrentHealth() + " health. The enemy has " + currentRoom.getEnemyHealth() + " health.");
			System.out.println("It is your turn in the fight. What shall you choose to do? Attack, Critical, or Heal?");
			Boolean choosing = true;
			while(choosing){
				String attackChoice = scan.nextLine();
				attackChoice = attackChoice.toLowerCase();
				if(attackChoice.equals("attack")){
					System.out.println("You have chosen attack");
					choosing = false;
					if((((int)(Math.random() * 100))+1) <= user.getAccuracy()){
						System.out.println("Your attack has hit! You dealt " + user.getAttack() + " damgage.");
						currentRoom.changeEnemyHealth((-1)*(user.getAttack()));
					}else {
						System.out.println("Your attack missed! You dealt no damage.");
					}
				}
				else if(attackChoice.equals("critical")){
					System.out.println("You have chosen critical");
					choosing = false;
					if((((int)(Math.random() * 100))+1) <= user.getAccuracy() * (user.getCritical()*0.01)){
						System.out.println("Your critical attack has hit! You dealt " + (int)Math.round(user.getAttack()*1.5) + " damgage.");
						int temp = (int)Math.round(user.getAttack()*1.5);
						currentRoom.changeEnemyHealth((-1)*(temp));
					}else {
						System.out.println("Your critical attack missed! You dealt no damage.");
					}
				}
				else if(attackChoice.equals("heal")){
					user.changeHealth(5);
					System.out.println("You have chosen heal. You have gained 5 health.");
					choosing = false;
				}
				else if(attackChoice.equals("help")) {
					System.out.println("In combat, you have three options; attack, critical, or heal. If you choose attack, you are attacking you oppenent with no stat boosts. If you choose to critical, you are choosing to decrease your accuracy for the turn, and increaes your chance of a critical hit for the turn. If you choose heal, you will gain five health, but not be able to attack for that turn. You can not gain more health than your maximum health. You will always attack first.");
					choosing = true;
				}
				else{
					System.out.println("Invalid choice. Please try again");
				}
			}
			int enemyChoice = (int)(Math.random() * 3);
			if(enemyChoice == 1){
				System.out.println("The enemy has chosen to attack!");
				if((((int)(Math.random() * 100))+1) <= currentRoom.getEnemyAccuracy()){
					System.out.println("The enemy's attack has hit! You are dealt " + currentRoom.getEnemyAttack() + " damgage.");
					user.changeHealth((-1)*(currentRoom.getEnemyAttack()));
				}else {
					System.out.println("The enemy's attack missed! You are dealt no damage.");
				}
			}
			else if(enemyChoice == 2){
				System.out.println("The enemy has chosen critical!");
				if((((int)(Math.random() * 100))+1) <= currentRoom.getEnemyAccuracy()*(currentRoom.getEnemyCritical()*0.01)){
					System.out.println("The enemy's critical attack has hit! You are dealt " + (int)Math.round(currentRoom.getEnemyAttack()*1.5) + " damgage.");
					int temp = (int)Math.round(currentRoom.getEnemyAttack()*1.5);
					user.changeHealth((-1)*(temp));
				}else {
					System.out.println("The enemy's critical attack missed! You are dealt no damage.");
				}
			}
			else{
				currentRoom.changeEnemyHealth(5);
				System.out.println("The enemy has chosen heal. They have gained 5 health.");
			}
			if(user.getCurrentHealth() <= 0){
				System.out.println("You have died.");
				run = false;
				currentRoom.switchFight();
			}else if(currentRoom.getEnemyHealth() <= 0){
				if(bossBot.getCurrentHealth() <= 0){
					System.out.println("You have defeated the boss and destroyed the mainframe, saving the city. Congratulations, you won!");
					run = false;
				}else{
					System.out.println("You have defeated the enemy. You can now move on from this room, or continue to look around for items.");
					currentRoom.switchSecondLook();
				}
				currentRoom.switchFight();
			}
		}
		}
	}
}