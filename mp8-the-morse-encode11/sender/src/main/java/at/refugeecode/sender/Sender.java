package at.refugeecode.sender;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sender")
public class Sender {

    private String mesage;

    @GetMapping("/{themessage}")
        String sendMessage(@PathVariable String themessage){
        mesage = themessage;
        RestTemplate restTemplate = new RestTemplate();
        String collector="";
        for (String x:mesage.split("")) {
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8083/encoder/", x, String.class);
            ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8083/encoder/", String.class);
            collector=collector+"--------"+forEntity.getBody();
        }

        return collector;
    }

}
