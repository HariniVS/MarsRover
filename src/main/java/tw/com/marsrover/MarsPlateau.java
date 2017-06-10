package tw.com.marsrover;

public class MarsPlateau {

    private int lowerRightXCoordinate = 0;
    private int lowerRightYCoordinate = 0;
    private final int upperRightXCoordinate;
    private final int upperRightYCoordinate;
    private RoverPosition roverPosition;

    public MarsPlateau(int upperRightXCoordinate, int upperRightYCoordinate) {
        this.upperRightXCoordinate = upperRightXCoordinate;
        this.upperRightYCoordinate = upperRightYCoordinate;
    }

    public int getLowerRightXCoordinate() {
        return lowerRightXCoordinate;
    }

    public int getLowerRightYCoordinate() { return lowerRightYCoordinate; }

    public int getUpperRightXCoordinate() {
        return upperRightXCoordinate;
    }

    public int getUpperRightYCoordinate() {
        return upperRightYCoordinate;
    }

    boolean isRoverPositionValid(RoverPosition roverPosition) {
        this.roverPosition = roverPosition;
        boolean isValidUpperCoordinates = (this.roverPosition.getxCoordinate() <= getUpperRightXCoordinate() && this.roverPosition.getyCoordinate() <= getUpperRightYCoordinate());
        boolean isValidLowerCoordinates = (this.roverPosition.getxCoordinate() >= getLowerRightXCoordinate() && this.roverPosition.getyCoordinate() >= getLowerRightYCoordinate());
        return (isValidUpperCoordinates && isValidLowerCoordinates);
    }

}
