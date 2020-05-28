public class Key extends InventoryItem{
	private String roomIWorkIn;
	private String directionIWorkIn;
	public Key(String name, String description, String roomIWorkIn, String directionIWorkIn){
		super(name, 0.3, description);
		this.roomIWorkIn = roomIWorkIn;
		this.directionIWorkIn = directionIWorkIn;
	}
	public String getRoom(){
		return roomIWorkIn;
	}
	public String getDircetion(){
		return directionIWorkIn;
	}
	public String getDescription(){
		return super.getDescription() + "\n" + getRoom();
	}
}
