public class MarsRover {

    private MarsPlateau plateau;
    private RoverPosition roverPosition;
    private int xCoordinateToBeSet;
    private int yCoordinateToBeSet;
    RoverNavigation roverNavigation = new RoverNavigation();

    public MarsRover(MarsPlateau plateau) {
        this.plateau = plateau;
    }

    public String getRoverPosition() {
        return roverPosition.xCoordinate+" "+roverPosition.yCoordinate+" "+roverPosition.roverDirection;
    }

    public void setRoverPosition(int xCoordinate, int yCoordinate, String roverDirection) {

        this.xCoordinateToBeSet = xCoordinate;
        this.yCoordinateToBeSet = yCoordinate;

        if (roverPositionValid()) {
            roverPosition = new RoverPosition(xCoordinate, yCoordinate, roverDirection);
        }
    }

    private boolean roverPositionValid() {
        return (xCoordinateToBeSet < plateau.getUpperRightXCoordinate() && yCoordinateToBeSet < plateau.getUpperRightYCoordinate());
    }
        
    public void shiftRoverDirection(String command) {

        for (int index = 0; index < command.length(); index++) {
            char currentCommand = command.charAt(index);
            roverPosition.roverDirection = roverNavigation.shiftRoverDirection(currentCommand, roverPosition.roverDirection);
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

