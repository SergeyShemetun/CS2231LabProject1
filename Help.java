package com.LabProject;

public class Help {
    private final String[] Commands;

    Help(){
        this.Commands = new String[]{"East", "West", "South", "North"};
    }

    public void printCommands(){
        System.out.println("Here are all available commands for you to type:");
        for (String command: Commands ){
            System.out.println(command);
        }
    }
}
