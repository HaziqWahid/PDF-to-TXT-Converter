
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //GET THE NAME OF FILE THAT NEED TO BE READ
        String dataFile = null;
        String cwd = Path.of("").toAbsolutePath().toString();
        String targetPath = cwd + "/uploads/ReadPhpToJava.txt";

        // SEARCH THE NAME FILE THAT NEED TO BE READ IN TEXT FILE
        try {
            File myObj = new File(targetPath);
            Scanner myReader = new Scanner(myObj);
            if (myReader.hasNextLine()) {
                dataFile = myReader.nextLine();
                myReader.close();
            }
        } catch (FileNotFoundException var10) {
        }

        //READ THE TARGET PDF FILE
        if (dataFile != null) {
            String text = null;
            PDFManager pdfManager = new PDFManager();
            pdfManager.setFilePath(cwd + "/uploads/historyClear/" + dataFile+".pdf");

            try {
                String text1 = pdfManager.toText();
                text = text1;
            } catch (IOException var9) {
            }

            //CREATE THE TEXT FILE
            try {
                FileWriter myWriter = new FileWriter(cwd + "/uploads/retrieveClear/" + dataFile + ".txt");
                myWriter.write(text);
                myWriter.close();
            } catch (IOException var8) {
            }
        }

    }
}