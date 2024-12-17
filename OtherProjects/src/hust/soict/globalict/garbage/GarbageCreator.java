package globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // test.exe is the name or path to an executable file
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) outputString += (char) b;

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}