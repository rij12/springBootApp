package spring.api;


import org.springframework.web.bind.annotation.*;
import spring.models.Person;
import spring.services.impl.PersonServiceImpl;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class PersonController {

    private PersonServiceImpl personService;
    private static final Logger LOGGER = Logger.getLogger( PersonController.class.getName() );

    public PersonController(PersonServiceImpl personService){
        this.personService = personService;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person p){

        System.out.println(p.toString());
        // Save to the DB
        personService.save(p);
        return p;
    }

    @RequestMapping(value = "/person/find", method = RequestMethod.POST)
    public List<Person> getPerson(@RequestBody String name){
        System.out.println("Name Requested: " + name);

        // Load from DB
        List<Person> foundPerson = personService.findByName(name);
        System.out.println("Person Found: " + foundPerson);
        return foundPerson;
    }

    @RequestMapping(value = "/person/findall", method = RequestMethod.GET)
    public List<Person> getAllPerson(){
        List<Person> people = personService.findAll();
        System.out.println(people);
        return people;
    }

    @RequestMapping(value = {"/person/find/{id}"}, method = RequestMethod.GET)
    public Person getPersonById(@PathVariable String id){
        LOGGER.info("Person Request id" + id);
        Person p = personService.findById(id);
        return p;
    }
}
