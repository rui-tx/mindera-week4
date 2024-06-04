package ioexercise;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        boolean exitProgram = false;
        while (!exitProgram) {
            try {
                printMainMenu();
                System.out.print("[option]> ");
                input = reader.readLine().toUpperCase();

                MenuEnum test = MenuEnum.valueOf(input);
                switch (test) {
                    case OP1A:
                        askAndPrintUserDirToPrint();
                        break;
                    case OP2A:
                        askUserForFileAndPathAndSeeIfExists();
                        break;
                    case OP2B:
                        askUserForFileAndPathAndSeeIfExistsFull();
                        break;
                    case OP3A:
                        createNewFileInPath();
                        break;
                    case OP3B:
                        createNewFileInPathFull();
                        break;
                    case EXIT:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Not an option.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.printf("%s\t%s\n", "Option", "Description");
        for (int i = 0; i < MenuEnum.values().length; i++) {
            System.out.printf("[%s]\t%s\n", MenuEnum.values()[i], MenuEnum.values()[i].getDesc());
        }
        System.out.println();
    }

    public static void askAndPrintUserDirToPrint() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            System.out.println("Please input the directory to display all files inside it: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print("[directory]> ");
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File dirToList = new File(input);
        if (!dirToList.exists()) {
            System.out.println("Path is invalid / does not exist.");
            return;
        }

        System.out.println("Listing files and directories from '" + input + "'");
        for (String dir : dirToList.list()) {
            System.out.println(dir);
        }
    }

    public static void askUserForFileAndPathAndSeeIfExists() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Please input the file / directory to check if exists: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print("[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Enter path. This file / directory should be at '[path]/" + fileName);
            System.out.print("[path]> ");
            path = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        File checkIfExist = new File(path.concat(fileName));
        if (!checkIfExist.exists()) {
            System.out.println("The path to the file is invalid / does not exist.");
            return;
        }

        System.out.println("The file / directory exists! Final path to file: " + path.concat(fileName));
    }

    public static void askUserForFileAndPathAndSeeIfExistsFull() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Please input the directory to check if file exists: ");
            System.out.println("Only absolute paths are valid.");
            System.out.print("[directory]> ");
            path = reader.readLine();

            File checkIfExist = new File(path);
            if (!checkIfExist.isAbsolute()) {
                System.out.println("Only absolute paths are valid.");
                return;
            }

            if (!checkIfExist.exists()) {
                System.out.println("Path is invalid / does not exist.");
                return;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Please input the file name to check if exists: ");
            System.out.print(path + "/[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        File checkIfExist = new File(path.concat(fileName));
        if (!checkIfExist.exists()) {
            System.out.println("Path is invalid / does not exist.");
            return;
        }

        System.out.println("The file exists! File path: " + path.concat(fileName));
    }

    public static void createNewFileInPath() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Please input the directory to save the file: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print("[directory]> ");
            path = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Please input the file name: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print(path + "/[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        path = path.concat(fileName);

        String text = "This is a new file with this text inside.\n";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The file was made with success! File path: " + path);
    }

    public static void createNewFileInPathFull() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Please input the directory to save the file: ");
            System.out.println("Only absolute paths are valid.");
            System.out.print("[directory]> ");
            path = reader.readLine();

            File checkIfExist = new File(path);
            if (!checkIfExist.isAbsolute()) {
                System.out.println("Only absolute paths are valid.");
                return;
            }

            if (!checkIfExist.exists()) {
                System.out.println("Path is invalid / does not exist.");
                return;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Please input the file name: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print(path + "/[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        path = path.concat(fileName);

        String text = "This is a new file with this text inside.\n";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The file was made with success! File path: " + path);
    }
}