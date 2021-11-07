package com.marsrover.model;

public class MarsRoverHeadFacingWest extends MarsRoverHead {

    public MarsRoverHeadFacingWest(MarsRover marsRover) {
        super(marsRover);
    }

    @Override public boolean whenFacing(CardinalPoint cardinalPoint) {
        return CardinalPoint.WEST.equals(cardinalPoint);
    }

    @Override public void movingBackwards() {
        this.marsRover.moveRight();
    }

    @Override public void movingForward() {
        this.marsRover.moveLeft();
    }

    @Override public void rotateLeft() {
        this.marsRover.headSouth();
    }

    @Override public void rotateRight() {
        this.marsRover.headNorth();
    }
}
