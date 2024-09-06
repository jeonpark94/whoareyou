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
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 22);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

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

        choice1 = choiceButton("Choice 1", choiceButtonPanel);
        choice2 = choiceButton("Choice 2", choiceButtonPanel);
        choice3 = choiceButton("Choice 3", choiceButtonPanel);
        choice4 = choiceButton("Choice 4", choiceButtonPanel);

        choice1.addActionListener(choiceHandler);
        choice2.addActionListener(choiceHandler);
        choice3.addActionListener(choiceHandler);
        choice4.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choice2.setActionCommand("c2");
        choice3.setActionCommand("c3");
        choice4.setActionCommand("c4");
        
        con.add(choiceButtonPanel);

        // JPanel player panel
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        // JLabel HP label
        hpLabel = playerNumbers("HP: ", playerPanel);
        hpLabelNumber = playerNumbers("", playerPanel);
        weaponLabel = playerNumbers("Weapon: ", playerPanel);
        weaponLabelName = playerNumbers("", playerPanel);

        playerSetup();

        window.setVisible(true);
    }

    public JButton choiceButton(String buttonName_m, JPanel choiceButtonPanel_m) {
        // Method to create choice buttons
        JButton button;
        button = new JButton(buttonName_m);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFocusable(false);
        button.setFont(buttonFont);
        choiceButtonPanel_m.add(button);
        return button;
    }

    public JLabel playerNumbers(String text_m, JPanel playerPanel_m) {
        // Method to create player HP and weapon labels
        JLabel label;
        label = new JLabel(text_m);
        label.setFont(normalFont);
        label.setForeground(Color.white);
        playerPanel_m.add(label);
        return label;

    }

    public void playerSetup() {
        // Initialize player HP and weapon
        playerHP = 15;
        monsterHP = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();

    }

    public void townGate(){
        position = "townGate";

        mainTextArea.setText("You are at the gate of the town. \nA guard is standing at the gate of the town. \n\nWhat will you do?");
        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard(){
        position = "talkGuard";

        mainTextArea.setText("Guard: Hello stranger. \nI have never seen your face. \nI'm sorry but we cannot let you into the town.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard(){
        position = "attackGuard";

        mainTextArea.setText("Guard: Hey don't be stupid! \n\nThe guard fought back and hit you hard. \n(You received 3 damage)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad(){
        position = "crossRoad";

        mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the town.");
        choice1.setText("Go north");
        choice2.setText("Go east");
        choice3.setText("Go south");
        choice4.setText("Go west");
    }

    public void north(){
        position = "north";

        mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n(You HP is recovered by 2)");
        playerHP = playerHP + 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go south");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east(){
        position = "east";

        mainTextArea.setText("You walked into a forest and found a Long Sword! \n\n(You obtained a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText("Go west");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void west(){
        position = "west";

        mainTextArea.setText("You encounter a goblin!");
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight(){
        position = "fight";

        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }
    public void playerAttack(){
        position = "playerAttack";

        int playerDamage = 0;

        if(weapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(3);
        }
        else if(weapon.equals("Long Sword")){
            playerDamage = new java.util.Random().nextInt(8);
        }

        mainTextArea.setText("You attacked the monster and dealt " + playerDamage + " damage!");
        monsterHP = monsterHP - playerDamage;
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void monsterAttack(){
        position = "monsterAttack";

        int monsterDamage = 0;
        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("The goblin attacked and dealt " + monsterDamage + " damage!");
        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void win(){
        position = "win";

        mainTextArea.setText("You defeated the goblin! \nThe monster dropped a ring! \n\n(You obatined a Silver Ring)");
        silverRing = 1;

        choice1.setText("Go east");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void lose(){
        position = "lose";

        mainTextArea.setText("You are dead! \n\n<GAME OVER>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void ending(){
        position = "ending";

        mainTextArea.setText("Guard: Oh you killed that goblin? \nThank you so much! \nWelcome to our town! \n\n<THE END>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }


    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(position) {
                case "townGate":
                    switch(yourChoice){
                        case "c1":
                            if (silverRing == 1){
                                ending();
                            }
                            else{
                                talkGuard();
                            }
                            break;
                        case "c2": attackGuard(); break;
                        case "c3": crossRoad(); break;
                        case "c4": break;
                    }
                    break;
                case "talkGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "attackGuard":
                    switch(yourChoice){
                        case "c1": townGate(); break;
                    }
                    break;
                case "crossRoad":
                    switch(yourChoice){
                        case "c1": north(); break;
                        case "c2": east(); break;
                        case "c3": townGate(); break;
                        case "c4": west(); break;
                    }
                    break;
                case "north":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
                case "east":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
                case "west":
                    switch(yourChoice){
                        case "c1": fight(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "fight":
                    switch(yourChoice){
                        case "c1": playerAttack(); break;
                        case "c2": crossRoad(); break;
                    }
                    break;
                case "playerAttack":
                    switch(yourChoice){
                        case "c1":
                        if(monsterHP < 1) {
                            win();
                        }
                        else{
                            monsterAttack();
                        }
                        break;
                    }
                    break;
                case "monsterAttack":
                    switch(yourChoice){
                        case "c1":
                        if(playerHP < 1){
                            lose();
                        }
                        else{
                            fight();
                        }
                        break;
                    }
                    break;
                case "win":
                    switch(yourChoice){
                        case "c1": crossRoad(); break;
                    }
                    break;
            }
        }
    }
};