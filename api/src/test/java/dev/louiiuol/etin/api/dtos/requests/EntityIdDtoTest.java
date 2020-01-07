package dev.louiiuol.etin.api.dtos.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dev.louiiuol.etin.api.utils.EntityIdDto;
import dev.louiiuol.etin.domain.UnitTestConfig;

public class EntityIdDtoTest extends UnitTestConfig{

	private static final String ID_JSON = "{\"id\":1}";
	private final EntityIdDto actualEntity = MAPPER.readValue(ID_JSON, EntityIdDto.class);

	protected EntityIdDtoTest() throws IOException {
		// Empty constructor
	}

	@Test
	void should_construct() {
		EntityIdDto actual = new EntityIdDto();
		assertNotNull(actual);
	}

	@Test
	void should_return_toString() {
		String expected = "{id=1}";
		String actual = actualEntity.toString();
		assertEquals(expected, actual);

	}
}