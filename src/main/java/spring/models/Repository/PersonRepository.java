package spring.models.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import spring.models.Person;

import java.util.List;
import java.util.Optional;


@Component
public interface PersonRepository extends MongoRepository<Person, String> {
    
    public List<Person> findByName(String name);

    public Optional<Person> findById(String id);

    public List<Person> findAll();

}
