import java.util.ArrayList;
import java.util.Arrays;

class RoverNavigation {

    ArrayList<String> direction = new ArrayList<String>(Arrays.asList("N", "E", "S", "W"));

    private String directionToBeSet;
    private int currentIndex;
    private int newYCoordinate;
    private int newXCoordinate;

    public String shiftRoverDirection(char currentCommand, String roverDirection) {

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

     public RoverCoordinates moveForwardInCurrentDirection(RoverCoordinates roverCoordinates,String
             roverDirection) {

        newXCoordinate = roverCoordinates.getxCoordinate();
        newYCoordinate = roverCoordinates.getyCoordinate();

         if (roverDirection.equals("N")) {
             newYCoordinate += 1;
         }
         if (roverDirection.equals("E")) {
             newXCoordinate += 1;
         }
         if (roverDirection.equals("S")) {
             newYCoordinate -= 1;
         }
         if (roverDirection.equals("W")) {
             newXCoordinate -= 1;
         }

        roverCoordinates = new RoverCoordinates(newXCoordinate,newYCoordinate);
        return roverCoordinates;
     }

}
