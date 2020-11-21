package Graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {
	public static void main(String[] args) {
		//https://leetcode.com/problems/keys-and-rooms/submissions/
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] isRoomVisited = new boolean[rooms.size()];
		if (rooms.size() == 0) {
			return false;
		}
		if (rooms.size() == 1) {

			return true;
		}
		vistRoom(0, rooms, isRoomVisited);
		for(Boolean visitStatus:isRoomVisited) {
			if(!visitStatus) {
				return false;
			}
		}
		return true;

	}

	private void vistRoom(int roomNumber, List<List<Integer>> rooms,boolean[] isRoomVisited) {
		isRoomVisited[roomNumber]=true;
		for (Integer roomNo : rooms.get(roomNumber)) {
			if(isRoomVisited[roomNo]!=true) {
				vistRoom(roomNo, rooms, isRoomVisited);
			}

		}
		return;
	}
}
