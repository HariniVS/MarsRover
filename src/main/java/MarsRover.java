import java.util.Scanner;

public class MarsRover {

    private MarsPlateau plateau;
    private RoverNavigation roverNavigation = new RoverNavigation();
    private RoverCoordinates roverCoordinates;
    private String roverDirection;

    public MarsRover(MarsPlateau plateau) {
        this.plateau = plateau;
    }

    public String getRoverPosition() {
        return roverCoordinates.getxCoordinate() + " " + roverCoordinates.getyCoordinate() + " " + roverDirection;
    }

    public void setRoverPosition(RoverCoordinates roverCoordinates, String roverDirection) {

        this.roverDirection = roverDirection;
        this.roverCoordinates = roverCoordinates;

        if (!roverPositionValid()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean roverPositionValid() {
        boolean isValidUpperCoordinates = (roverCoordinates.getxCoordinate() <= plateau.getUpperRightXCoordinate() && roverCoordinates.getyCoordinate() <= plateau.getUpperRightYCoordinate());
        boolean isValidLowerCoordinates = (roverCoordinates.getxCoordinate() >= plateau.getLowerRightXCoordinate() && roverCoordinates.getyCoordinate() >= plateau.getLowerRightYCoordinate());
        return (isValidUpperCoordinates && isValidLowerCoordinates);
    }

    public void shiftRoverDirection(String command) {

        for (int index = 0; index < command.length(); index++) {
            char currentCommand = command.charAt(index);
            if (currentCommand == 'M') {
                roverCoordinates = roverNavigation.moveForwardInCurrentDirection(roverCoordinates, roverDirection);
            } else if (currentCommand == 'L' || currentCommand == 'R') {
                roverDirection = roverNavigation.shiftRoverDirection(currentCommand, roverDirection);
            }
            setRoverPosition(roverCoordinates, roverDirection);
        }

    }

    public String getCurrentDirection() {
        return roverDirection;
    }

    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        MarsPlateau plateau = new MarsPlateau(scannerObject.nextInt(), scannerObject.nextInt());
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates;
        while (scannerObject.hasNext()) {
            roverCoordinates = new RoverCoordinates(scannerObject.nextInt(),scannerObject.nextInt());
            marsRover.setRoverPosition(roverCoordinates, scannerObject.next());
            marsRover.shiftRoverDirection(scannerObject.next());
            System.out.println(marsRover.getRoverPosition());
        }
    }
}

