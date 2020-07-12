package io.github.syakuis;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTest {

    @Autowired
    private MessageSourceAccessor i18n;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void hello() {
        String name = i18n.getMessage("project.name");
        Assertions.assertEquals("iParking Platform", name);
        log.debug(name);
    }

    @Test
    void objectMapper() throws Exception {
        String json = "[1,2,3,4]";
        objectMapper.readValue(json, ArrayList.class);
        Assertions.assertEquals(
            Arrays.asList(1, 2, 3, 4),
            objectMapper.readValue(json, ArrayList.class));
    }
}
