import java.util.Scanner;

public class MarsRover {

    private MarsPlateau plateau;
    private RoverPosition roverPosition;
    private int xCoordinateToBeSet;
    private int yCoordinateToBeSet;
    private RoverNavigation roverNavigation = new RoverNavigation();
    private RoverCoordinates roverCoordinates;

    public MarsRover(MarsPlateau plateau) {
        this.plateau = plateau;
    }

    public String getRoverPosition() {
        return roverPosition.xCoordinate + " " + roverPosition.yCoordinate + " " + roverPosition.roverDirection;
    }

    public void setRoverPosition(RoverCoordinates roverCoordinates, String roverDirection) {

        this.xCoordinateToBeSet = roverCoordinates.getxCoordinate();
        this.yCoordinateToBeSet = roverCoordinates.getyCoordinate();
        this.roverCoordinates = roverCoordinates;
        if (!roverPositionValid()) {
            throw new IllegalArgumentException();
        }

        roverPosition = new RoverPosition(roverCoordinates.getxCoordinate(), roverCoordinates.getyCoordinate(), roverDirection);
    }

    private boolean roverPositionValid() {
        boolean isValidUpperCoordinates = (xCoordinateToBeSet <= plateau.getUpperRightXCoordinate() && yCoordinateToBeSet <= plateau.getUpperRightYCoordinate());
        boolean isValidLowerCoordinates = (xCoordinateToBeSet >= plateau.getLowerRightXCoordinate() && yCoordinateToBeSet >= plateau.getLowerRightYCoordinate());
        return (isValidUpperCoordinates && isValidLowerCoordinates);
    }

    public void shiftRoverDirection(String command) {

        for (int index = 0; index < command.length(); index++) {
            char currentCommand = command.charAt(index);
            if (currentCommand == 'M') {
                roverCoordinates = roverNavigation.moveForwardInCurrentDirection(roverCoordinates, roverPosition.roverDirection);
            } else if (currentCommand == 'L' || currentCommand == 'R') {
                roverPosition.roverDirection = roverNavigation.shiftRoverDirection(currentCommand, roverPosition.roverDirection);
            }
            setRoverPosition(roverCoordinates, roverPosition.roverDirection);
        }

    }

    public String getCurrentDirection() {
        return roverPosition.roverDirection;
    }

    private class RoverPosition {

        private String roverDirection;
        private int yCoordinate;
        private int xCoordinate;

        public RoverPosition(int xCoordinate, int yCoordinate, String roverDirection) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.roverDirection = roverDirection;
        }
    }

    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        MarsPlateau plateau = new MarsPlateau(scannerObject.nextInt(), scannerObject.nextInt());
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates;
        while (scannerObject.hasNextLine()) {
            roverCoordinates = new RoverCoordinates(scannerObject.nextInt(),scannerObject.nextInt());
            marsRover.setRoverPosition(roverCoordinates, scannerObject.next());
            marsRover.shiftRoverDirection(scannerObject.next());
            System.out.println(marsRover.getRoverPosition());
        }
    }
}

