package rover;

import org.junit.Test;

import static org.junit.Assert.*;
public class RoverTest {

    //Face Left
    @Test
    public void faceLeft_N() {
        Rover testRover= new Rover("3 5 N");
        testRover.faceLeft();
        assertEquals(Cardinal.W, testRover.getCurrentPosition().facing);
    }

    @Test
    public void faceLeft_S() {
        Rover testRover= new Rover("3 5 S");
        testRover.faceLeft();
        assertEquals(Cardinal.E, testRover.getCurrentPosition().facing);
    }

    //Face Right
    @Test
    public void faceRight_E() {
        Rover testRover= new Rover("3 5 E");
        testRover.faceRight();
        assertEquals(Cardinal.S, testRover.getCurrentPosition().facing);
    }

    @Test
    public void faceRight_W() {
        Rover testRover= new Rover("3 5 W");
        testRover.faceRight();
        assertEquals(Cardinal.N, testRover.getCurrentPosition().facing);
    }

    //Move
    @Test
    public void move_xAxis() {
        Rover testRover= new Rover("3 5 W");
        testRover.move();
        assertEquals(new Position(2, 5, Cardinal.W), testRover.getCurrentPosition());
    }

    @Test
    public void move_yAxis() {
        Rover testRover= new Rover("3 5 N");
        testRover.move();
        assertEquals(new Position(3, 6, Cardinal.N), testRover.getCurrentPosition());
    }

    @Test
    public void move_AndTurnLeft() {
        Rover testRover= new Rover("3 5 N");
        testRover.move();
        testRover.faceLeft();
        testRover.move();
        assertEquals(new Position(2, 6, Cardinal.W), testRover.getCurrentPosition());
    }

    @Test
    public void move_AndTurnRight() {
        Rover testRover= new Rover("3 5 N");
        testRover.move();
        testRover.faceRight();
        testRover.move();
        assertEquals(new Position(4, 6, Cardinal.E), testRover.getCurrentPosition());
    }
}