package main.java.ceilingfan.operation.enums;

public enum MovingDirection {
    FORWARD('F'),
    BACKWARD('B');

    private char value;

    MovingDirection(final char value) {
        this.value = value;
    }

}
