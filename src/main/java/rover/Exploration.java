package rover;

import rover.Parsers.MovesetParser;

import java.util.ArrayList;

public class Exploration {
    private Rover rover;
    private Plateau plateau;
    private final ArrayList<Instruction> moveset;

    public Exploration(Rover rover, Plateau plateau, String movesetString) {
        this.rover = rover;
        this.plateau = plateau;
        moveset = MovesetParser.generateMoveset(movesetString);
    }

    public Rover getRover() {
        return rover;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public ArrayList<Instruction> getMoveset() {
        return moveset;
    }

    public 
}
