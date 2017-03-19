package chapter3.creativity;

import java.util.Arrays;

public class Player {

	private int playerNumber;
	private Player[] meetingRecord = new Player[999];
	private int totalMeeting;

	public Player() {
		super();
	}

	public Player(int playerNumber) {
		super();
		this.playerNumber = playerNumber;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public Player[] getMeetingRecord() {
		return meetingRecord;
	}

	public void setMeetingRecord(Player[] meetingRecord) {
		this.meetingRecord = meetingRecord;
	}

	public int getTotalMeeting() {
		return totalMeeting;
	}

	public void setTotalMeeting(int totalMeeting) {
		this.totalMeeting = totalMeeting;
	}

	public void meeting(Player i) {
		this.meetingRecord[this.totalMeeting] = i;
		this.totalMeeting++;
		i.meetingRecord[i.totalMeeting] = this;
		i.totalMeeting++;
	}

	@Override
	public String toString() {
		return "Player Number: " + this.playerNumber + "\n Total meet of the Player: " + this.totalMeeting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(meetingRecord);
		result = prime * result + playerNumber;
		result = prime * result + totalMeeting;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (!Arrays.equals(meetingRecord, other.meetingRecord))
			return false;
		if (playerNumber != other.playerNumber)
			return false;
		if (totalMeeting != other.totalMeeting)
			return false;
		return true;
	}

}
