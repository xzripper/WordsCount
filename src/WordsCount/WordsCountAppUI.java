// Declaring package.
package WordsCount;

// Main dependencies.
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Main class.
public class WordsCountAppUI extends JFrame {
    // Widgets.
    final private JLabel CountLabel = new JLabel("Words in text is 0.");
    final private JTextField FilenameEntry = new JTextField();
    final private JButton CountWordsButton = new JButton("Count words.");

    // App mechanics.
    final private WordsCountAppMechanics Mechanics = new WordsCountAppMechanics();

    // Class variables.
    private Container Content;
    private String AppTitle;

    // Constructor with settings.
    public WordsCountAppUI(String WindowIcon, String WindowTitle, int[] WindowXY, int[] WindowSize) {
        // Set title.
        super(WindowTitle);

        // Set up window.
        this.setBounds(WindowXY[0], WindowXY[1], WindowSize[0], WindowSize[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set icon.
        ImageIcon Icon = new ImageIcon(WindowIcon);
        this.setIconImage(Icon.getImage());

        // Update class variable. (Title).
        AppTitle = WindowTitle;

        // Window content.
        Content = this.getContentPane();

        // Window layout.
        GridLayout WindowLayout = new GridLayout(0, 1, 0, 10);

        // Update window layout.
        Content.setLayout(WindowLayout);

        // Connect function to button.
        CountWordsButton.addActionListener(new CountWordsFunction());

        // Place all widgets on window.
        PlaceWidgets();

        // Show UI.
        SetUIVisible();
    }

    // Place all widgets.
    private void PlaceWidgets() {
        Content.add(CountLabel);
        Content.add(FilenameEntry);
        Content.add(CountWordsButton);
    }

    // Set UI visible.
    private void SetUIVisible() {
        this.setVisible(true);
    }

    // Create message.
    private void Message(String Text, int Type) {
        JOptionPane.showMessageDialog(null, Text, AppTitle, Type);
    }

    // Count words function, on click.
    class CountWordsFunction implements ActionListener {
        public void actionPerformed(ActionEvent Event) {
            String TargetFile = FilenameEntry.getText();
            int Count = Mechanics.GetWordsCountFromFile(TargetFile);

            String Template = "Words in text is %d.";

            if (Count == -1) {
                Message("Some things went wrong...", JOptionPane.ERROR_MESSAGE);
            } else {
                CountLabel.setText(String.format(Template, Count));
            }
        }
    }
}
