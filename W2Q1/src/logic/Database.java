package logic;

import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	public Database() {
		playerList = new ArrayList<Player>();
		regionList = new ArrayList<Region>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		this.playerList = playerList;
		this.regionList = regionList;
	}
	
	public Player addPlayer(String name, Region region) throws Exception {
		if (DatabaseUtil.isPlayerExists(playerList, name)) {
			throw new Exception();
		}
		
		Player newPlayer = new Player(name);
		playerList.add(newPlayer);
		region.addPlayerToRegion(newPlayer);
		return newPlayer;
	}
	
	public boolean addRegion(String name) {
		if (!DatabaseUtil.isRegionExists(regionList, name)) {
			regionList.add(new Region(name));
			return true;
		}
		return false;
	}
	
	public Region getRegionByName(String name) {
		for (Region region : regionList) {
			if (region.getName() == name) {
				return region;
			}
		}
		return null;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		region.addQuestToRegion(new Quest(author, region, name, description));
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}
}
