package spring.services;

import spring.models.Person;
import spring.models.Repository.PersonRepository;

public interface PersonService extends PersonRepository {

    public Person save(Person person);

    public Person findByname(String name);

}
