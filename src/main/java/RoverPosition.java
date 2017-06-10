
public class RoverPosition {
    private String roverDirection;
    private int yCoordinate;
    private int xCoordinate;

    public RoverPosition(int xCoordinate, int yCoordinate, String roverDirection) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.roverDirection = roverDirection;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public String getRoverDirection() {
        return roverDirection;
    }
}
