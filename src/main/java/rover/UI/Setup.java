package rover.UI;

import rover.Instruction;
import rover.Parsers.CoordinateParser;
import rover.Parsers.MovesetParser;
import rover.Parsers.PositionParser;
import rover.Plateau;
import rover.Rover;

import java.util.ArrayList;

public class Setup {
    public static Plateau createPlateau(){
        while(true) {
            String plateauCoordinates = InputSource.promptCoordinates();
            try {
                return CoordinateParser.generatePlateau(plateauCoordinates);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Rover createRover(){
        while(true) {
            String startingPosition = InputSource.promptStartingPosition();
            try {
                return new Rover(PositionParser.generateStartingPosition(startingPosition));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<Instruction> createInstructionList() {
        String movesetString = InputSource.promptMoveset();
        return MovesetParser.generateMoveset(movesetString);
    }



}
