package rover.Parsers;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import rover.Instruction;
import rover.Plateau;

import java.util.ArrayList;

import static org.junit.Assert.*;

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

    @Test (expected = IllegalArgumentException.class)
    public void testGenerateCoordinates_fullyInvalidString() {
        String testString = "abcd hshks";
        CoordinateParser.generateCoordinates(testString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGenerateCoordinates_PartiallyInvalidString() {
        String testString = "3 4 abcd hshks";
        CoordinateParser.generateCoordinates(testString);
    }

    @Test
    public void testGenerateCoordinates_ValidString() {
        String testString = "3 4";
        Plateau expected = new Plateau(3,4);
        assertEquals(expected, CoordinateParser.generateCoordinates(testString));
    }



}