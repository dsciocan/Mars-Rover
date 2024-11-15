package rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTests {

    //Face Left
    @Test
    public void faceLeft_N() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        testRover.faceLeft();
        assertEquals(Cardinal.W, testRover.getCurrentPosition().facing);
    }

    @Test
    public void faceLeft_S() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.S));
        testRover.faceLeft();
        assertEquals(Cardinal.E, testRover.getCurrentPosition().facing);
    }

    //Face Right
    @Test
    public void faceRight_E() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.E));
        testRover.faceRight();
        assertEquals(Cardinal.S, testRover.getCurrentPosition().facing);
    }

    @Test
    public void faceRight_W() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.W));
        testRover.faceRight();
        assertEquals(Cardinal.N, testRover.getCurrentPosition().facing);
    }

    //Move
    @Test
    public void move_xAxis() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.W));
        testRover.move();
        assertEquals(new Position(2, 5, Cardinal.W), testRover.getCurrentPosition());
    }

    @Test
    public void move_yAxis() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        testRover.move();
        assertEquals(new Position(3, 6, Cardinal.N), testRover.getCurrentPosition());
    }

    @Test
    public void move_AndTurnLeft() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        testRover.move();
        testRover.faceLeft();
        testRover.move();
        assertEquals(new Position(2, 6, Cardinal.W), testRover.getCurrentPosition());
    }

    @Test
    public void move_AndTurnRight() {
        Rover testRover= new Rover(new Position(3, 5, Cardinal.N));
        testRover.move();
        testRover.faceRight();
        testRover.move();
        assertEquals(new Position(4, 6, Cardinal.E), testRover.getCurrentPosition());
    }
}