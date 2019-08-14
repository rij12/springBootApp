package spring.services.impl;

import org.springframework.stereotype.Service;
import spring.models.Person;
import spring.models.Repository.PersonRepository;

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

    public Person findByName(String name){
        System.out.println("Search Term:" + name);
        Person p =  personRepository.findByname(name);
        return p;
    }




}
