package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.owner = owner;
		memberList = new ArrayList<User>();
		channelList = new ArrayList<Channel>();
		memberList.add(owner);
		addUser(owner);
		owner.addJoinedServersList(this);
		addUser(owner);
		setName(name);
		
		if (template == TemplateType.BASIC) {
			addChannel(owner, "general");
		} else if (template == TemplateType.GAMING) {
			addChannel(owner, "gaming");
		} else if (template == TemplateType.STUDY) {
			addChannel(owner, "homework-help");
		}
	}
	
	public Channel addChannel(User user, String channelName) {
		if (user == owner) {
			Channel newChannel = new Channel(channelName);
			channelList.add(newChannel);
			return newChannel;
		}
		return null;
	}
	
	public User addUser(User user) {
		if (!memberList.contains(user)) {
			memberList.add(user);
			user.addJoinedServersList(this);
			return user;
		}
		return null;
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		if (kicker != owner) {
			throw new Exception();
		} else if (!memberList.contains(kicked) || kicked == owner) {
			return false;
		} else {
			kicked.getJoinedServersList().remove(this);
			memberList.remove(kicked);
			return true;
		}
	}
	
	public boolean isMemberInServer(User user) {
		return memberList.contains(user);
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = owner.getName() + " home";
		} else {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}
}
