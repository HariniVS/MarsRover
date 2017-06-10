package tw.com.marsrover;

import java.util.ArrayList;
import java.util.Arrays;

class RoverNavigation {

    ArrayList<String> direction = new ArrayList<String>(Arrays.asList("N", "E", "S", "W"));

    private int currentYCoordinate;
    private int currentXCoordinate;
    private String currentRoverDirection;
    private RoverPosition roverPosition;
    private int currentIndex;


    public RoverNavigation(RoverPosition roverPosition) {

        this.roverPosition = roverPosition;

        currentXCoordinate = roverPosition.getxCoordinate();
        currentYCoordinate = roverPosition.getyCoordinate();
        currentRoverDirection = roverPosition.getRoverDirection();
        currentIndex = direction.indexOf(currentRoverDirection);
    }

    public RoverPosition move() {
        if (currentRoverDirection.equals("N")) {
            currentYCoordinate += 1;
        }
        if (currentRoverDirection.equals("E")) {
            currentXCoordinate += 1;
        }
        if (currentRoverDirection.equals("S")) {
            currentYCoordinate -= 1;
        }
        if (currentRoverDirection.equals("W")) {
            currentXCoordinate -= 1;
        }
        return new RoverPosition(currentXCoordinate, currentYCoordinate, currentRoverDirection);
    }

    public RoverPosition turnLeft() {
        currentRoverDirection = direction.get((currentIndex + direction.size() - 1) % 4);
        return new RoverPosition(currentXCoordinate, currentYCoordinate, currentRoverDirection);
    }

    public RoverPosition turnRight() {
        currentRoverDirection = direction.get((currentIndex + direction.size() + 1) % 4);
        return new RoverPosition(currentXCoordinate, currentYCoordinate, currentRoverDirection);
    }

}
