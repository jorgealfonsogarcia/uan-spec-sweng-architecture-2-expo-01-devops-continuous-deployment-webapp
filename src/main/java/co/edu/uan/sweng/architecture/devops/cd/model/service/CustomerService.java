/*
 *     uan-spec-sweng-architecture-2-expo-01-devops-continuous-deployment-webapp
 *     Copyright (C) 2022  Garcia, J; Poveda, D; UAN
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package co.edu.uan.sweng.architecture.devops.cd.model.service;

import co.edu.uan.sweng.architecture.devops.cd.model.dto.randomusers.Result;
import co.edu.uan.sweng.architecture.devops.cd.model.entity.Customer;
import co.edu.uan.sweng.architecture.devops.cd.model.entity.CustomerBuilder;
import co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality;
import co.edu.uan.sweng.architecture.devops.cd.persistence.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Business service for {@link Customer}.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
@Service
@Slf4j
public class CustomerService {

    private static final String ADDRESS_FORMAT = "%d %s";

    private final CustomerRepository customerRepository;
    private final RandomUsersService randomUsersService;

    /**
     * Constructor.
     *
     * @param customerRepository the repository for {@link Customer}.
     * @param randomUsersService the RandomUsers' service.
     */
    @Autowired
    public CustomerService(CustomerRepository customerRepository, RandomUsersService randomUsersService) {
        this.customerRepository = customerRepository;
        this.randomUsersService = randomUsersService;
    }

    /**
     * Finds all the customers.
     *
     * @return a list containing all customers..
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * Saves the customer.
     *
     * @param customer the customer.
     * @return the saved customer.
     */
    public Customer save(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    /**
     * Finds a customer by its id.
     *
     * @param id the customer's id.
     * @return the customer.
     */
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * Deletes a customer by its id.
     *
     * @param id the customer's id.
     */
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    /**
     * Generates a new set of customers and saves them.
     *
     * @param numOfCustomers the number of new customers to generate.
     * @param nationality    the nationality of the new customers.
     * @return a list containing the new generated customers.
     */
    public List<Customer> generateAndSave(final Integer numOfCustomers, final Nationality nationality) {
        return randomUsersService.getUsers(numOfCustomers, nationality).getResults()
                .stream().map(this::map).map(this::save).toList();
    }

    private Customer map(final Result result) {
        final var location = result.getLocation();
        final var street = location.getStreet();
        final var name = result.getName();

        return new CustomerBuilder()
                .email(result.getEmail())
                .firstName(name.getFirst())
                .lastName(name.getLast())
                .address(ADDRESS_FORMAT.formatted(street.getNumber(), street.getName()))
                .cellphoneNumber(result.getCell())
                .city(location.getCity())
                .state(location.getState())
                .countryName(location.getCountry())
                .countryAlpha2Code(result.getNat())
                .build();
    }
}
