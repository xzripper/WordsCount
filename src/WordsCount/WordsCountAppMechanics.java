// Declaring package.
package WordsCount;

// Main dependencies.
import java.io.File;
import java.util.Scanner;

// Main class.
public class WordsCountAppMechanics {
    // Read a file.
    public String ReadFile(String FileName) {
        try {
            String Text = "";
            File DataFile = new File(FileName);
            Scanner ScannerObject = new Scanner(DataFile);

            while (true) {
                if (!ScannerObject.hasNextLine()) {
                    return Text;
                } else if (ScannerObject.hasNextLine()) {
                    Text += ScannerObject.nextLine() + (ScannerObject.hasNextLine() ? "\n" : "");
                }
            }
        }

        catch (Exception Error) {
            return "@Exception_";
        }
    }

    // Get words from text.
    public String[] GetWords(String Text) {
        String[] Words = Text.split(" ");

        for(int i=0;i<Words.length;i++) {
            Words[i] = Words[i].replace("\n", " ");
        }

        String NormalizedWords = String.join(" ", Words);
        String[] ReadyWords = NormalizedWords.split(" ");

        return ReadyWords;
    }

    // Count words in text.
    public int GetWordsCount(String Text) {
        String[] Words = GetWords(Text);

        return Words.length;
    }

    // Count words in text from file.
    public int GetWordsCountFromFile(String File) {
        String TextOfFile = ReadFile(File);

        if (TextOfFile == "@Exception_") {
            return -1;
        } else {
            int Count = GetWordsCount(TextOfFile);

            return Count;
        }
    }
}
