package rover;


import org.junit.jupiter.api.Test;
import rover.Parsers.CoordinateParser;
import rover.Parsers.PositionParser;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {

    @Test
    public void testExpectedInputIntegration() {
        String[] testArray = {"5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"};
        Plateau plateau = CoordinateParser.generatePlateau(testArray[0]);
        Rover roverOne = new Rover(PositionParser.generateStartingPosition(testArray[1]));
        Exploration explorationOne = new Exploration(roverOne, plateau, testArray[2]);
        explorationOne.executeMoveset();
        Rover roverTwo = new Rover(PositionParser.generateStartingPosition(testArray[3]));
        Exploration explorationTwo = new Exploration(roverTwo, plateau, testArray[4]);
        explorationTwo.executeMoveset();
        assertAll(
                () -> assertEquals(new Position(1, 3, Cardinal.N), roverOne.getCurrentPosition()),
                () -> assertEquals(new Position(5, 1, Cardinal.E), roverTwo.getCurrentPosition())
        );
    }

    @Test
    public void testOutOfBoundsIntegration() {
        Plateau plateau = CoordinateParser.generatePlateau("3 3");
        Rover roverOne = new Rover(PositionParser.generateStartingPosition("1 2 N"));
        Exploration explorationOne = new Exploration(roverOne, plateau, "LMRMM");
        explorationOne.executeMoveset();
        Rover roverTwo = new Rover(PositionParser.generateStartingPosition("0 1 S"));
        Exploration explorationTwo = new Exploration(roverTwo, plateau, "LRRMMER");
        explorationTwo.executeMoveset();
        assertAll(
                () -> assertEquals(new Position(0, 3, Cardinal.N), roverOne.getCurrentPosition()),
                () -> assertEquals(new Position(0, 1, Cardinal.N), roverTwo.getCurrentPosition())
        );

    }


}
