public class MarsPlateau {

    private int lowerRightXCoordinate;
    private int lowerRightYCoordinate;
    private final int upperRightXCoordinate;
    private final int upperRightYCoordinate;

    public MarsPlateau(int upperRightXCoordinate, int upperRightYCoordinate) {
       this.upperRightXCoordinate = upperRightXCoordinate;
       this.upperRightYCoordinate = upperRightYCoordinate;
    }

    public int getLowerRightXCoordinate() {
        return lowerRightXCoordinate;
    }

    public int getLowerRightYCoordinate() {
        return lowerRightYCoordinate;
    }


    public int getUpperRightXCoordinate() {
        return upperRightXCoordinate;
    }

    public int getUpperRightYCoordinate() {
        return upperRightYCoordinate;
    }
}
