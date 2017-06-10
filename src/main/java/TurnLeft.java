/**
 * Created by harinivs on 10/06/17.
 */
public class TurnLeft implements RoverCommand {

    private RoverNavigation roverNavigation;

    @Override
    public RoverPosition getNewPosition(RoverPosition roverPosition) {
        roverNavigation = new RoverNavigation(roverPosition);
        RoverPosition newRoverPosition = roverNavigation.turnLeft();
        return newRoverPosition;
    }
}
