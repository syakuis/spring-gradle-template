package io.github.syakuis;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.junit4.SpringRunner;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private MessageSourceAccessor i18n;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void hello() {
        String name = i18n.getMessage("project.name");
        Assert.assertEquals("iParking Platform", name);
        log.debug(name);
    }

    @Test
    public void objectMapper() throws Exception {
        String json = "[1,2,3,4]";
        objectMapper.readValue(json, ArrayList.class);
        assertEquals(
            Arrays.asList(1, 2, 3, 4),
            objectMapper.readValue(json, ArrayList.class));
    }
}
