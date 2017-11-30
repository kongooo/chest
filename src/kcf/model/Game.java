package kcf.model;

import java.util.ArrayList;

public class Game {

	private Player player1;
	private Player player2;
	private ArrayList<Ship> ships;
	private Map theMap;
	private FileReader fr;

	public Game() {
		try {
			setShips();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map getTheMap() {
		return theMap;
	}

	public void setTheMap(Map theMap) {
		this.theMap = theMap;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	private void setShips() throws Exception {
		fr = new FileReader();
		ships = new ArrayList<Ship>();
		String[] details;
		details = new String[12];
		for (String theline : this.fr.getLines()) {
			details = theline.split(",");
			Ship theship = new Ship();
			theship.setShipName(details[0]);
			theship.setShipId(Integer.valueOf(details[1]).intValue());
			theship.setCannonPower(Integer.valueOf(details[2]).intValue());
			theship.setDefense(Integer.valueOf(details[3]).intValue());
			theship.setTorpedoPower(Integer.valueOf(details[4]).intValue());
			theship.setEndurance(Integer.valueOf(details[5]).intValue());
			theship.setAttackDistance(Integer.valueOf(details[6]).intValue());
			theship.setTorpedoDistance(Integer.valueOf(details[7]).intValue());
			theship.setMoveDistance(Integer.valueOf(details[8]).intValue());
			theship.setDodge(Integer.valueOf(details[9]).intValue());
			theship.setType(details[10]);
			theship.setShipFirstName(details[11]);
			ships.add(theship);
		}
	}
}
