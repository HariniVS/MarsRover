public class MarsRover {

    private MarsPlateau plateau;
    private RoverPosition roverPosition;
    private int xCoordinateToBeSet;
    private int yCoordinateToBeSet;
    RoverNavigation roverNavigation = new RoverNavigation();
    private RoverCoordinates roverCoordinates;

    public MarsRover(MarsPlateau plateau) {
        this.plateau = plateau;
    }

    public String getRoverPosition() {
        return roverPosition.xCoordinate + " " + roverPosition.yCoordinate + " " + roverPosition.roverDirection;
    }

    public void setRoverPosition(RoverCoordinates roverCoordinates, String roverDirection) {

        this.roverCoordinates = roverCoordinates;
        this.xCoordinateToBeSet = roverCoordinates.getxCoordinate();
        this.yCoordinateToBeSet = roverCoordinates.getyCoordinate();

        if (!roverPositionValid()) {
            throw new IllegalArgumentException();
        }

        roverPosition = new RoverPosition(xCoordinateToBeSet, yCoordinateToBeSet, roverDirection);
        return;
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
}

