package spring.models.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import spring.models.Person;

import java.util.List;


@Component
public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByname(String name);
//    public List<Person> findByName(String name, int age);

}
