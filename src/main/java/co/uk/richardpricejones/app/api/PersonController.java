package co.uk.richardpricejones.app.api;


import co.uk.richardpricejones.app.exceptions.PersonNotFoundException;
import co.uk.richardpricejones.app.resources.Person;
import co.uk.richardpricejones.app.services.impl.PersonServiceImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class PersonController {

    private PersonServiceImpl personService;
    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName());

    public PersonController(PersonServiceImpl personService){
        this.personService = personService;
    }


    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @Secured("ROLE_USER")
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
    @Secured("ROLE_USER")
    public List<Person> getAllPerson(){
        List<Person> people = personService.findAll();
        System.out.println(people);
        return people;
    }

    // TODO Replace sending POJO's to HTTP Entities.
    @RequestMapping(value = {"/person/find/{id}"}, method = RequestMethod.GET)
    public Person getPersonById(@PathVariable String id) throws PersonNotFoundException {
        LOGGER.info("Person Request id" + id);
        return personService.findById(id);
    }
}
