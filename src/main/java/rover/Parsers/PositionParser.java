package rover.Parsers;

import rover.Position;

public class PositionParser {

    public static boolean checkInput(String s) {
        return s.matches("^\\d+\\s\\d+\\s[NESWnesw]$");
    }

//    public Position parseStartingPosition(String positionString) {
//
//    }
}
