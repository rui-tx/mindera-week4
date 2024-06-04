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
                System.out.print("> ");
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
        for (int i = 0; i < MenuEnum.values().length; i++) {
            System.out.printf("[%s]: %s\n", MenuEnum.values()[i], MenuEnum.values()[i].getDesc());
        }
        System.out.println();
    }

    public static void askAndPrintUserDirToPrint() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            System.out.println("Dir to list file: ");
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File dirToList = new File(input);
        if (!dirToList.exists()) {
            System.out.println("Path is invalid / does not exist.");
            return;
        }

        for (String dir : dirToList.list()) {
            System.out.println(dir);
        }
    }

    public static void askUserForFileAndPathAndSeeIfExists() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("File Name / Directory: ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("Path: ");
            path = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(path.concat(fileName));

        File checkIfExist = new File(path.concat(fileName));
        if (!checkIfExist.exists()) {
            System.out.println("Path is invalid / does not exist.");
            return;
        }

        System.out.println("file exists! " + path.concat(fileName));
    }

    public static void askUserForFileAndPathAndSeeIfExistsFull() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Full Path: ");
            path = reader.readLine();

            File checkIfExist = new File(path);
            if (!checkIfExist.exists()) {
                System.out.println("Path is invalid / does not exist.");
                return;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("File Name ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        System.out.println(path.concat(fileName));

        File checkIfExist = new File(path.concat(fileName));
        if (!checkIfExist.exists()) {
            System.out.println("Path is invalid / does not exist.");
            return;
        }

        System.out.println("file exists! " + path.concat(fileName));
    }

    public static void createNewFileInPathFull() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Full Path: ");
            path = reader.readLine();

            File checkIfExist = new File(path);
            if (!checkIfExist.exists()) {
                System.out.println("Path is invalid / does not exist.");
                return;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("File Name: ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        path = path.concat(fileName);

        String text = "success!";


        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);

            writer.flush();

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createNewFileInPath() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Directory: ");
            path = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("File Name: ");
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        path = path.concat("/");
        path = path.concat(fileName);

        String text = "success!";


        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);

            writer.flush();

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
