package at.refugeecode.mp16MyPersonalToDoListUI.reposirotry;

import at.refugeecode.mp16MyPersonalToDoListUI.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicantRepository extends MongoRepository<ToDo,String>{

    Optional<ToDo> findById(String id);
    void deleteById(String id);


}
