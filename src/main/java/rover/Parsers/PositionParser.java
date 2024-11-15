package rover.Parsers;

import rover.Cardinal;
import rover.Plateau;
import rover.Position;



public class PositionParser {

    public static boolean checkInput(String s) {
        return s.matches("^\\d+\\s\\d+\\s[NESWnesw]$");
    }

    public static Position generateStartingPosition(String positionString) {
        if(checkInput(positionString)) {
            int spaceIndex = positionString.indexOf(" ");
            int x = Integer.parseInt(positionString.substring(0, spaceIndex));
            int y = Integer.parseInt(positionString.substring(spaceIndex + 1, positionString.indexOf(" ", spaceIndex + 1)));
            Cardinal point = Cardinal.valueOf(positionString.substring(positionString.indexOf(" ", spaceIndex + 1) + 1).toUpperCase());
            return new Position(x, y, point);
        } else {
            throw new IllegalArgumentException("Invalid input format, remember to write your coordinates as 'x y N/E/S/W'");
        }
    }
}
