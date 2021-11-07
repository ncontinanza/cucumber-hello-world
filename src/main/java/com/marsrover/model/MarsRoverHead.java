package com.marsrover.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class MarsRoverHead {

    protected final MarsRover marsRover;

    boolean isHeading(CardinalPoint cardinalPoint) {
        return this.whenFacing(cardinalPoint);
    }

    public abstract boolean whenFacing(CardinalPoint cardinalPoint);

    public abstract void movingBackwards();

    public abstract void movingForward();

    public abstract void rotateLeft();

    public abstract void rotateRight();

}
