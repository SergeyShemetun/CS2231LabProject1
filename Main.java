package com.LabProject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Setting up user shit
        User user1 = new User();
        user1.setName("User 1");

        String direction;
        System.out.println("Hello " + user1.getName());
        System.out.println("Welcome to the game");

        Help Commands = new Help();
        Commands.printCommands();

        System.out.println("Please tell me what to do");
        Scanner input = new Scanner(System.in);



        // Figuring out wtf is  going on
        Commands.printCommands();

        for(int i=0;i<5;i++) {

            //supposed to start interacting here
            System.out.println("Which way do you want to go?");
            direction=input.nextLine();
            user1.move(direction);
            System.out.println("You are now in "+user1.whereAmI());



        }
    }
}