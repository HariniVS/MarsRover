import org.junit.Test;
import static junit.framework.TestCase.assertNotNull;

public class MarsRoverTest {

    @Test
    public void createAMarsPlateauWithFollowingCoordinates() {
        assertNotNull(new MarsPlateau(5, 5));
    }
}
