import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {

    // Variable declarations
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 22);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String []args) {

    try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        
        new Game();

    }

    public Game() {

        // JFrame window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        // JPanel and JLabel title page
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("WHO ARE YOU?");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        
        // JButton start button on title page
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setFont(normalFont);
        startButton.setFocusable(false);
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        startButton.addActionListener(tsHandler);
        startButtonPanel.add(startButton);


        con.add(titleNamePanel);
        con.add(startButtonPanel);
        
        window.setVisible(true);
    }

    public void createGameScreen(){

        window.setVisible(false);

        // Set title screen visibility off
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // JPanel and JText main text panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel);

        // JPanel and Jbutton choice buttons
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));

        choice1 = choiceButton("Choice 1");
        choice2 = choiceButton("Choice 2");
        choice3 = choiceButton("Choice 3");
        choice4 = choiceButton("Choice 4");

        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        con.add(choiceButtonPanel);

        // JPanel player panel
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        window.setVisible(true);
    }

    public JButton choiceButton(String buttonName) {
        JButton button;
        button = new JButton(buttonName);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(buttonFont);
        return button;
    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            createGameScreen();
        }
    }
};