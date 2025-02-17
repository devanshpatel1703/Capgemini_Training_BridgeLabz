//4.

import java.io.*;

class LargeFileReadingComparison {
    static long readFileWithFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1);
        }
        return (System.nanoTime() - startTime) / 1000000;
    }

    static long readFileWithInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1);
        }
        return (System.nanoTime() - startTime) / 1000000;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; 
        long fileReaderTime = readFileWithFileReader(filePath);
        long inputStreamReaderTime = readFileWithInputStreamReader(filePath);
        System.out.println("File Size: 500MB");
        System.out.println("FileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
        System.out.println("-".repeat(40));
    }
}
