package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.Customer;
import de.tum.in.ase.eist.util.CustomerSortingOptions;
import org.springframework.stereotype.Service;

import java.util.*;

import static de.tum.in.ase.eist.util.CustomerSortingOptions.SortingOrder.ASCENDING;

@Service
public class CustomerService {
  	// do not change this
    private final List<Customer> customers;

    public CustomerService() {
        this.customers = new ArrayList<>();
    }

    public Customer savePerson(Customer customer) {
        var optionalPerson = customers.stream().filter(existingCustomer -> existingCustomer.getId().equals(customer.getId())).findFirst();
        if (optionalPerson.isEmpty()) {
            customer.setId(UUID.randomUUID());
            customers.add(customer);
            return customer;
        } else {
            var existingPerson = optionalPerson.get();
            existingPerson.setFirstName(customer.getFirstName());
            existingPerson.setLastName(customer.getLastName());
            existingPerson.setBirthday(customer.getBirthday());
            return existingPerson;
        }
    }

    public void deletePerson(UUID personId) {
        this.customers.removeIf(customer -> customer.getId().equals(personId));
    }

    public List<Customer> getAllPersons(CustomerSortingOptions sortingOptions) {
        if (sortingOptions == null) {
            return new ArrayList<>(this.customers);
        }
        var sortedList = new ArrayList<>(this.customers);
        sortedList.sort((p1, p2) -> {
            Customer customer1;
            Customer customer2;
            if (sortingOptions.getSortingOrder() == ASCENDING) {
                customer1 = p1;
                customer2 = p2;
            } else {
                customer1 = p2;
                customer2 = p1;
            }

            return switch (sortingOptions.getSortField()) {
                case ID -> customer1.getId().compareTo(customer2.getId());
                case FIRST_NAME -> customer1.getFirstName().compareTo(customer2.getFirstName());
                case LAST_NAME -> customer1.getLastName().compareTo(customer2.getLastName());
                case BIRTHDAY -> customer1.getBirthday().compareTo(customer2.getBirthday());
            };
        });
        return sortedList;
    }
}
