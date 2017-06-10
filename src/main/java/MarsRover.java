import java.util.HashMap;
import java.util.Map;

public class MarsRover {

    private MarsPlateau plateau;
    private RoverPosition roverPosition;

    public MarsRover(MarsPlateau plateau) {
        this.plateau = plateau;

    }

    public void setRoverPosition(RoverPosition roverPosition) {
        if (plateau.isRoverPositionValid(roverPosition)) {
            this.roverPosition = roverPosition;
        }
    }

    public void executeCommand(String command) {

        Map<Character, RoverCommand> roverCommands = new HashMap<Character, RoverCommand>();
        roverCommands.put('L', new TurnLeft());
        roverCommands.put('R', new TurnRight());
        roverCommands.put('M', new Move());

        for (int index = 0; index < command.length(); index++) {
            char currentCommand = command.charAt(index);
            RoverCommand commandToBeExecuted = roverCommands.get(currentCommand);
            RoverPosition position = commandToBeExecuted.getNewPosition(roverPosition);
            setRoverPosition(position);
        }

    }

    public String getCurrentDirection() {
        return roverPosition.getRoverDirection();
    }

    public String getRoverPosition() {
        return String.format(roverPosition.getxCoordinate() + " " + roverPosition.getyCoordinate() + " " + roverPosition.getRoverDirection());
    }
}

