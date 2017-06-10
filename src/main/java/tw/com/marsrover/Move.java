package tw.com.marsrover;

public class Move implements RoverCommand {

    private RoverNavigation roverNavigation;

    @Override
    public RoverPosition getNewPosition(RoverPosition roverPosition) {
        roverNavigation = new RoverNavigation(roverPosition);
        RoverPosition newRoverPosition = roverNavigation.move();
        return newRoverPosition;
    }
}
