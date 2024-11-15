package rover;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExplorationTest {

    @Test
    public void executeMoveset_EmptyMoveset() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "");
        testExploration.executeMoveset();
        assertEquals(new Position(3, 5, Cardinal.N), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_NoValidMoves() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "ghCVNNA");
        testExploration.executeMoveset();
        assertEquals(new Position(3, 5, Cardinal.N), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_OnlyLRMoveset() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "LLRL");
        testExploration.executeMoveset();
        assertEquals(new Position(3, 5, Cardinal.S), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_NotAllValidMoves() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "RRJFMlmfa");
        testExploration.executeMoveset();
        assertEquals(new Position(4, 4, Cardinal.E), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_TurnAndMove() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "LLMML");
        testExploration.executeMoveset();
        assertEquals(new Position(3, 3, Cardinal.E), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_ComplexMoveset() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "RMRMLMRM");
        testExploration.executeMoveset();
        assertEquals(new Position(5, 3, Cardinal.S), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_OutOfBoundsY() {
        Rover testRover= new Rover(new Position(6, 7, Cardinal.N));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "MRMLMRM");
        testExploration.executeMoveset();
        assertEquals(new Position(7, 7, Cardinal.E), testRover.getCurrentPosition());
    }

    @Test
    public void executeMoveset_OutOfBoundsX() {
        Rover testRover= new Rover(new Position(0, 4, Cardinal.W));
        Plateau testPlateau = new Plateau(7, 7);
        Exploration testExploration = new Exploration(testRover, testPlateau, "MRMLMRM");
        testExploration.executeMoveset();
        assertEquals(new Position(0, 6, Cardinal.N), testRover.getCurrentPosition());
    }


}