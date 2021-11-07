package com.marsrover.model;

public class MarsRoverHeadFacingSouth extends MarsRoverHead {

    public MarsRoverHeadFacingSouth(MarsRover marsRover) {
        super(marsRover);
    }

    @Override public boolean whenFacing(CardinalPoint cardinalPoint) {
        return CardinalPoint.SOUTH.equals(cardinalPoint);
    }

    @Override public void movingBackwards() {
        this.marsRover.moveUp();
    }

    @Override public void movingForward() {
        this.marsRover.moveDown();
    }

    @Override public void rotateLeft() {
        this.marsRover.headEast();
    }

    @Override public void rotateRight() {
        this.marsRover.headWest();
    }
}
