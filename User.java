package com.LabProject;

import java.util.*;

public class User {

	public static final Map<Integer, Location> locations = new HashMap<>();
	private Location planet;
	public ArrayList<String> playerInventory;
	public Map<Location,Monster> monsterMap=new HashMap<>();
	public int health=100;
	private int score;
	private int i;

	// Player constructor
	public User() {
		this.score = 0;
		this.i = 1;
		playerInventory = new ArrayList<>();

	}

	// Intro to the player to start the game
	public void playerIntro() {
		Game game = new Game();
		Scanner s = new Scanner(System.in);
		System.out.println("Would you like to play our game? Type (Yes, No)");
		String userInput = s.nextLine();
		if (userInput.equals("Yes")) {
			System.out.println(
					"You press on!\nThe goal of the game is to get to 50 points \nbut if you go negative you lose!");

		} else if (userInput.equals("No") || userInput.equals("N")) {
			System.out.println("You back away, thus ends your story.");
			game.GameOver(0);
		}

	}

	public void gamePlay() {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		// puts planets in a map
		locations.put(0, new Location(0, "You are now on the planet of Coruscant",
				new ArrayList<String>(Arrays.asList("Evidence of fight", "Evidence of Count Dooku's Killer"))));
		locations.put(1, new Location(1, "You are now on the planet of Utapau",
				new ArrayList<String>(Arrays.asList("Medkit", "Evidence of General Grevious's Killer"))));
		locations.put(2, new Location(2, "You are now on the planet of Mygeeto",
				new ArrayList<String>(Arrays.asList("Medpack", "Deathsticks", "VIP Comcode List"))));
		locations.put(3, new Location(3, "You are now on the planet of Felucia",
				new ArrayList<String>(Arrays.asList("Datapad", "Holograph of Sith activity"))));
		locations.put(4, new Location(4, "You are now on the planet of Kashyyyk",
				new ArrayList<String>(Arrays.asList("Medkit", "Holograph of Jedi activity"))));
		locations.put(5, new Location(5, "You are now on the planet of Cato Neimoidia", new ArrayList<String>(
				Arrays.asList("Evidence of Jedi passage", "Chiss Pyrowall Cracker", "Chiss Comlink Cracker"))));
		locations.put(6, new Location(6, "You are now on the planet of Saleucami", new ArrayList<String>(
				Arrays.asList("Evidence of a Sith amongst the Jedi", "Incriminating Holograph"))));
		locations.put(7, new Location(7, "You are now on the planet of Mustafar",
				new ArrayList<String>(Arrays.asList("Evidence of Sith passage", "Thermaslice"))));

		// Adds directions for different planets
		locations.get(0).addDirection("East", 1);

		locations.get(1).addDirection("West", 0);
		locations.get(1).addDirection("North", 3);
		locations.get(1).addDirection("East", 2);
		locations.get(1).addDirection("South", 4);

		locations.get(2).addDirection("South", 5);
		locations.get(2).addDirection("West", 4);

		locations.get(3).addDirection("North", 5);
		locations.get(3).addDirection("South", 1);
		locations.get(3).addDirection("East", 7);

		locations.get(4).addDirection("North", 1);
		locations.get(4).addDirection("East", 2);
		locations.get(4).addDirection("West", 6);

		locations.get(5).addDirection("North", 2);

		locations.get(6).addDirection("East", 4);

		locations.get(7).addDirection("West", 3);

		System.out.println(
				"You must choose different locations to score at least 50 points to win! If you go negative you lose.");
		//create monster map
		MonsterFactory monsterFactory=new MonsterFactory();
		//put monsters in a map
		monsterMap=monsterFactory.fillMonsterMap();

		Map<String, String> command = new HashMap<>();
		command.put("QUIT", "Quit");
		command.put("HELP", "Help");
		command.put("NORTH", "North");
		command.put("SOUTH", "South");
		command.put("WEST", "West");
		command.put("EAST", "East");

		// while loop keeps going infinite until 50 is reached or game is over
		while (score <= 50) {


			if (i == -1)
				break;

			System.out.println(locations.get(i).getDescription());



			//TODO  angry monster stuff
			if(monsterMap.get(locations.get(i))!=(null)){
				System.out.println("You see a "+monsterMap.get(locations.get(i)).name+" and it says "+monsterMap.get(locations.get(i)).greet());
				System.out.println("Do you want to attack it? (Y/N)");
				String monsterCommand=scanner.nextLine();

				if(monsterCommand.equalsIgnoreCase("yes")){
					int chance = rand.nextInt(100);
					if(chance<85){
						this.health-=monsterMap.get(locations.get(i)).attack();

						System.out.println("After an intense fight you lost  "+monsterMap.get(locations.get(i)).attack()+" health points, your new health points is "+this.health);
						System.out.println("You get 10 points for wining this intence battle");
						this.score+=10;
					}
					else if((chance<95)&&(chance>85)){
						this.health-=2*monsterMap.get(locations.get(i)).attack();
						System.out.println("Monster damaged you critically! After an intense fight you lost  "+2*monsterMap.get(locations.get(i)).attack()+" health points, your new health points is "+this.health);
						System.out.println("You get 15 points for wining this intence battle");
						this.score+=15;
					}
					else if(chance>95){
						System.out.println("Monster doesnt want to fight you, he gives you 3 points and leaves");
						this.score+=3;
					}

				}
				if(this.health<0)
					break;


			}
			else{
				System.out.println("You are lucky There are no monsters on this planet");
			}

			String locationItems = locations.get(i).getAllItems();
			System.out.println(locationItems.equals("") ? "The place has been picked clean" : "You find: " + locationItems);

			if (!locationItems.equals("")) {
				System.out.println("Type \"Loot\" to take available items");
			}

			Map<String, Integer> moves = locations.get(i).getMoves();
			System.out.println("Available commands are: ");
			for (String move : moves.keySet()) {
				System.out.print(move + " ");

			}
			System.out.println("Enter a command: ");
			String inputCommand = scanner.nextLine().toUpperCase();
			if (inputCommand.length() > 1) {
				String[] words = inputCommand.split(" ");
				for (String word : words) {
					if (word.equals("LOOT")) {
						locations.get(i).lootItems(playerInventory);
						System.out.println("You add the items to your stash.");
						System.out.println("Current Score: " + getScore());

					} else if (word.equals("HELP")) {
						Help help = new Help();
						help.helpMenu();
					} else if (word.equals("SECRET")) {
						ItemData.getAllFlavorText();

					} else if (command.containsKey(word)) {
						inputCommand = command.get(word);
						if (moves.containsKey(inputCommand)) {
							i = moves.get(inputCommand);

						} else {
							System.out.println("Direction is not available");
						}
						break;
					}
				}
			}

		}

	}

	// gets the score from the loot
	public int getScore() {

		for (String itemName : playerInventory) {
			score += ItemData.getItemData(itemName).score;
		}
		return score;
	}
}
