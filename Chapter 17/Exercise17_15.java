import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the encrypted input file name: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the output (decrypted) file name: ");
        String outputFile = scanner.nextLine();

        try (
                InputStream input = new FileInputStream(inputFile);
                OutputStream output = new FileOutputStream(outputFile)
        ) {
            int byteData;
            while ((byteData = input.read()) != -1) {
                output.write((byteData - 5 + 256) % 256);
            }
            System.out.println("Decryption completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

}
