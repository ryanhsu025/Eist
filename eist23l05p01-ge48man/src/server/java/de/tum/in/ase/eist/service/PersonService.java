package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
  	// do not change this
    private final List<Person> persons;

    public PersonService() {
        this.persons = new ArrayList<>();
    }

    public Person savePerson(Person person) {
        var optionalPerson = persons.stream().filter(existingPerson -> existingPerson.getId().equals(person.getId())).findFirst();
        if (optionalPerson.isEmpty()) {
            person.setId(UUID.randomUUID());
            persons.add(person);
            return person;
        } else {
            var existingPerson = optionalPerson.get();
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setBirthday(person.getBirthday());
            return existingPerson;
        }
    }

    public void deletePerson(UUID personId) {
        this.persons.removeIf(person -> person.getId().equals(personId));
    }

    public List<Person> getAllPersons(PersonSortingOptions sortingOptions) {
        List<Person> out=new ArrayList<>(persons);
        if(out.size()<=1){
            return out;
        }
        if(sortingOptions.getSortField()== PersonSortingOptions.SortField.ID){
            if(sortingOptions.getSortingOrder()==PersonSortingOptions.SortingOrder.ASCENDING){
                out.sort(Comparator.comparing(Person::getId));
                return out;
            }else {
                out.sort(Comparator.comparing(Person::getId).reversed());
                return out;
            }
        }else if(sortingOptions.getSortField()==PersonSortingOptions.SortField.FIRST_NAME){
            if(sortingOptions.getSortingOrder()==PersonSortingOptions.SortingOrder.ASCENDING){
                out.sort(Comparator.comparing(Person::getFirstName));
                return out;
            }else {
                out.sort(Comparator.comparing(Person::getFirstName).reversed());
                return out;
            }
        }else if(sortingOptions.getSortField()==PersonSortingOptions.SortField.LAST_NAME){
            if(sortingOptions.getSortingOrder()==PersonSortingOptions.SortingOrder.ASCENDING){
                out.sort(Comparator.comparing(Person::getLastName));
                return out;
            }else {
                out.sort(Comparator.comparing(Person::getLastName).reversed());
                return out;
            }
        }else if(sortingOptions.getSortField()==PersonSortingOptions.SortField.BIRTHDAY){
            if(sortingOptions.getSortingOrder()==PersonSortingOptions.SortingOrder.ASCENDING){
                out.sort(Comparator.comparing(Person::getBirthday));
                return out;
            }else {
                out.sort(Comparator.comparing(Person::getBirthday).reversed());
                return out;
            }
        }else {
            return out;
        }
    }
}
