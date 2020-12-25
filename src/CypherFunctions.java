import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CypherFunctions {
    Scanner scan = new Scanner(System.in);
    File file = new File(scan.nextLine() + ".text");
    private int key;


    public int randomKey() {
        Random random = new Random();
        return key;
    }

    public String encryptString(String tmp) throws IOException {
        char keys = (char) key;
        String finalTemp = "";
        for (int i = 0; i < tmp.length(); i++) {
            char c = (char) (tmp.charAt(i) + keys);
            finalTemp = new StringBuilder().append(c).toString();
        }
        return finalTemp;
    }

    public String decryptString(String tmp) throws IOException {
        char keys = (char) key;
        String finalTemp = "";
        for (int i = 0; i < tmp.length(); i++) {
            char c = (char) (tmp.charAt(i) - keys);
            finalTemp = new StringBuilder().append(c).toString();
        }
        return finalTemp;
    }

    public FileWriter encryptFile(File file) throws IOException {
        FileWriter newFile = new FileWriter(file.getName() + "_encrypted.txt");
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String data = encryptString(readFile.nextLine());
                newFile.write(data);
            }
            newFile.close();
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("file empty");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

}
//