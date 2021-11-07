package com.marsrover.model;

public class MarsRoverHeadFacingEast extends MarsRoverHead {

    public MarsRoverHeadFacingEast(MarsRover marsRover) {
        super(marsRover);
    }

    @Override public boolean whenFacing(CardinalPoint cardinalPoint) {
        return CardinalPoint.EAST.equals(cardinalPoint);
    }

    @Override public void movingBackwards() {
        this.marsRover.moveLeft();
    }

    @Override public void movingForward() {
        this.marsRover.moveRight();
    }

    @Override public void rotateLeft() {
        this.marsRover.headNorth();
    }

    @Override public void rotateRight() {
        this.marsRover.headSouth();
    }
}
