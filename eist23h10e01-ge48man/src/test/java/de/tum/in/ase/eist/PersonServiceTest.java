package de.tum.in.ase.eist;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.repository.PersonRepository;
import de.tum.in.ase.eist.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void testAddPerson() {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        personService.save(person);

        assertEquals(1, personRepository.findAll().size());
    }

    @Test
    void testDeletePerson() {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        person = personRepository.save(person);

        personService.delete(person);

        assertTrue(personRepository.findAll().isEmpty());
    }
    @Test()
    void testAddParent(){
        var person = new Person();
        person.setFirstName("Junguo");
        person.setLastName("Xu");
        person.setBirthday(LocalDate.now());;
        personRepository.save(person);

        var parent1=new Person();
        parent1.setFirstName("Parent1");
        parent1.setLastName("Xu");
        parent1.setBirthday(LocalDate.now());
        personRepository.save(parent1);

        personService.addParent(person,parent1);

        assertEquals(2, personRepository.findAll().size());

    }

    @Test
    void testAddThreeParents(){
        var person = new Person();
        person.setFirstName("Junguo");
        person.setLastName("Xu");
        person.setBirthday(LocalDate.now());
        person.setId(1l);
        personRepository.save(person);

        var parent1=new Person();
        parent1.setFirstName("Parent1");
        parent1.setLastName("Xu");
        parent1.setBirthday(LocalDate.now());
        personRepository.save(parent1);

        var parent2=new Person();
        parent2.setFirstName("Parent2");
        parent2.setLastName("Xu");
        parent2.setBirthday(LocalDate.now());
        personRepository.save(parent2);

        var parent3=new Person();
        parent3.setFirstName("Parent3");
        parent3.setLastName("Xu");
        parent3.setBirthday(LocalDate.now());
        personRepository.save(parent3);
        personService.addParent(person,parent1);
        personService.addParent(person,parent2);

        try {
            personService.addParent(person,parent3);
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.BAD_REQUEST,e.getStatusCode());
            return;
        }
        Assertions.fail();

    }
}
