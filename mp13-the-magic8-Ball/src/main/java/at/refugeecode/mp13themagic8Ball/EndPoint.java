package at.refugeecode.mp13themagic8Ball;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class EndPoint {

    private List<String> weisheits=new ArrayList<>();

    @GetMapping("/tipps")
    String getTips(Model model){

        weisheits.add("some thing ");
        weisheits.add("one day ");
        weisheits.add("after that");
        weisheits.add("what is ");
        Collections.shuffle(weisheits);
        String s = weisheits.get(0);

        model.addAttribute("tippe",s);
        return "tipps";
    }

}
