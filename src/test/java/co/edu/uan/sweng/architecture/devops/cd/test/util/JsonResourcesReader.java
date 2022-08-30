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
