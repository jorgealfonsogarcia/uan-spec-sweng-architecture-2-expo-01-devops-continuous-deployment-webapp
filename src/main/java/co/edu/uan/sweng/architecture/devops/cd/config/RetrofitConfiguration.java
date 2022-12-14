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

package co.edu.uan.sweng.architecture.devops.cd.config;

import co.edu.uan.sweng.architecture.devops.cd.persistence.rest.RandomUsersRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Configuration for Retrofit clients.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
@Configuration
public class RetrofitConfiguration {

    private final String randomUsersRestServiceUrl;

    /**
     * Constructor.
     *
     * @param randomUsersRestServiceUrl the URL for RandomUsers REST API.
     */
    public RetrofitConfiguration(@Value("${randomusers.rest.service.url}") String randomUsersRestServiceUrl) {
        this.randomUsersRestServiceUrl = randomUsersRestServiceUrl;
    }

    /**
     * Creates the bean for the RandomUsers REST API client.
     *
     * @return the bean for the RandomUsers REST API client.
     */
    @Bean
    public RandomUsersRestClient randomUsersRestClient() {
        return new Retrofit.Builder().baseUrl(randomUsersRestServiceUrl)
                .addConverterFactory(GsonConverterFactory.create()).build().create(RandomUsersRestClient.class);
    }
}
