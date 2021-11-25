package com.LabProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Location {

	public final int locationId;
	private final String description;
	private final Map<String, Integer> moves;
	private List<String> inventory;

	public Location(int locationId, String description, ArrayList<String> inventory) {
		this.locationId = locationId;
		this.description = description;
		this.moves = new HashMap<>();
		this.moves.put("Quit", -1);
		this.inventory = inventory;
	}

	// get the location id
	public int getLocation() {
		return locationId;
	}

	// Get description of location
	public String getDescription() {
		return description;
	}

	// Add a direction to the map
	public void addDirection(String direction, int location) {
		moves.put(direction, location);
	}

	public Map<String, Integer> getMoves() {
		return new HashMap<String, Integer>(moves);
	}

	// get all the players items
	public String getAllItems() {
		StringBuilder returnString = new StringBuilder();
		ListIterator<String> itemsIterator = inventory.listIterator();
		while (itemsIterator.hasNext()) {
			returnString.append(itemsIterator.next());
			if (itemsIterator.hasNext()) {
				returnString.append(", ");
			}

		}
		return returnString.toString();
	}

	public void lootItems(ArrayList<String> playerInv) {
		ListIterator<String> planetInvIt = inventory.listIterator();
		while (planetInvIt.hasNext()) {
			playerInv.add(planetInvIt.next());
			planetInvIt.remove();
		}

	}

}