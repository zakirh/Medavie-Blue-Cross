package main.java.ceilingfan;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import main.java.ceilingfan.operation.Actions;

public class Main {

    public static void main(String[] arguments) {
        Actions actions = new Actions();
        actions.setVisible(true);
        actions.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
