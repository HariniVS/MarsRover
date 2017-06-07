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
        RoverCoordinates roverCoordinates = new RoverCoordinates(1,2);
        marsRover.setRoverPosition(roverCoordinates, "N");
        assertEquals("1 2 N", marsRover.getRoverPosition());
    }

    @Test
    public void shouldPerformLeftTurnAndReturnDirectionAsWIfCurrentCommandIsN() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates = new RoverCoordinates(1,2);
        marsRover.setRoverPosition(roverCoordinates, "N");
        marsRover.shiftRoverDirection("L");
        Assert.assertEquals("W", marsRover.getCurrentDirection());
    }

    @Test
    public void shouldPerformRightTurnAndReturnDirectionAsEIfCurrentCommandIsN() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates = new RoverCoordinates(1,2);
        marsRover.setRoverPosition(roverCoordinates, "N");
        marsRover.shiftRoverDirection("R");
        Assert.assertEquals("E", marsRover.getCurrentDirection());
    }

    @Test
    public void shouldMoveForwardEDirectionIfCurrentCommandIsM(){
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates = new RoverCoordinates(1,2);
        marsRover.setRoverPosition(roverCoordinates, "E");
        marsRover.shiftRoverDirection("M");
        Assert.assertEquals("E",marsRover.getCurrentDirection());
        Assert.assertEquals("2 2 E",marsRover.getRoverPosition());
    }

    @Test
    public void shouldPerformASeriesOfCommandsAndReturnCurrentPosition() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates = new RoverCoordinates(3,3);
        marsRover.setRoverPosition(roverCoordinates, "E");
        marsRover.shiftRoverDirection("MMRMMRMRRM");
        Assert.assertEquals("5 1 E",marsRover.getRoverPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldPass() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        MarsRover marsRover = new MarsRover(plateau);
        RoverCoordinates roverCoordinates = new RoverCoordinates(1,2);
        marsRover.setRoverPosition(roverCoordinates, "S");
        marsRover.shiftRoverDirection("MMMM");
    }

}
