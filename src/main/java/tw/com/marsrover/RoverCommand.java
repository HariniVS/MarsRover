package tw.com.marsrover;

public interface RoverCommand {
    RoverPosition getNewPosition(RoverPosition roverPosition);
}
