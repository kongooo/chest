package kcf.model;

public class Test {
	public static void main(String[] args) throws Exception {
		Game thegame=new Game();
		//thegame.setShips();
		for(Ship theship:thegame.getShips()) {
			System.out.println(theship.getShipName());
		}
	}

}
