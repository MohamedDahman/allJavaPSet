package at.refugeecode.mp16MyPersonalToDoListUI.view;

import at.refugeecode.mp16MyPersonalToDoListUI.model.ToDo;
import at.refugeecode.mp16MyPersonalToDoListUI.reposirotry.ApplicantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todos")
public class EndPoint {

    private ApplicantRepository applicantRepository;


    public EndPoint(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
      //  applicantRepository.deleteAll();
       }

    @GetMapping
    String page(){
        return "todos";
    }


    @ModelAttribute("allToDo")
    List<ToDo> findAll(){
        return  applicantRepository.findAll();
    }

    @ModelAttribute("newToDo")
    ToDo newToDo() {
        return new ToDo();
    }

    /*@PostMapping
    String post(ToDo toDo) {
        applicantRepository.save(toDo);
        return "redirect:todos";
    }
    */

    @PostMapping
    String post(@RequestBody ToDo toDo) {
        System.out.println("now we are in Post Method");
        System.out.println(toDo.getDescription());
        applicantRepository.save(toDo);
        return "redirect:todos";
    }


/*
    @PostMapping
    ToDo save(@RequestBody ToDo toDo) {
        return applicantRepository.save(toDo);
    }
*/



    @PutMapping
    String  save(@RequestParam String id1) {
        Optional<ToDo> byId = applicantRepository.findById(id1);
        if (byId.isPresent()) {
            byId.get().setDone(true);
            applicantRepository.save(byId.get());
        }
        return "redirect:todos";
    }
/*

    @PutMapping
    String  edit(@PathVariable String id) {
        System.out.println(id);
        Optional<ToDo> byId = applicantRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setDone(true);
            applicantRepository.save(byId.get());
        }
        return "redirect/:"+page();
    }
*/

}
