package rover;

import rover.Parsers.MovesetParser;
import rover.Parsers.PositionParser;

import java.util.ArrayList;

public class Rover {
    private final Position initialPosition;
    private Position currentPosition;


    public Rover(Position initialPosition) {
        this.initialPosition = initialPosition;
        currentPosition = initialPosition;

    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }


    public void faceLeft() {
        System.out.println("The rover is turning left");
        switch (currentPosition.facing){
            case Cardinal.N -> currentPosition.facing = Cardinal.W;
            case Cardinal.E -> currentPosition.facing = Cardinal.N;
            case Cardinal.S -> currentPosition.facing = Cardinal.E;
            case Cardinal.W -> currentPosition.facing = Cardinal.S;
        }
    }

    public void faceRight() {
        System.out.println("The rover is turning right");
        switch (currentPosition.facing){
            case Cardinal.N -> currentPosition.facing = Cardinal.E;
            case Cardinal.E -> currentPosition.facing = Cardinal.S;
            case Cardinal.S -> currentPosition.facing = Cardinal.W;
            case Cardinal.W -> currentPosition.facing = Cardinal.N;

        }
    }

    public void move() {
        System.out.println("The rover is attempting to move.");
        currentPosition.x += currentPosition.facing.getMoveX();
        currentPosition.y += currentPosition.facing.getMoveY();
    }
}
