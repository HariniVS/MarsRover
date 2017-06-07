import java.util.ArrayList;
import java.util.Arrays;

class RoverNavigation {

    ArrayList<String> direction = new ArrayList<String>(Arrays.asList("N", "E", "S", "W"));

    private String roverDirection;
    private String directionToBeSet;
    private int currentIndex;

    public String shiftRoverDirection(char currentCommand, String roverDirection) {

        this.roverDirection = roverDirection;
        currentIndex = direction.indexOf(roverDirection);

        if (currentCommand == 'L') {
            rotateLeftByNinetyDegree();
        }
        if (currentCommand == 'R') {
            rotateRightByNinetyDegree();
        }
        return directionToBeSet;
    }

    private void rotateLeftByNinetyDegree() {
        directionToBeSet = direction.get((currentIndex + direction.size() - 1) % 4);
    }

    private void rotateRightByNinetyDegree() {
        directionToBeSet = direction.get((currentIndex + direction.size() + 1) % 4);
    }
}
