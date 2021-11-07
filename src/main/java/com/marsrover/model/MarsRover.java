package com.marsrover.model;

import com.marsrover.model.Exception.InvalidCommandException;
import javafx.util.Pair;

public class MarsRover {
    private Pair<Integer, Integer> position;
    private MarsRoverHead head;

    private final char BACKWARD_COMMAND = 'B';
    private final char FORWARD_COMMAND = 'F';
    private final char ROTATE_LEFT_COMMAND = 'L';
    private final char ROTATE_RIGHT_COMMAND = 'R';

    public MarsRover(Pair<Integer, Integer> position, CardinalPoint heading) {
        this.position = position;
        if (CardinalPoint.WEST.equals(heading)) this.head = new MarsRoverHeadFacingWest(this);
        if (CardinalPoint.EAST.equals(heading)) this.head = new MarsRoverHeadFacingEast(this);
        if (CardinalPoint.NORTH.equals(heading)) this.head = new MarsRoverHeadFacingNorth(this);
        if (CardinalPoint.SOUTH.equals(heading)) this.head = new MarsRoverHeadFacingSouth(this);
    }

    public void processCommands(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            validateCommand(commands.charAt(i));
            processCommand(commands.charAt(i));
        }
    }

    public boolean isAt(Pair<Integer, Integer> position, CardinalPoint heading) {
        return this.position.equals(position) && this.head.isHeading(heading);
    }

    public void moveDown() {
        this.position = new Pair<>(this.position.getKey(), this.position.getValue() - 1);
    }

    public void moveLeft() {
        this.position = new Pair<>(this.position.getKey() - 1, this.position.getValue());
    }

    public void moveRight() {
        this.position = new Pair<>(this.position.getKey() + 1, this.position.getValue());
    }

    public void moveUp() {
        this.position = new Pair<>(this.position.getKey(), this.position.getValue() + 1);
    }

    public void headEast() {
        this.head = new MarsRoverHeadFacingEast(this);
    }

    public void headNorth() {
        this.head = new MarsRoverHeadFacingNorth(this);
    }

    public void headSouth() {
        this.head = new MarsRoverHeadFacingSouth(this);
    }

    public void headWest() {
        this.head = new MarsRoverHeadFacingWest(this);
    }

    private void validateCommand(char command) {
        if (isInvalidCommand(command)) {
            throw new InvalidCommandException(command);
        }
    }

    private void processCommand(char command) {
        if (this.isForwardCommand(command))
            this.head.movingForward();
        if (this.isBackwardCommand(command))
            this.head.movingBackwards();
        if (this.isRotateRightCommand(command))
            this.head.rotateRight();
        if (this.isRotateLeftCommand(command))
            this.head.rotateLeft();
    }

    private boolean isBackwardCommand(char command) {
        return BACKWARD_COMMAND == command;
    }

    private boolean isForwardCommand(char command) {
        return FORWARD_COMMAND == command;
    }

    private boolean isRotateRightCommand(char command) {
        return ROTATE_RIGHT_COMMAND == command;
    }

    private boolean isRotateLeftCommand(char command) {
        return ROTATE_LEFT_COMMAND == command;
    }

    private boolean isInvalidCommand(char command) {
        return !isBackwardCommand(command) && !isForwardCommand(command) && !isRotateLeftCommand(command)
                && !isRotateRightCommand(command);
    }

}
