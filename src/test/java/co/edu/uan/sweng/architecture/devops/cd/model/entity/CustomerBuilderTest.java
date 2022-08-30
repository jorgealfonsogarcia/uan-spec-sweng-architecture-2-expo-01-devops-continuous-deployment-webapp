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

package co.edu.uan.sweng.architecture.devops.cd.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link CustomerBuilder}.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
class CustomerBuilderTest {

    private CustomerBuilder customerBuilder;

    @BeforeEach
    void setUp() {
        customerBuilder = new CustomerBuilder();
    }

    @Test
    void build() {
        final var email = "john.doe@example.com";
        final var firstName = "John";
        final var lastName = "Doe";
        final var address = "1234 Main St";
        final var cellphoneNumber = "(555) 555-5555";
        final var city = "Frisco";
        final var state = "Ohio";
        final var country = "United States";

        final var result = customerBuilder
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .cellphoneNumber(cellphoneNumber)
                .city(city)
                .state(state)
                .country(country)
                .build();

        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals(firstName, result.getFirstName());
        assertEquals(lastName, result.getLastName());
        assertEquals(address, result.getAddress());
        assertEquals(cellphoneNumber, result.getCellphoneNumber());
        assertEquals(city, result.getCity());
        assertEquals(state, result.getState());
        assertEquals(country, result.getCountry());
    }
}