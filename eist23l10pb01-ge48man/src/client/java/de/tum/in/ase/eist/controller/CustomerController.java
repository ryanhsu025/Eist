package de.tum.in.ase.eist.controller;

import de.tum.in.ase.eist.model.Customer;
import de.tum.in.ase.eist.util.CustomerSortingOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CustomerController {
    private final WebClient webClient;
    private final List<Customer> customers;

    public CustomerController() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.customers = new ArrayList<>();
    }

    public void getAllPersons(CustomerSortingOptions sortingOptions, Consumer<List<Customer>> customerConsumer) {
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("customers")
                        .queryParam("sortField", sortingOptions.getSortField())
                        .queryParam("sortingOrder", sortingOptions.getSortingOrder())
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Customer>>() {
                })
                .onErrorStop()
                .subscribe(newPersons -> {
                    customers.clear();
                    customers.addAll(newPersons);
                    customerConsumer.accept(customers);
                });
    }

    public void addPerson(Customer customer, Consumer<List<Customer>> customerConsumer) {
        // TODO Part 2: Complete the http post request to the server
        webClient.post()
                .uri("customers")
                .bodyValue(customer)
                .retrieve()
                .bodyToMono(Customer.class)
                .onErrorStop()
                .subscribe(newCustomer -> {
                    customers.add(newCustomer);
                    customerConsumer.accept(customers);
                });
    }

    public void updatePerson(Customer customer, Consumer<List<Customer>> customerConsumer) {
        // TODO Part 2: Complete the http put request to the server
        webClient.put()
                .uri("customers/" + customer.getId())
                .bodyValue(customer)
                .retrieve()
                .bodyToMono(Customer.class)
                .onErrorStop()
                .subscribe(newCustomer -> {
                    customers.replaceAll(oldCustomer -> oldCustomer.getId().equals(newCustomer.getId()) ? newCustomer : oldCustomer);
                    customerConsumer.accept(customers);
                });
    }

    public void deletePerson(Customer customer, Consumer<List<Customer>> customerConsumer) {
        // TODO Part 2: Make an http delete request to the server
        webClient.delete()
                .uri("customers/" + customer.getId())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(v -> {
                    customers.remove(customer);
                    customerConsumer.accept(customers);
                });
    }

}
