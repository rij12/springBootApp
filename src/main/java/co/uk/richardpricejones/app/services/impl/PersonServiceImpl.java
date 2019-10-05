package co.uk.richardpricejones.app.services.impl;

import co.uk.richardpricejones.app.exceptions.PersonNotFoundException;
import co.uk.richardpricejones.app.repository.PersonRepository;
import co.uk.richardpricejones.app.resources.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonServiceImpl {

    private PersonRepository personRepository;

    private static final Logger LOGGER = Logger.getLogger(PersonServiceImpl.class.getName());

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
        LOGGER.info("PersonRepository created!");
    }

    public Person save(Person person){
        Person p = personRepository.save(person);
        LOGGER.info("Person save to database" + p.toString());
        return person;
    }

    public List<Person> findByName(String name){
        LOGGER.info("Search Term:" + name);
        List<Person> p =  personRepository.findByName(name);
        return p;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(String id) throws PersonNotFoundException {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new PersonNotFoundException("Person Not Found!");
        }

    }
}
