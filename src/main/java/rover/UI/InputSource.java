package rover.UI;

import java.util.Scanner;

public class InputSource {

    public static String promptCoordinates() {
        Scanner coordinateScanener = new Scanner(System.in);
        System.out.println("Please input the size of the plateau your rover will be exploring:");
        System.out.println("*note: please follow the 'x y' input format");
        String coordinates = coordinateScanener.nextLine();
        return coordinates;
    }

    public static String promptStartingPosition() {
        Scanner positionScanener = new Scanner(System.in);
        System.out.println("Please input the coordinates and direction your rover should start exploring from:");
        System.out.println("*note: please follow the 'x y CardinalPoint(N/S/E/W)' input format");
        String startingPosition = positionScanener.nextLine();
        return startingPosition;
    }

    public static String promptMoveset() {
        Scanner movesetScanener = new Scanner(System.in);
        System.out.println("Please input a string of commands for the path your rover will take:");
        System.out.println("*The usable commands are: 'L'(Turn Left), 'R'(Turn Right), 'M'(Move 1 unit in the direction the rover is currently facing). Any other commands will be disregarded.");
        String moveset = movesetScanener.nextLine();
        return moveset;
    }
}
