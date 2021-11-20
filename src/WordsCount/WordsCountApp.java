// Declaring package.
package WordsCount;

// Main class.
public class WordsCountApp {
    // Main function.
    public static void main(String[] args) {
        // Application settings.
        final String Icon = "src\\WordsCount\\Icon.png";
        final String Title = "Quantity of words in file.";
        final int[] XY = {150, 200};
        final int[] Size = {350, 400};

        // Init UI.
        WordsCountAppUI Application = new WordsCountAppUI(Icon, Title, XY, Size);
    }
}
