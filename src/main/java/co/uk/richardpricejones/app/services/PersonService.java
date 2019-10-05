package co.uk.richardpricejones.app.services;

import co.uk.richardpricejones.app.repository.PersonRepository;
import co.uk.richardpricejones.app.resources.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService extends PersonRepository {

    Person save(Person person);

    List<Person> findByName(String name);

    List<Person> findAll();

    Optional<Person> findById();

}
