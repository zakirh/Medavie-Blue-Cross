package main.java.ceilingfan.operation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.java.ceilingfan.operation.enums.MovingDirection;

public class Actions extends JFrame implements KeyListener {
    private static final int MAX_LIMIT = 3;
    private static final int MIN_LIMIT = 0;
    private int currentSpeed;
    private MovingDirection currentMovingDirection;
    private JLabel statusLabel;
    private JTextField in = new JTextField();

    public Actions() {
        setDefaultValues();
        constructInstructions();
        constructStatusControl();

        JTextArea out = new JTextArea();

        this.setTitle("Ceiling Fan");
        this.add(out, BorderLayout.CENTER);
        this.add(in, BorderLayout.SOUTH);
        this.setBounds(500, 500, 800, 500);
        in.addKeyListener(this);
    }

    private void setDefaultValues() {
        currentMovingDirection = MovingDirection.FORWARD;
        currentSpeed = 0;
        this.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window has been opened.
             *
             * @param e
             */
            @Override
            public void windowOpened(final WindowEvent e) {
                in.requestFocus();
            }
        });

    }

    private void constructInstructions() {
        JLabel instructionLabel = new JLabel("<html>Instructions:<br>"
                + "*** Press key '→' to move the fan's direction clockwise and '←' to reverse order<br>"
                + "*** Press '↑' key to increase the speed or ↓ to decrease the speed<br>"
                + "*** Assume that the fan has always electricity connection and by default it is off."
                + "<br>*** To start hit the '↑' key</html>");
        instructionLabel.setForeground(Color.BLUE);
        instructionLabel.setBounds(50, 5, 600, 200);
        this.add(instructionLabel);
    }

    private void constructStatusControl() {
        statusLabel = new JLabel("<html>The fan is now off</html>");
        statusLabel.setForeground(Color.BLACK);
        statusLabel.setBounds(50, 200, 600, 200);
        this.add(statusLabel);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(final KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        int currentKeyCode = e.getExtendedKeyCode();
        switch (currentKeyCode) {
            case 37: //Fan's Backward moving direction
                if (currentMovingDirection == MovingDirection.BACKWARD) {
                    break;
                }
                currentMovingDirection = MovingDirection.BACKWARD;
                setStatus();
                break;
            case 38:// Increase speed
                currentSpeed++;
                if (currentSpeed > MAX_LIMIT) {
                    currentSpeed = MIN_LIMIT;
                }
                setStatus();
                break;
            case 39: //Fan's forward moving direction
                if (currentMovingDirection == MovingDirection.FORWARD) {
                    break;
                }
                currentMovingDirection = MovingDirection.FORWARD;
                setStatus();
                break;
            case 40: //Decrease speed
                currentSpeed--;
                if (currentSpeed < MIN_LIMIT) {
                    currentSpeed = MIN_LIMIT;
                }
                setStatus();
                break;
            case 81:
                System.exit(0);
                break;
            default:
                break;
        }
    }


    private void setStatus() {
        final String currentDirection = currentMovingDirection == MovingDirection.FORWARD ? "Forward" : "Backward";
        final String currentStatus = (currentSpeed == 0 ? "The fan is now off." :
                String.format("The fan is now running at the speed of %s with moving %s", currentSpeed, currentDirection));
        statusLabel.setText(currentStatus);
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(final KeyEvent e) {

    }

}
