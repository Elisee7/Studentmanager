package ui;

import javax.swing.*;

public class FenetrePrincipale {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Manager");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("Bienvenue dans Student Manager"));
        frame.setVisible(true);
    }
}

