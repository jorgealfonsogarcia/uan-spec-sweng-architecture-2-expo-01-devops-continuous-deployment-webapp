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
import co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality;
import co.edu.uan.sweng.architecture.devops.cd.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

import static java.util.Comparator.comparing;
import static java.util.Objects.requireNonNullElse;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;

@Controller
@RequestMapping("/")
public class IndexController {

    public static final String INDEX_VIEW = "index";
    private final CustomerService customerService;

    @Autowired
    public IndexController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String index(Model model) {
        fillDefault(model);
        return INDEX_VIEW;
    }

    @PostMapping
    public String processForm(@ModelAttribute CustomerRequestDTO customer, Model model) {
        final var numOfCustomers = requireNonNullElse(customer.getNumOfCustomers(), INTEGER_ONE);
        final var nationality = requireNonNullElse(customer.getNationality(), Nationality.US);

        final var newCustomers = customerService.generateAndSave(numOfCustomers, nationality);

        final var customers = customerService.findAll();
        customers.sort(comparing(Customer::getId));

        model.addAttribute("newCustomers", newCustomers);
        model.addAttribute("customers", customers);

        fillDefault(model);

        return INDEX_VIEW;
    }

    private void fillDefault(final Model model) {
        model.addAttribute("nationalities", Arrays.stream(Nationality.values()).sorted().toList());
    }
}
