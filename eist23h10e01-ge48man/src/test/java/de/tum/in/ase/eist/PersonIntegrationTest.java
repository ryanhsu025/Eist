package de.tum.in.ase.eist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class PersonIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository personRepository;

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void testAddPerson() throws Exception {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        var response = this.mvc.perform(
                post("/persons")
                        .content(objectMapper.writeValueAsString(person))
                        .contentType("application/json")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(1, personRepository.findAll().size());
    }

    @Test
    void testDeletePerson() throws Exception {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        person = personRepository.save(person);

        var response = this.mvc.perform(
                delete("/persons/" + person.getId())
                        .contentType("application/json")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
        assertTrue(personRepository.findAll().isEmpty());
    }

    @Test
    void testAddParent() throws Exception {
        var person = new Person();
        person.setFirstName("Junguo");
        person.setLastName("Xu");
        person.setBirthday(LocalDate.now());
        person.setId(1l);
        personRepository.save(person);

        var parent1 = new Person();
        parent1.setFirstName("Parent1");
        parent1.setLastName("Xu");
        parent1.setBirthday(LocalDate.now());
        personRepository.save(parent1);

        var response = this.mvc.perform(
                put("/api/persons/" + person.getId() + "/parents")
                        .content(objectMapper.writeValueAsString(parent1))
                        .contentType("application/json")
        ).andReturn().getResponse();

        assertEquals(2, personRepository.findAll().size());

    }

    @Test
    void testAddThreeParents() throws Exception {
        var person = new Person();
        person.setFirstName("Junguo");
        person.setLastName("Xu");
        person.setBirthday(LocalDate.now());
        person.setId(1l);
        personRepository.save(person);

        var parent1 = new Person();
        parent1.setFirstName("Parent1");
        parent1.setLastName("Xu");
        parent1.setBirthday(LocalDate.now());
        person.setId(2l);
        personRepository.save(parent1);

        var parent2 = new Person();
        parent2.setFirstName("Parent2");
        parent2.setLastName("Xu");
        parent2.setBirthday(LocalDate.now());
        person.setId(3l);
        personRepository.save(parent2);



        var parent3 = new Person();
        parent3.setFirstName("Parent3");
        parent3.setLastName("Xu");
        parent3.setBirthday(LocalDate.now());
        person.setId(4l);
        personRepository.save(parent3);

        assertEquals(4,personRepository.findAll().size());
        var response1 = this.mvc.perform(
                put("/persons/" + person.getId() + "/parents")
                        .content(objectMapper.writeValueAsString(parent1))
                        .contentType("application/json")
        ).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(),response1.getStatus());

        var response2 = this.mvc.perform(
                put("/persons/" + person.getId() + "/parents")
                        .content(objectMapper.writeValueAsString(parent2))
                        .contentType("application/json")
        ).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(),response2.getStatus());

        try {
            var response3 = this.mvc.perform(
                    put("/persons/" + person.getId() + "/parents")
                            .content(objectMapper.writeValueAsString(parent3))
                            .contentType("application/json")
            ).andReturn().getResponse();
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }

    }
}
