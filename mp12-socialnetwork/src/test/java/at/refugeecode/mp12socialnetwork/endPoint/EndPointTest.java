package at.refugeecode.mp12socialnetwork.endPoint;

import at.refugeecode.mp12socialnetwork.model.Person;
import at.refugeecode.mp12socialnetwork.model.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class EndPointTest {


    @LocalServerPort
    private int port;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TestRestTemplate restTemplate;



    @SpyBean
    private EndPoint endPoint;

    private String endpointstring = "/persons";

    private String url;


    @BeforeEach
    void before(){
        url = "http://localhost:" + port + endpointstring;
    }

    @Test
    void postPerson(){

        Person person1 = new Person();
        person1.setname("Hadi");
        List<Person> people = new ArrayList<>();
        people.add(person1);

        ResponseEntity<Person> personResponseEntity = restTemplate.postForEntity(url, person1, Person.class);

        List<Person> all = personRepository.findAll();

        assertEquals(person1.getName().toString() , all.get(0).getName());
        verify(endPoint).postPerson(any(Person.class));

    }


    @Test
    void getAll() {
        personRepository.deleteAll();
        List<Person> all = new ArrayList<>();

        assertEquals(0,all.size());

        Person person = new Person();
        person.setname("Mohamed");
        personRepository.save(person);
        all=personRepository.findAll();
        assertEquals(1,all.size());
    }

    @Test
    void addfriend() {

        Person person1 = new Person();
        person1.setname("Mohamed");
        List<Person> people = new ArrayList<>();
        ResponseEntity<Person> personResponseEntity = restTemplate.postForEntity(url, person1, Person.class);



        Person person2 = new Person();
        person2.setname("Sami");
        personResponseEntity = restTemplate.postForEntity(url, person2, Person.class);


        Person person3 = new Person();
        person2.setname("Stefan");
        personResponseEntity = restTemplate.postForEntity(url, person3, Person.class);




 //       assertEquals(person1.getName().toString() , all.get(0).getName());
  //      verify(endPoint).postPerson(any(Person.class));

    }

    @Test
    void unfriend() {
    }
}