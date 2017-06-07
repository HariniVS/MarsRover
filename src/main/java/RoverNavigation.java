import java.util.ArrayList;
import java.util.Arrays;

class RoverNavigation {

    ArrayList<String> direction = new ArrayList<String>(Arrays.asList("N", "E", "S", "W"));

    private String roverDirection;
    private String directionToBeSet;

    public String shiftRoverDirection(char currentCommand, String roverDirection) {

        this.roverDirection = roverDirection;

        if (currentCommand == 'L') {
            rotateLeftByNinetyDegree();
        }

        return directionToBeSet;
    }

    private void rotateLeftByNinetyDegree() {
        int currentIndex = direction.indexOf(roverDirection);
        directionToBeSet = direction.get((currentIndex + direction.size() - 1) % 4);
    }
}
