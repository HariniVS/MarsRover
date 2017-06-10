import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MarsRoverTest {

    @Test
    public void createAMarsPlateauWithFollowingCoordinates() {
        assertNotNull(new MarsPlateau(5, 5));
    }

    @Test
    public void createRoverPositionToSetRoverPosition() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverPosition = new RoverPosition(1, 2, "N");
        marsRover.setRoverPosition(roverPosition);
        assertEquals("1 2 N", marsRover.getRoverPosition());
    }

    @Test
    public void shouldPerformLeftTurnAndReturnDirectionAsWIfCurrentCommandIsN() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverCoordinates = new RoverPosition(1, 2, "N");
        marsRover.setRoverPosition(roverCoordinates);
        marsRover.executeCommand("L");
        Assert.assertEquals("W", marsRover.getCurrentDirection());
    }

    @Test
    public void shouldPerformRightTurnAndReturnDirectionAsEIfCurrentCommandIsN() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverCoordinates = new RoverPosition(1, 2, "N");
        marsRover.setRoverPosition(roverCoordinates);
        marsRover.executeCommand("R");
        Assert.assertEquals("E", marsRover.getCurrentDirection());
    }

    @Test
    public void shouldMoveForwardEDirectionIfCurrentCommandIsM() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverCoordinates = new RoverPosition(1, 2, "N");
        marsRover.setRoverPosition(roverCoordinates);
        marsRover.executeCommand("M");
        Assert.assertEquals("1 3 N", marsRover.getRoverPosition());
    }

    @Test
    public void shouldPerformASeriesOfCommandsAndReturnCurrentPosition() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverCoordinates = new RoverPosition(3, 3, "E");
        marsRover.setRoverPosition(roverCoordinates);
        marsRover.executeCommand("MMRMMRMRRM");
        Assert.assertEquals("5 1 E", marsRover.getRoverPosition());
    }

    @Test
    public void shouldThrowAnException() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverCoordinates = new RoverPosition(1, 2, "N");
        marsRover.setRoverPosition(roverCoordinates);
        marsRover.executeCommand("MMMM");
        assertEquals("1 5 N", marsRover.getRoverPosition());
    }

}
