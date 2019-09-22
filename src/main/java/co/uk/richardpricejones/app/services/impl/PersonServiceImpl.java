package co.uk.richardpricejones.app.services.impl;

import co.uk.richardpricejones.app.repository.PersonRepository;
import co.uk.richardpricejones.app.resources.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
        System.out.println("PersonRepository created!");
    }

    public Person save(Person person){
        System.out.println(person);
        Person p = personRepository.save(person);
        System.out.println("This is save to the database:" + p.toString());
        return person;
    }

    public List<Person> findByName(String name){
        System.out.println("Search Term:" + name);
        List<Person> p =  personRepository.findByName(name);
        return p;
    }

    public List<Person> findAll(){
        List<Person> people = personRepository.findAll();
        return people;
    }

    public Person findById(String id){
        System.out.println("Provided Id"+id);
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }



}
