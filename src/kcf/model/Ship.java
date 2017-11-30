package kcf.model;

public class Ship {

	private String shipName;
	private int shipId;
	private int cannonPower;
	private int defense;
	private int torpedoPower;
	private int endurance;
	private int presentHP;
	private int attackDistance;
	private int torpedoDistance;
	private int moveDistance;
	private int dodge;
	private String type;
	private String shipFirstName;

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public int getCannonPower() {
		return cannonPower;
	}

	public void setCannonPower(int cannonPower) {
		this.cannonPower = cannonPower;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getTorpedoPower() {
		return torpedoPower;
	}

	public void setTorpedoPower(int torpedoPower) {
		this.torpedoPower = torpedoPower;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getAttackDistance() {
		return attackDistance;
	}

	public void setAttackDistance(int attackDistance) {
		this.attackDistance = attackDistance;
	}

	public int getTorpedoDistance() {
		return torpedoDistance;
	}

	public void setTorpedoDistance(int torpedoDistance) {
		this.torpedoDistance = torpedoDistance;
	}

	public int getMoveDistance() {
		return moveDistance;
	}

	public void setMoveDistance(int moveDistance) {
		this.moveDistance = moveDistance;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

	public int getPresentHP() {
		return presentHP;
	}

	public void setPresentHP(int presentHP) {
		this.presentHP = presentHP;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShipFirstName() {
		return shipFirstName;
	}

	public void setShipFirstName(String shipFirstName) {
		this.shipFirstName = shipFirstName;
	}
}
