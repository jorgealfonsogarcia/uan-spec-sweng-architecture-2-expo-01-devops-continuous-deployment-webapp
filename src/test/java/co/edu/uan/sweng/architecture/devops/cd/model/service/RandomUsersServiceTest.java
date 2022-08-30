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
import co.edu.uan.sweng.architecture.devops.cd.persistence.rest.RandomUsersRestClient;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;
import retrofit2.Response;

import static co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality.US;
import static co.edu.uan.sweng.architecture.devops.cd.test.util.JsonResourcesReader.read;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Unit test for {@link RandomUsersService}.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
@SpringBootTest
class RandomUsersServiceTest {

    @Mock
    private RandomUsersRestClient randomUsersRestClient;

    @Mock
    private Call<RandomUser> randomUserCall;

    @Mock
    private Response<RandomUser> randomUserResponse;

    private RandomUsersService randomUsersService;

    @BeforeEach
    void setUp() {
        randomUsersService = new RandomUsersService(randomUsersRestClient);
    }

    @Test
    @SneakyThrows
    void getUsers() {
        final var randomUser = read("response/randomusers-all.json", RandomUser.class);
        final var results = 3;
        final var nationality = US;

        when(randomUserResponse.body()).thenReturn(randomUser);
        when(randomUserCall.execute()).thenReturn(randomUserResponse);
        when(randomUsersRestClient.getUsers(eq(results), eq(nationality.name()))).thenReturn(randomUserCall);

        final var result = randomUsersService.getUsers(results, nationality);

        assertNotNull(result);
        assertEquals(randomUser, result);

        verify(randomUserResponse).body();
        verify(randomUserCall).execute();
        verify(randomUsersRestClient).getUsers(eq(results), eq(nationality.name()));
    }
}