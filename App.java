package com.LabProject;

public class App {

	public static void main(String[] args) {

		User user = new User();
		user.playerIntro();
		ItemData.init();
		user.gamePlay();

	}

}
