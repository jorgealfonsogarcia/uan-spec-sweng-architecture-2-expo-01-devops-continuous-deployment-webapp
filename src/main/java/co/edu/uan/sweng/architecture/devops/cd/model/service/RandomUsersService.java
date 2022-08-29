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

package co.edu.uan.sweng.architecture.devops.cd.model.service;

import co.edu.uan.sweng.architecture.devops.cd.model.dto.randomusers.RandomUser;
import co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality;
import co.edu.uan.sweng.architecture.devops.cd.persistence.rest.RandomUsersRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Slf4j
public class RandomUsersService {

    private final RandomUsersRestClient randomUsersRestClient;

    @Autowired
    public RandomUsersService(RandomUsersRestClient randomUsersRestClient) {
        this.randomUsersRestClient = randomUsersRestClient;
    }

    @GetMapping
    public RandomUser getUsers(final Integer results, final Nationality nationality) {
        return randomUsersRestClient.getUsers(results, nationality.name(), null);
    }
}
