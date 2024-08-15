package logic;

import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		setName(name);
		playerList = new ArrayList<Player>();
		questList = new ArrayList<Quest>();	
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Nowhere";
		} else {
			this.name = name;
		}
	}
	
	public int getPlayerCount() {
		return playerList.size();
	}
	
	
	public double getRegionRank() {
		double sum = 0.0;
		for (Player player : playerList) {
			sum += player.getRank();
		}
		double average = sum/getPlayerCount();
		return (double) Math.round(average*100)/100;
	}
	
	
	public ArrayList<Quest> getAvailableQuests(Player viewer) {
		ArrayList<Quest> availableQuests = new ArrayList<Quest>();
		for (Quest quest : questList) {
			if (quest.getStatus() == Status.AVAILABLE && quest.getAuthor() != viewer) {
				availableQuests.add(quest);
			}
		}
		return availableQuests;
	}
	
	public void addPlayerToRegion(Player p) {
		playerList.add(p);
	}
	
	public void addQuestToRegion(Quest q) {
		questList.add(q);
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Quest> getQuestList() {
		return questList;
	}

	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}

	public String getName() {
		return name;
	}
}
