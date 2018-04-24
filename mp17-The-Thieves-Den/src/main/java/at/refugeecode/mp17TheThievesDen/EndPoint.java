package at.refugeecode.mp17TheThievesDen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EndPoint {

    @GetMapping
    String message(){
        return  "you open the Cave";
    }

}
