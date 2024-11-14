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
}
