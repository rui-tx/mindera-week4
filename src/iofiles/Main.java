package iofiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInput;


        try {
            fileOutputStream = new FileOutputStream("src/iofiles/outputtux.jpeg");
        } catch (FileNotFoundException e) {
            System.out.println("cant right to file");
            return;
        }

        try {
            fileInput = new FileInputStream("src/iofiles/tux.jpeg");
            byte[] buffer = new byte[8];

            int nBytes = 0;
            while (nBytes != -1) {
                nBytes = fileInput.read(buffer);

                if (nBytes != -1) {
                    fileOutputStream.write(buffer,0, nBytes);
                }

            }



        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return;
        } catch (IOException e) {
            System.out.println("cant read file");
        }






    }
}
