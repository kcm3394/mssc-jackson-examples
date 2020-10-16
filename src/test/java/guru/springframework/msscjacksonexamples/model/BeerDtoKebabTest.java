package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testKebab() throws JsonProcessingException {
        BeerDto dto = new BeerDto.BeerDtoBuilder()
                .beerName("Daisy")
                .beerStyle("IPA")
                .createdDate(OffsetDateTime.now())
                .lastUpdatedDate(OffsetDateTime.now())
                .id(UUID.randomUUID())
                .price(new BigDecimal("12.99"))
                .upc(12345L)
                .build();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }
}
