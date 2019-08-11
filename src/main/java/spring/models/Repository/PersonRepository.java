package spring.models.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.models.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByName(String name);

    public Person save();

}
