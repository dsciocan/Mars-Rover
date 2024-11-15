package rover.Parsers;

import rover.Plateau;

public class CoordinateParser {


    public static boolean checkInput(String s) {
        return s.matches("^\\d+(\\s+\\d+)$");
    }

    public static Plateau generatePlateau(String coordString) {
        if(checkInput(coordString)) {
            int x = Integer.parseInt(coordString.substring(0, coordString.indexOf(" ")));
            int y = Integer.parseInt(coordString.substring(coordString.indexOf(" ") + 1));
            return new Plateau(x, y);
        } else {
            System.out.println("Invalid input format, remember to write your coordinates as 'x y'");
            throw new IllegalArgumentException();
        }
    }
}
