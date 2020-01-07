package dev.louiiuol.etin.services.swear;

import dev.louiiuol.etin.controllers.dtos.requests.tinees.SwearCreateDto;

/**  <p> Service to handle {@code Tinee}'s swears persistence.  </p> */
public interface SwearService {

	void addSwear(SwearCreateDto dto);

	void createSwear(SwearCreateDto dto);

}