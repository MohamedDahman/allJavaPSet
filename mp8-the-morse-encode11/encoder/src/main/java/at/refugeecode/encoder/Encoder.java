package at.refugeecode.encoder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encoder")
public class Encoder {
    String theMessage;

    @GetMapping
    String sendchar(){
        return theMessage;
    }


    @PostMapping
    String Encode(@RequestBody String message){
        theMessage=message;
        //should write mores Algorithem
        return "This is your Message"+message;
    }
}
