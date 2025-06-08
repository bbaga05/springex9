package ru.itementor.spring.boot_rest_template.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itementor.spring.boot_rest_template.demo.Service.ApiClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApiClient apiClient;

	@Test
	public void testApiClient() {
		String finalCode = apiClient.runClient();

		assertNotNull(finalCode, "Final code should not be null");
		assertEquals(18, finalCode.length(), "Final code length should be 18 characters");
	}

}
