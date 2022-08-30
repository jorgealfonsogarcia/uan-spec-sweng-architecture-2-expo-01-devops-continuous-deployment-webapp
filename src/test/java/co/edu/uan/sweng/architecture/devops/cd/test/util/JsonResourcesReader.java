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

package co.edu.uan.sweng.architecture.devops.cd.test.util;

import com.google.gson.Gson;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class JsonResourcesReader {

    public static <T> T read(final String filepath, final Class<T> tClass) throws IOException {
        try (final var reader = new BufferedReader(new InputStreamReader(new ClassPathResource(filepath)
                .getInputStream()))) {
            return new Gson().fromJson(reader, tClass);
        }
    }

    private JsonResourcesReader() {
    }
}
