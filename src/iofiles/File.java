package iofiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File {

    private String path;
    private FileInputStream file;

    public File(String path) {
        this.path = path;

        initFile();
    }

    private boolean initFile() {
        try {
            file = new FileInputStream(this.path);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public static boolean filePathExist(String path) {
        return checkFilePath(path);
    }

    private static boolean checkFilePath(String path) {
        try {
            FileInputStream fileInput = new FileInputStream(path);
            fileInput.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
