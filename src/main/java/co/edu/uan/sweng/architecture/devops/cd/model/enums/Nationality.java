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

package co.edu.uan.sweng.architecture.devops.cd.model.enums;

/**
 * RandomUsers' nationalities.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
public enum Nationality {

    /**
     * Australia.
     */
    AU("Australia"),
    /**
     * Brazil.
     */
    BR("Brazil"),
    /**
     * Canada.
     */
    CA("Canada"),
    /**
     * Switzerland.
     */
    CH("Switzerland"),
    /**
     * Germany.
     */
    DE("Germany"),
    /**
     * Denmark.
     */
    DK("Denmark"),
    /**
     * Spain.
     */
    ES("Spain"),
    /**
     * Finland.
     */
    FI("Finland"),
    /**
     * France.
     */
    FR("France"),
    /**
     * United Kingdom.
     */
    GB("United Kingdom"),
    /**
     * Ireland.
     */
    IE("Ireland"),
    /**
     * India.
     */
    IN("India"),
    /**
     * Iran.
     */
    IR("Iran"),
    /**
     * Mexico.
     */
    MX("Mexico"),
    /**
     * Netherlands.
     */
    NL("Netherlands"),
    /**
     * Norway.
     */
    NO("Norway"),
    /**
     * New Zealand.
     */
    NZ("New Zealand"),
    /**
     * Serbia.
     */
    RS("Serbia"),
    /**
     * Turkey.
     */
    TR("Turkey"),
    /**
     * Ukraine.
     */
    UA("Ukraine"),
    /**
     * United States.
     */
    US("United States");

    private final String country;

    /**
     * Constructor.
     *
     * @param country the country's name.
     */
    Nationality(String country) {
        this.country = country;
    }

    /**
     * Gets the country's name.
     *
     * @return the country's name.
     */
    public String getCountry() {
        return country;
    }
}
