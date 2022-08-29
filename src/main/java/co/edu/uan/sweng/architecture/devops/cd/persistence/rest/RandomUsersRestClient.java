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

public interface RandomUsersRestClient {

    @GET("api")
    Call<RandomUser> getUsers(@Query("results") Integer results, @Query("nat") String nationality,
                              @Query(value = "inc") String includedFields);

    default Call<RandomUser> getUsers(final Integer results, final String nationality) {
        return getUsers(results, nationality, "name,location,email,cell");
    }
}
