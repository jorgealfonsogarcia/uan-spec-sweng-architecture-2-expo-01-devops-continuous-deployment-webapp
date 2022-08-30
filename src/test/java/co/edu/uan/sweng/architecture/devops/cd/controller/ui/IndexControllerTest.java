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

/**
 * Unit test for {@link IndexController}.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
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
        when(customerService.generateAndSave(INTEGER_ONE, US))
                .thenReturn(new ArrayList<>(Arrays.stream(read("response/customer-new.json", Customer[].class))
                        .toList()));
        when(customerService.findAll())
                .thenReturn(new ArrayList<>(Arrays.stream(read("response/customer-all.json", Customer[].class))
                        .toList()));

        when(model.addAttribute(eq("newCustomers"), anyList())).thenReturn(model);
        when(model.addAttribute(eq("customers"), anyList())).thenReturn(model);

        assertEquals("index", indexController.processForm(new CustomerRequestDTO(INTEGER_ONE, US), model));

        verify(customerService).generateAndSave(INTEGER_ONE, US);
        verify(customerService).findAll();

        verify(model).addAttribute(eq("newCustomers"), anyList());
        verify(model).addAttribute(eq("customers"), anyList());
    }
}