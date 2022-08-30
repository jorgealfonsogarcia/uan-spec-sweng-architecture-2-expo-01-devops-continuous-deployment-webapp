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

package co.edu.uan.sweng.architecture.devops.cd.persistence.rest;

import co.edu.uan.sweng.architecture.devops.cd.model.dto.randomusers.RandomUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * REST API client for RandomUsers.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
public interface RandomUsersRestClient {

    /**
     * Gets the requested RandomUsers.
     *
     * @param results        the number of results.
     * @param nationality    the nationality of the users.
     * @param includedFields the list of the included fields for each user.
     * @return the call response for the RandomUsers result.
     */
    @GET("api")
    Call<RandomUser> getUsers(@Query("results") Integer results, @Query("nat") String nationality,
                              @Query(value = "inc") String includedFields);

    /**
     * Gets the requested RandomUsers, with the fields: name,location,email,cell.
     *
     * @param results     the number of results.
     * @param nationality the nationality of the users.
     * @return the call response for the RandomUsers result.
     */
    default Call<RandomUser> getUsers(final Integer results, final String nationality) {
        return getUsers(results, nationality, "name,location,email,cell");
    }
}
