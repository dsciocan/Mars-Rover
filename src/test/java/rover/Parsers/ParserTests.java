package rover.Parsers;


import org.junit.jupiter.api.Test;

import rover.Cardinal;
import rover.Instruction;
import rover.Plateau;
import rover.Position;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTests {

    //Moveset Parser Tests

    @Test
    public void testGenerateMoveset_fullyInvalidString() {
        String testString = "abcdhshks";
        ArrayList<Instruction> expected = new ArrayList<>();
        assertEquals(expected, MovesetParser.generateMoveset(testString));
    }

    @Test
    public void testGenerateMoveset_partiallyInvalidString() {
        String testString = "alrbcdmmhslhks";
        ArrayList<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.R);
        expected.add(Instruction.M);
        expected.add(Instruction.M);
        expected.add(Instruction.L);
        assertEquals(expected, MovesetParser.generateMoveset(testString));
    }

    @Test
    public void testGenerateMoveset_validString() {
        String testString = "lrMML";
        ArrayList<Instruction> expected = new ArrayList<>();
        expected.add(Instruction.L);
        expected.add(Instruction.R);
        expected.add(Instruction.M);
        expected.add(Instruction.M);
        expected.add(Instruction.L);
        assertEquals(expected, MovesetParser.generateMoveset(testString));
    }

    //Coordinate Parser Tests

    @Test
    public void testGenerateCoordinates_fullyInvalidString() {
        String testString = "abcd hshks";
        assertThrows(IllegalArgumentException.class, () ->  CoordinateParser.generatePlateau(testString), "");
    }

    @Test
    public void testGenerateCoordinates_PartiallyInvalidString() {
        String testString = "3 4 abcd hshks";
        assertThrows(IllegalArgumentException.class, () ->  CoordinateParser.generatePlateau(testString), "");
    }

    @Test
    public void testGenerateCoordinates_ValidString() {
        String testString = "3 4";
        Plateau expected = new Plateau(3,4);
        assertEquals(expected, CoordinateParser.generatePlateau(testString));
    }

    //Position Parser Tests

    @Test ()
    public void testGenerateStartingPosition_fullyInvalidString() {
        String testString = "abcd hshks a45";
        assertThrows(IllegalArgumentException.class, () ->  PositionParser.generateStartingPosition(testString), "");
    }

    @Test
    public void testGenerateStartingPosition_PartiallyInvalidString() {
        String testString = "3 4 N abcd hshks";
        assertThrows(IllegalArgumentException.class, () ->  PositionParser.generateStartingPosition(testString), "");
    }

    @Test
    public void testGenerateStartingPosition_ValidString() {
        String testString = "3 4 n";
        Position expected = new Position(3,4, Cardinal.N);
        assertEquals(expected, PositionParser.generateStartingPosition(testString));
    }

}