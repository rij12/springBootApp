package spring.services;

import spring.models.Person;
import spring.models.Repository.PersonRepository;

import java.util.List;
import java.util.Optional;

public interface PersonService extends PersonRepository {

    public Person save(Person person);

    public List<Person> findByName(String name);

    public List<Person> findAll();

    public Optional<Person> findById();

}
