package tw.com.marsrover;

public class TurnRight implements RoverCommand {

    private RoverNavigation roverNavigation;

    @Override
    public RoverPosition getNewPosition(RoverPosition roverPosition) {
        roverNavigation = new RoverNavigation(roverPosition);
        RoverPosition newRoverPosition = roverNavigation.turnRight();
        return newRoverPosition;
    }
}
