import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class saidaTXT {
    public static void writeToFile(String filename, String content) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            writer.println(content);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao criar o arquivo." + e.getMessage());
        }
    }
}