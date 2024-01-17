package ru.kompas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kompas.logic.Angle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private final List<Angle> compassAngle_1 =  new ArrayList<>();
    int i = 0;

    @PostMapping(value = "/setSideRange", consumes = "application/json")
    public void setSideRange(@RequestBody Map<String,String> ranges) {
        ranges.forEach((side,range) -> compassAngle_1.add(new Angle(side,range)));
    }

    @GetMapping(value ="/getSide", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> getSide(@RequestParam(value = "Angle") Integer angle) {
        return whatSide(angle);
    }

    private ResponseEntity<String> whatSide(int angle) {
        for (Angle compassAngle : compassAngle_1) {
            int start = compassAngle.getStart();
            int end = compassAngle.getEnd();

            if (angle >= start && angle <= end) {
                String side = compassAngle.getSide();
                return new ResponseEntity<String>("{\"Side\":\"" + side + "\"}", HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Side Erorr", HttpStatus.OK);
    }
}
