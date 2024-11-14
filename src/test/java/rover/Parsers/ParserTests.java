package rover.Parsers;

import org.junit.Test;
import rover.Instruction;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTests {

    @Test
    public void testGenerateMoveset_fullyInvalidString() {
        String testString = "abcdhshks";
        ArrayList<Instruction> expected = new ArrayList<>();
        assertEquals(expected, movesetParser.generateMoveset(testString));
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
        assertEquals(expected, movesetParser.generateMoveset(testString));
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
        assertEquals(expected, movesetParser.generateMoveset(testString));
    }


}