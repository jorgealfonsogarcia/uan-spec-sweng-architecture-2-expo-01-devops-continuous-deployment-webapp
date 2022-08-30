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