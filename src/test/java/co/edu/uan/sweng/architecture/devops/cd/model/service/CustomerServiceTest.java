package co.edu.uan.sweng.architecture.devops.cd.model.service;

import co.edu.uan.sweng.architecture.devops.cd.model.dto.randomusers.RandomUser;
import co.edu.uan.sweng.architecture.devops.cd.model.entity.Customer;
import co.edu.uan.sweng.architecture.devops.cd.persistence.repository.CustomerRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality.US;
import static co.edu.uan.sweng.architecture.devops.cd.test.util.JsonResourcesReader.read;
import static org.apache.commons.lang3.math.NumberUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private RandomUsersService randomUsersService;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository, randomUsersService);
    }

    @Test
    @SneakyThrows
    void findAll() {
        when(customerRepository.findAll())
                .thenReturn(Arrays.stream(read("response/customer-all.json", Customer[].class)).toList());

        final var response = customerService.findAll();

        assertNotNull(response);
        assertEquals(INTEGER_TWO, response.size());

        verify(customerRepository).findAll();
    }

    @Test
    @SneakyThrows
    void save() {
        final var customer = read("request/customer-simple.json", Customer.class);

        when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(customer);

        final var response = customerService.save(customer);

        assertNotNull(response);
        assertEquals(customer, response);

        verify(customerRepository).saveAndFlush(any(Customer.class));
    }

    @Test
    @SneakyThrows
    void findById() {
        final var customer = read("request/customer-simple.json", Customer.class);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        final var response = customerService.findById(LONG_ONE);

        assertNotNull(response);
        assertTrue(response.isPresent());
        assertEquals(customer, response.get());

        verify(customerRepository).findById(anyLong());
    }

    @Test
    void deleteById() {
        doNothing().when(customerRepository).deleteById(anyLong());

        customerService.deleteById(LONG_ONE);

        verify(customerRepository).deleteById(anyLong());
    }

    @Test
    @SneakyThrows
    void generateAndSave() {
        final var numOfCustomers = 3;
        final var randomUser = read("response/randomusers-all.json", RandomUser.class);

        when(randomUsersService.getUsers(eq(numOfCustomers), eq(US))).thenReturn(randomUser);
        when(customerRepository.saveAndFlush(any(Customer.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[INTEGER_ZERO]);

        final var result = customerService.generateAndSave(numOfCustomers, US);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(numOfCustomers, result.size());

        result.stream().map(customer -> randomUser.getResults().stream().anyMatch(info -> {
            final var name = info.getName();
            return name.getFirst().equals(customer.getFirstName()) && name.getLast().equals(customer.getLastName());
        })).forEach(Assertions::assertTrue);

        verify(randomUsersService).getUsers(eq(numOfCustomers), eq(US));
        verify(customerRepository, times(numOfCustomers)).saveAndFlush(any(Customer.class));
    }
}