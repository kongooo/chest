package kcf.model;

import java.util.ArrayList;

public class Player {

	private int playerId;
	private ArrayList<Ship> fleet;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public ArrayList<Ship> getFleet() {
		return fleet;
	}

	public void setFleet(ArrayList<Ship> fleet) {
		this.fleet = fleet;
	}

}
