package rover.Parsers;

import rover.Instruction;

import java.util.ArrayList;
import java.util.Arrays;

public class MovesetParser{

    public static boolean checkInput(String s) {
        return Arrays.stream(Instruction.values()).map(Enum::name).toList().contains(s.toUpperCase());
    }

    public static ArrayList<Instruction> generateMoveset(String movesetString) {
        ArrayList<Instruction> moveset = new ArrayList<>();
        for(String s : movesetString.split("")) {
            if(checkInput(s)) {
                moveset.add(Instruction.valueOf(s.toUpperCase()));
            } else {
                System.out.println( "'" + s.toUpperCase() + "' is an invalid instruction. It will be skipped when calculating rover path.");
            }
        }
        return moveset;
    }
}
