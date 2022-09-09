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

/**
 * Builder for {@link Customer}.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
public class CustomerBuilder {

    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String cellphoneNumber;
    private String city;
    private String state;
    private String countryName;
    private String countryAlpha2Code;

    /**
     * Sets the email.
     *
     * @param email the email.
     * @return the instance of the builder.
     */
    public CustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the first name.
     * @return the instance of the builder.
     */
    public CustomerBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name.
     * @return the instance of the builder.
     */
    public CustomerBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Sets the address.
     *
     * @param address the address.
     * @return the instance of the builder.
     */
    public CustomerBuilder address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Sets the cell phone number.
     *
     * @param cellphoneNumber the cell phone number.
     * @return the instance of the builder.
     */
    public CustomerBuilder cellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
        return this;
    }

    /**
     * Sets the city.
     *
     * @param city the city.
     * @return the instance of the builder.
     */
    public CustomerBuilder city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Sets the state.
     *
     * @param state the state.
     * @return the instance of the builder.
     */
    public CustomerBuilder state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Sets the country's name.
     *
     * @param countryName the country's name.
     * @return the instance of the builder.
     */
    public CustomerBuilder countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    /**
     * Sets the country's alpha 2 code.
     *
     * @param countryAlpha2Code the country's alpha 2 code.
     * @return the instance of the builder.
     */
    public CustomerBuilder countryAlpha2Code(String countryAlpha2Code) {
        this.countryAlpha2Code = countryAlpha2Code;
        return this;
    }

    /**
     * Builds the new {@link Customer} instance.
     *
     * @return the new {@link Customer} instance.
     */
    public Customer build() {
        final var customer = new Customer();
        customer.setEmail(email);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setCellphoneNumber(cellphoneNumber);
        customer.setCity(city);
        customer.setState(state);
        customer.setCountryName(countryName);
        customer.setCountryAlpha2Code(countryAlpha2Code);
        return customer;
    }
}