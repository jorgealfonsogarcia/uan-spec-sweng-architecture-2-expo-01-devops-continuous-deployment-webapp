package co.edu.uan.sweng.architecture.devops.cd.model.service;

import co.edu.uan.sweng.architecture.devops.cd.model.enums.Nationality;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Locale.ROOT;

/**
 * Business service to generate the information required by the UI to display the countries' flags.
 *
 * @author Jorge Garcia.
 * @author Diego Poveda.
 * @version 1.0.0
 * @since 17
 */
@Service
public class FlagService {

    private final String flagImagesPath;

    public FlagService(@Value("${flag.images.path}") String flagImagesPath) {
        this.flagImagesPath = flagImagesPath;
    }

    /**
     * Gets an unmodifiable map with all the flag images for the supported countries.
     *
     * @return the map with all the flag images.
     */
    public Map<String, String> getFlagImagesPathMap() {
        return Arrays.stream(Nationality.values())
                .collect(Collectors.toUnmodifiableMap(Enum::name, getNationalityStringFunction()));
    }

    @NotNull
    private Function<Nationality, String> getNationalityStringFunction() {
        return nationality -> "%s/%s_16.png".formatted(flagImagesPath, nationality.name().toLowerCase(ROOT));
    }
}
