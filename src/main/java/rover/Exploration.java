package rover;

import com.sun.net.httpserver.Authenticator;
import rover.Parsers.MovesetParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Exploration {
    private final Rover rover;
    private final Plateau plateau;
    private final ArrayList<Instruction> moveset;

    public Exploration(Rover rover, Plateau plateau, ArrayList<Instruction> moveset) {
        if(rover.getInitialPosition().x > plateau.sizeX() || rover.getInitialPosition().y > plateau.sizeY() || rover.getInitialPosition().x < 0 || rover.getInitialPosition().y < 0) {
            throw new InputMismatchException("Rover landed outside of plateau! Abort mission('q') or send a new rover('c')!");
        }
        this.rover = rover;
        this.plateau = plateau;
        this.moveset = moveset;
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

    public boolean canMove(int intendedX, int intendedY) {
        return intendedX <= plateau.sizeX() && intendedX >= 0 && intendedY <= plateau.sizeY() && intendedY >= 0;
    }

    public void executeMoveset() {
        for(Instruction move : moveset) {
            switch (move) {
                case Instruction.L -> rover.faceLeft();
                case Instruction.R -> rover.faceRight();
                case Instruction.M -> {
                    System.out.println("The rover is attempting to move...");
                    Position potentialMove = rover.visualiseMove();
                    if(canMove(potentialMove.x, potentialMove.y)) {
                        rover.move();
                        System.out.println("Successfully moved.");
                    } else {
                        System.out.println("Move is out of permitted area, this instruction will be skipped.");
                    }
                }
            }
            System.out.println("Current rover position is: (" + rover.getCurrentPosition().x + " " + rover.getCurrentPosition().y + " " + rover.getCurrentPosition().facing.name() + ")");
        };
    }
}
