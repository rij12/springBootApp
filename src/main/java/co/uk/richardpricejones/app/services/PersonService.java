package co.uk.richardpricejones.app.services;

import co.uk.richardpricejones.app.Repository.PersonRepository;
import co.uk.richardpricejones.app.resources.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService extends PersonRepository {

    public Person save(Person person);

    public List<Person> findByName(String name);

    public List<Person> findAll();

    public Optional<Person> findById();

}
