package rover;

import com.sun.net.httpserver.Authenticator;
import rover.Parsers.MovesetParser;

import java.util.ArrayList;

public class Exploration {
    private final Rover rover;
    private final Plateau plateau;
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
