package ioexercise.IoFunctions;

import ioexercise.IoFunctions.exceptions.InvalidPathException;
import ioexercise.IoFunctions.exceptions.IoFunctionsException;
import ioexercise.IoFunctions.exceptions.PathIsNotAbsoluteException;

import java.io.*;

public class IoFunctions {

    // 1a
    public static void listDirectory() {
        try {
            askAndPrintUserDirToPrint();
        } catch (IoFunctionsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void askAndPrintUserDirToPrint() throws IoFunctionsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            System.out.println("Please input the directory to display all files inside it: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print("[directory]> ");
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        File dirToList = new File(input);
        if (!dirToList.exists()) {
            throw new InvalidPathException();
        }

        System.out.println("Listing files and directories from '" + input + "'");
        for (String dir : dirToList.list()) {
            System.out.println(dir);
        }
    }

    // 2a
    public static void checkIfFileExists() {
        try {
            askUserForFileAndPathAndSeeIfExists();
        } catch (IoFunctionsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void askUserForFileAndPathAndSeeIfExists() throws IoFunctionsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Please input the file / directory to check if exists: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print("[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Enter path. This file / directory should be at '[path]/" + fileName);
            System.out.print("[path]> ");
            path = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        path = path.concat("/");
        path = path.concat(fileName);
        File checkIfExist = new File(path);
        if (!checkIfExist.exists()) {
            throw new InvalidPathException();
        }

        System.out.println("The file / directory exists! Final path to file: " + path);
    }

    // 2b
    public static void checkIfFileExistsAbsolute() {
        try {
            askUserForFileAndPathAndSeeIfExistsFull();
        } catch (IoFunctionsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void askUserForFileAndPathAndSeeIfExistsFull() throws IoFunctionsException {
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
                throw new PathIsNotAbsoluteException();
            }

            if (!checkIfExist.exists()) {
                throw new InvalidPathException();
            }

        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Please input the file name to check if exists: ");
            System.out.print(path + "/[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        path = path.concat("/");
        File checkIfExist = new File(path.concat(fileName));
        if (!checkIfExist.exists()) {
            throw new InvalidPathException();
        }

        System.out.println("The file exists! File path: " + path.concat(fileName));
    }

    // 3a
    public static void createNewFile() {
        try {
            createNewFileInPath();
        } catch (IoFunctionsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createNewFileInPath() throws IoFunctionsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        String path = null;

        try {
            System.out.println("Please input the directory to save the file: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print("[directory]> ");
            path = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Please input the file name: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print(path + "/[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
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
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        System.out.println("The file was made with success! File path: " + path);
    }

    //3b
    public static void createNewFileAbsolute() {
        try {
            createNewFileInPathFull();
        } catch (IoFunctionsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createNewFileInPathFull() throws IoFunctionsException{
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
                throw new PathIsNotAbsoluteException();
            }

            if (!checkIfExist.exists()) {
                throw new InvalidPathException();
            }

        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Please input the file name: ");
            System.out.println("Absolute and Relative paths are valid.");
            System.out.print(path + "/[file]> ");
            fileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
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
            System.out.println("Something went wrong. Please try again.\nDetails: " + e.getMessage());
            return;
        }

        System.out.println("The file was made with success! File path: " + path);
    }
}
