package c09_SystemDesignAndScalability.p02_SocialNetwork;

import static java.lang.System.out;

import java.util.ArrayList;

public class _0902_01_Person {
	private ArrayList<Integer> friends = new ArrayList<Integer>();
	private int personID;
	private String info;

	public _0902_01_Person(int id) {
		this.personID = id;
	}

	public String getlnfo() {
		return info;
	}

	public void setlnfo(String info) {
		this.info = info;
	}

	public ArrayList<Integer> getFriends() {
		return friends;
	}

	public int getID() {
		return personID;
	}

	public void addFriend(int id) {
		friends.add(id);
	}
}
