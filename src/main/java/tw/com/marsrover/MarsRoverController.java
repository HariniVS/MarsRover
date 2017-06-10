package tw.com.marsrover;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MarsRoverController {

    @RequestMapping()
    public String index() {
        return "Have a happy day..:) Hard work always pays off..Start now and never stop";
    }
}
