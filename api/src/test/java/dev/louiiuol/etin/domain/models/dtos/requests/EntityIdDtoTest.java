package dev.louiiuol.etin.domain.models.dtos.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dev.louiiuol.etin.UnitTestConfig;

public class EntityIdDtoTest extends UnitTestConfig{

	private static final String jsonId = "{\"id\":1}";
	private final EntityIdDto actualEntity = MAPPER.readValue(jsonId, EntityIdDto.class);

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