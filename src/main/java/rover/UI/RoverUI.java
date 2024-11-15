package rover.UI;

import rover.Exploration;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoverUI {

    public static void runRover() {
        System.out.println("Hello and welcome to the Mars Rover dispacher, where you get to set up your very own Rover to move across a predetermined surface of (fake) Mars!");
        System.out.println("Let's start by setting up your exploration environment!");
        while(true) {
            try {
                Exploration exploration = new Exploration(Setup.createRover(), Setup.createPlateau(), Setup.createInstructionList());
                exploration.executeMoveset();
                System.out.println("Do you want to go on another exploration? q/c");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } finally {
                Scanner redoScanner = new Scanner(System.in);
                String choice = redoScanner.nextLine();
                if(!choice.equalsIgnoreCase("c")) {
                    return;
                }
            }
        }

    }
}
