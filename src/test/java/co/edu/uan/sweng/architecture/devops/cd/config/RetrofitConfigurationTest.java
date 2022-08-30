package co.edu.uan.sweng.architecture.devops.cd.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RetrofitConfigurationTest {

    private RetrofitConfiguration retrofitConfiguration;

    @BeforeEach
    void setUp() {
        retrofitConfiguration = new RetrofitConfiguration("https://example.com");
    }

    @Test
    void randomUsersRestClient() {
        assertNotNull(retrofitConfiguration.randomUsersRestClient());
    }
}