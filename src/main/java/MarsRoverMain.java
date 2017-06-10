import java.util.Scanner;

public class MarsRoverMain {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        MarsPlateau plateau = new MarsPlateau(scannerObject.nextInt(), scannerObject.nextInt());
        MarsRover marsRover = new MarsRover(plateau);
        RoverPosition roverPosition;
        while (scannerObject.hasNext()) {
            roverPosition = new RoverPosition(scannerObject.nextInt(), scannerObject.nextInt(), scannerObject.next());
            marsRover.setRoverPosition(roverPosition);
            marsRover.executeCommand(scannerObject.next());
            System.out.println(marsRover.getRoverPosition());
        }
    }
}
