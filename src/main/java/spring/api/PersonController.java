package spring.api;


import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.models.Person;
import spring.services.impl.PersonServiceImpl;

@RestController
public class PersonController {

    private PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService){
        this.personService = personService;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void createPerson(@RequestBody Person p){

        System.out.println(p.toString());
        // Save to the DB
        personService.save(p);
    }

    @RequestMapping(value = "/person/find", method = RequestMethod.POST)
    public Person getPerson(@RequestBody String name){
        System.out.println("Name Requested: " + name);

        // Load from DB
        Person foundPerson = personService.findByName(name);
        System.out.println("Person Found: " + foundPerson);
        return foundPerson;
    }

}