package de.tum.in.ase.eist.rest;

import de.tum.in.ase.eist.model.Customer;
import de.tum.in.ase.eist.service.CustomerService;
import de.tum.in.ase.eist.util.CustomerSortingOptions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(value = "sortField", defaultValue = "ID") CustomerSortingOptions.SortField sortField,
                                                          @RequestParam(value = "sortingOrder", defaultValue = "ASCENDING") CustomerSortingOptions.SortingOrder sortingOrder) {
        return ResponseEntity.ok(customerService.getAllPersons(new CustomerSortingOptions(sortingOrder, sortField)));
    }

    // TODO Part 1: Implement the specified endpoints here

    @PostMapping("customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        if (customer.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.savePerson(customer));
    }

    @PutMapping("customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer updatedCustomer, @PathVariable("customerId") UUID customerId) {
        if (!updatedCustomer.getId().equals(customerId)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.savePerson(updatedCustomer));
    }

    @DeleteMapping("customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deletePerson(customerId);
        return ResponseEntity.noContent().build();
    }

}
