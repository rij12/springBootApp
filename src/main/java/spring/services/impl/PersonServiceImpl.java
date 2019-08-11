package spring.services.impl;

import spring.models.Person;
import spring.models.Repository.PersonRepository;
import spring.services.PersonService;

public class PersonServiceImpl {

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository ){
        this.personRepository = personRepository;
    }

    public Person save(Person person){
        System.out.println(person);
        personRepository.save(person);
        return person;
    }


}
