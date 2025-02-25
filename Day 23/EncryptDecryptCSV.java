import java.io.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecryptCSV {
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte secret key for AES

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_encrypted.csv";
        String decryptedFile = "employees_decrypted.csv";

        encryptAndWriteCSV(inputFile, outputFile);

        decryptAndReadCSV(outputFile, decryptedFile);
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error during encryption", e);
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = Base64.getDecoder().decode(encryptedData);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error during decryption", e);
        }
    }

    public static void encryptAndWriteCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String employeeId = data[0];
                String name = data[1];
                String department = data[2];
                String salary = encrypt(data[3]); 
                String email = encrypt(data[4]); 

                String encryptedRecord = employeeId + "," + name + "," + department + "," + salary + "," + email;
                bw.write(encryptedRecord);
                bw.newLine();
            }
            System.out.println("Encrypted CSV created: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void decryptAndReadCSV(String inputFile, String decryptedFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(decryptedFile))) {
            String line;
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String employeeId = data[0];
                String name = data[1];
                String department = data[2];
                String salary = decrypt(data[3]); 
                String email = decrypt(data[4]); 

                String decryptedRecord = employeeId + "," + name + "," + department + "," + salary + "," + email;
                bw.write(decryptedRecord);
                bw.newLine();
            }
            System.out.println("Decrypted CSV created: " + decryptedFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
