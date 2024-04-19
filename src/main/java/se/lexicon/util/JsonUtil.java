package se.lexicon.util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public static void writeJsonToFile(String filePath, Object object) throws IOException {
        mapper.writeValue(new File(filePath), object);
    }

    public static <T> T readJsonFromFile(String filePath, TypeReference<T> valueType) throws IOException {
    return mapper.readValue(new File(filePath), valueType);
    }
}