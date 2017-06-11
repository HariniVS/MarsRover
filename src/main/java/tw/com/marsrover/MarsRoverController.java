package tw.com.marsrover;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MarsRoverController {

    String roverPosition;

    @RequestMapping(value = "/getUserInput", method = RequestMethod.POST)
    public ResponseEntity<?> getRoverInput(@RequestBody RoverInputHandler roverInput) {
        roverPosition = getCurrentPosition(roverInput);
        return new ResponseEntity(roverPosition, HttpStatus.OK);
    }

    @RequestMapping("/displayOutput")
    public String index() {
        return roverPosition;
    }

    public String getCurrentPosition(RoverInputHandler roverInput) {
        String coOrdinates[] = roverInput.getRoverCoOrdinates().split(" ");
        MarsPlateau plateau = new MarsPlateau(Integer.parseInt(coOrdinates[0]), Integer.parseInt(coOrdinates[1]));
        MarsRover marsRover = new MarsRover(plateau);
        String roverPosition[] = roverInput.getRoverPosition().split(" ");
        RoverPosition position = new RoverPosition(Integer.parseInt(roverPosition[0]), Integer.parseInt(roverPosition[1]), roverPosition[2]);
        marsRover.setRoverPosition(position);
        marsRover.executeCommand(roverInput.getCommand());
        return marsRover.getRoverPosition();
    }
}

