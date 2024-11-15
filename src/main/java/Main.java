import rover.Exploration;
import rover.Parsers.CoordinateParser;
import rover.Parsers.PositionParser;
import rover.Plateau;
import rover.Rover;

public class Main {

    public static void main(String[] args) {
        String[] testArray = {"5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"};
        Plateau plateau = CoordinateParser.generatePlateau(testArray[0]);
        Rover roverOne = new Rover(PositionParser.generateStartingPosition(testArray[1]));
        Exploration explorationOne = new Exploration(roverOne, plateau, testArray[2]);
        explorationOne.executeMoveset();
        Rover roverTwo = new Rover(PositionParser.generateStartingPosition(testArray[3]));
        Exploration explorationTwo = new Exploration(roverTwo, plateau, testArray[4]);
        explorationTwo.executeMoveset();
    }

}
