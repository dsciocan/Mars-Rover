package rover;

import rover.Parsers.MovesetParser;
import rover.Parsers.PositionParser;

import java.util.ArrayList;

public class Rover {
    private final Position initialPosition;
    private Position currentPosition;
    private final ArrayList<Instruction> moveset;

    public Rover(String initialPositionString, String movesetString) {
        initialPosition = PositionParser.generateStartingPosition(initialPositionString);
        currentPosition = initialPosition;
        moveset = MovesetParser.generateMoveset(movesetString);
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public ArrayList<Instruction> getMoveset() {
        return moveset;
    }


    public void faceLeft() {
        switch (currentPosition.facing){
            case Cardinal.N -> currentPosition.facing = Cardinal.W;
            case Cardinal.E -> currentPosition.facing = Cardinal.N;
            case Cardinal.S -> currentPosition.facing = Cardinal.E;
            case Cardinal.W -> currentPosition.facing = Cardinal.S;

        }
    }

    public void faceRight() {
        switch (currentPosition.facing){
            case Cardinal.N -> currentPosition.facing = Cardinal.E;
            case Cardinal.E -> currentPosition.facing = Cardinal.S;
            case Cardinal.S -> currentPosition.facing = Cardinal.W;
            case Cardinal.W -> currentPosition.facing = Cardinal.N;

        }
    }
}
