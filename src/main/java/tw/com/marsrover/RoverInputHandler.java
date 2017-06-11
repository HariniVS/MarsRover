package tw.com.marsrover;

public class RoverInputHandler {

    private String roverCoOrdinates;

    private String roverPosition;

    public String getRoverPosition() {
        return roverPosition;
    }

    public String getCommand() {
        return command;
    }

    private String command;

    public void setPosition(String roverPosition) {
        this.roverPosition = roverPosition;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getRoverCoOrdinates() {
        return roverCoOrdinates;
    }

    public void setRoverCoOrdinates(String roverCoOrdinates) {
        this.roverCoOrdinates = roverCoOrdinates;
    }
}
