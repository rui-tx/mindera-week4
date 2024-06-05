package ioexercise;

import ioexercise.IoFunctions.IoFunctions;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        //boolean exitProgram = false;
        while (true) {
            try {
                printMainMenu();
                System.out.print("[option]> ");
                input = reader.readLine().toUpperCase();
                MenuEnum choice = checkChoice(input);
                switch (choice) {
                    case OP1A:
                        IoFunctions.listDirectory();
                        break;
                    case OP2A:
                        IoFunctions.checkIfFileExists();
                        break;
                    case OP2B:
                        IoFunctions.checkIfFileExistsAbsolute();
                        break;
                    case OP3A:
                        IoFunctions.createNewFile();
                        break;
                    case OP3B:
                        IoFunctions.createNewFileAbsolute();
                        break;
                    case EXIT:
                        return;
                    case null:
                        System.out.println("Invalid option.");
                        break;
                    default:
                        System.out.println("Not an option.");
                }
            } catch (IOException e) {
                System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            }
        }
    }

    public static MenuEnum checkChoice(String choice) {
        for (int i = 0; i < MenuEnum.values().length; i++) {
            if (choice.equals(MenuEnum.values()[i].getOption())) {
                return MenuEnum.values()[i];
            }
        }
        return null;
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.printf("%s\t%s\n", "Option", "Description");
        for (int i = 0; i < MenuEnum.values().length; i++) {
            System.out.printf("[%s]\t%s\n", MenuEnum.values()[i].getOption(), MenuEnum.values()[i].getDesc());
        }
        System.out.println();
    }
}