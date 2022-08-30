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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Customer.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
@Entity
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 2133356295598671120L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String cellphoneNumber;
    private String city;
    private String state;
    private String country;

    /**
     * Gets the id.
     *
     * @return the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the email.
     *
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name.
     *
     * @return the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the address.
     *
     * @return the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the cell phone number.
     *
     * @return the cell phone number.
     */
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    /**
     * Sets the cell phone number.
     *
     * @param cellphoneNumber the cell phone number.
     */
    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    /**
     * Gets the city.
     *
     * @return the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return the state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the country.
     *
     * @return the country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final var customer = (Customer) o;
        return new EqualsBuilder().append(id, customer.id).append(email, customer.email)
                .append(firstName, customer.firstName).append(lastName, customer.lastName)
                .append(address, customer.address).append(cellphoneNumber, customer.cellphoneNumber)
                .append(city, customer.city).append(state, customer.state).append(country, customer.country).isEquals();
    }

    @Override
    public int hashCode() {
        final var initialOddNumber = 17;
        final var multiplierOddNumber = 37;
        return new HashCodeBuilder(initialOddNumber, multiplierOddNumber).append(id).append(email).append(firstName)
                .append(lastName).append(address).append(cellphoneNumber).append(city).append(state).append(country)
                .toHashCode();
    }
}
