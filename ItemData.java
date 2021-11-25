package com.LabProject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ItemData {
	private static Map<String, ScoreableItems> item;

	public static void init() {
		item = new HashMap<>();
		initializeItemData();

	}

	// initialize all the different items that can be found in the game
	private static void initializeItemData() {
		item.put("Medkit", new ScoreableItems(3, 20, "It's small but it heals well"));
		item.put("Medpack", new ScoreableItems(3, 100, "A proper Medpack, healing even the most grevious of wounds"));
		item.put("Datapad", new ScoreableItems(3, 0, "A datapad with information on the Jedi"));
		item.put("Deathsticks", new ScoreableItems(3, -10, "A taste of death"));
		item.put("Thermaslice", new ScoreableItems(3, 0, "Yes, this is an easter egg"));
		item.put("Chiss Pyrowall Cracker", new ScoreableItems(3, 0, "Chiss technology for hacking"));
		item.put("Chiss Comlink Cracker", new ScoreableItems(3, 0, "Chiss technology for listening into Comlinks"));
		item.put("Incriminating Holograph", new ScoreableItems(3, 0, "Blackmail material"));
		item.put("VIP Comcode List", new ScoreableItems(3, 0, "A list of Comcodes of very important people"));
		item.put("Evidence of Jedi passage", new ScoreableItems(3, 0, "The Jedi were here"));
		item.put("Holograph of Jedi activity", new ScoreableItems(3, 0, "Holograph of the Jedi in action"));
		item.put("Evidence of Sith passage", new ScoreableItems(3, 0, "The Sith were here"));
		item.put("Holograph of Sith activity", new ScoreableItems(3, 0, "Holograph of the Sith in action"));
		item.put("Evidence of fight", new ScoreableItems(3, 0, "The aftermath of a fight"));
		item.put("Evidence of Count Dooku's Killer", new ScoreableItems(3, 0, "The wreckage of battle hide clues to who the perpitrators are"));
		item.put("Evidence of General Grevious's Killer", new ScoreableItems(3, 0, "The Saber-burnt remains of the General hide clues to his undoing "));
		item.put("Evidence of a Sith amongst the Jedi", new ScoreableItems(2, 0, "Trechery has a high price"));
	}

	// Gets the specific items data
	public static ScoreableItems getItemData(String itemName) {
		return item.get(itemName);
	}

	// secret method
	public static void getAllFlavorText() {
		System.out.println("You found the secret list of item descriptions:");
		Iterator<Map.Entry<String, ScoreableItems>> it = item.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, ScoreableItems> itemData = it.next();
			System.out.println(itemData.getKey() + " - " + itemData.getValue().flavorText);

		}

	}
}
