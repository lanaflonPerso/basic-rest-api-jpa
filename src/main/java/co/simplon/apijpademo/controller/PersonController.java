package co.simplon.apijpademo.controller;

import co.simplon.apijpademo.model.Person;
import co.simplon.apijpademo.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/random")
    public ResponseEntity<Person> test() {
        Random random = new Random();
        long randomId = random.nextInt((int) personRepository.count() - 1) + 1;

        Optional<Person> person = personRepository.findById(randomId);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        }

        return ResponseEntity.notFound().build();
    }
}
