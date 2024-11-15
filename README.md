# Mars Rover

Ever wanted to move your own little exploration rover across a predefined surface of (fake) Mars, all from the comfort of your own command line? Then read on!

### Summary
This project was made in Java.
Currently, the functionality allows the user to set up a rover, the coordinates it is allowed to explore and make it move using Left, Right, Move instructions, as well as North, South, East and West cardinal points.

The rover will skip any invalid commands or instructions that cause it to move outside the predefined bounds.
It will also print to the console details of the move it is executing and its coordinates in real time.

### Installation

To run this program, please fork and clone this repo to your local device. 


## Usage:
Inside the Main class, there is already a functional example of how this program is initialised, so feel free to modify coordinates and/or make your own rovers.
Running the main method will start the program.
* Please note that coordinates must be passed in as strings as follows:
- "x y" for the Plateau;
- "x y Cardinal Point(N/S/W/E)" for the Rover starting position;
