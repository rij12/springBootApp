package co.uk.richardpricejones.app.repository;

import co.uk.richardpricejones.app.resources.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public interface PersonRepository extends MongoRepository<Person, String> {
    
    List<Person> findByName(String name);

    Optional<Person> findById(String id);

    List<Person> findAll();

}
