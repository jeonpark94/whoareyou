import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);
    public static void main(String []args) {
        
        new Game();

    }

    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.blue);
        titleNameLabel = new JLabel("WHO ARE YOU");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);

        window.setVisible(true);
    }
};