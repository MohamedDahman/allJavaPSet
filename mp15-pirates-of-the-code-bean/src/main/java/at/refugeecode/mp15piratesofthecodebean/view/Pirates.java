package at.refugeecode.mp15piratesofthecodebean.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Pirates {


    private boolean mermaid = true;
    private boolean tear = false;
    private boolean chalice = false;
    private boolean drink  = false;
    private String value="";


    @GetMapping("/home")
    String page(){
        return  "home";
    }


    @ModelAttribute("mermaid")
    Boolean mermaid(){
        return  mermaid;
    }
    @ModelAttribute("tear")
    Boolean tear(){
        return  tear;
    }

    @ModelAttribute("chalice")
    Boolean chalice(){
        return  chalice;
    }


    @ModelAttribute("drink")
    Boolean drink(){
        return  drink;
    }

    @ModelAttribute("value")
    String getvalue(){
        return  value;
    }


    @PostMapping("/home")
    String getMermaid(@RequestBody String btn1,@RequestBody String btn2,@RequestBody String btn3,@RequestBody String btn4){
        if (btn1.equalsIgnoreCase("btn1=one")) {
            mermaid = false;
            tear = true;
        }
        if (btn2.equalsIgnoreCase("btn2=two")){
            tear = false;
            chalice= true;
        }
        if (btn3.equalsIgnoreCase("btn3=three")){
            chalice = false ;
            drink= true;
        }
        if (btn4.equalsIgnoreCase("btn4=four")){
            value="You are lacky";
            drink = false;
            mermaid = true;
        }



        return  "redirect:home";
    }



}
