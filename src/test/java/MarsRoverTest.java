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
        marsRover.setRoverPosition(1,2,"N");
        assertEquals("1 2 N",marsRover.getRoverPosition());
    }
}
