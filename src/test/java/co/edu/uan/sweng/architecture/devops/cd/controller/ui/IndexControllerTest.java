package co.edu.uan.sweng.architecture.devops.cd.controller.ui;

import co.edu.uan.sweng.architecture.devops.cd.model.dto.CustomerRequestDTO;
import co.edu.uan.sweng.architecture.devops.cd.model.entity.Customer;
import co.edu.uan.sweng.architecture.devops.cd.model.service.CustomerService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;

import static co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality.US;
import static co.edu.uan.sweng.architecture.devops.cd.test.util.JsonResourcesReader.read;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class IndexControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private Model model;

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController(customerService);

        when(model.addAttribute(eq("nationalities"), any())).thenReturn(model);
    }

    @AfterEach
    void tearDown() {
        verify(model).addAttribute(eq("nationalities"), any());
    }

    @Test
    void index() {
        assertEquals("index", indexController.index(model));
    }

    @Test
    @SneakyThrows
    void processForm() {
        when(customerService.generateAndSave(eq(INTEGER_ONE), eq(US)))
                .thenReturn(new ArrayList<>(Arrays.stream(read("response/customer-new.json", Customer[].class))
                        .toList()));
        when(customerService.findAll())
                .thenReturn(new ArrayList<>(Arrays.stream(read("response/customer-all.json", Customer[].class))
                        .toList()));

        when(model.addAttribute(eq("newCustomers"), anyList())).thenReturn(model);
        when(model.addAttribute(eq("customers"), anyList())).thenReturn(model);

        assertEquals("index", indexController.processForm(new CustomerRequestDTO(INTEGER_ONE, US), model));

        verify(customerService).generateAndSave(eq(INTEGER_ONE), eq(US));
        verify(customerService).findAll();

        verify(model).addAttribute(eq("newCustomers"), anyList());
        verify(model).addAttribute(eq("customers"), anyList());
    }
}