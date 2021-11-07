package com.marsrover.model;

public class MarsRoverHeadFacingNorth extends MarsRoverHead {

    public MarsRoverHeadFacingNorth(MarsRover marsRover) {
        super(marsRover);
    }

    @Override public boolean whenFacing(CardinalPoint cardinalPoint) {
        return CardinalPoint.NORTH.equals(cardinalPoint);
    }

    @Override public void movingBackwards() {
        this.marsRover.moveDown();
    }

    @Override public void movingForward() {
        this.marsRover.moveUp();
    }

    @Override public void rotateLeft() {
        this.marsRover.headWest();
    }

    @Override public void rotateRight() {
        this.marsRover.headEast();
    }
}
