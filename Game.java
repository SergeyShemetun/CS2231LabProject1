package com.LabProject;

import java.util.Scanner;

public class Game {

	private boolean GameOver;
	private Scanner scanner;

	public Game() {
		this.GameOver = false;
		this.scanner = new Scanner(System.in);
	}

	// ends the game
	public void GameOver(int n) {
		this.GameOver = true;
		System.exit(n);

	}

	// runs the game
	public void runGame() {
		do {
			System.out.println("Enter a command: ");
			scanner.nextLine();
			break;
		} while (!this.GameOver);
		testIfGameOver();

	}

	public void testIfGameOver() {
		if (!this.GameOver) {
			System.out.println("Game Over!");

		}

	}

	public void startGame() {
		User user = new User();
		user.playerIntro();
	}
}
