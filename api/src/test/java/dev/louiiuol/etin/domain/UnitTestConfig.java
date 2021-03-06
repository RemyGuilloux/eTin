package dev.louiiuol.etin.domain;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class UnitTestConfig {

	protected static final ObjectMapper MAPPER = new ObjectMapper();

	protected UnitTestConfig() throws IOException {

	}

	@BeforeAll
	protected static void setUp() {
		MAPPER.setVisibility(MAPPER.getSerializationConfig().getDefaultVisibilityChecker()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY).withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE));
		MAPPER.registerModule(new JavaTimeModule());
		MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

}