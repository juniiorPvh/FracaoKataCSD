package br.jus.tjro.FractionKata;

import br.jus.tjro.FractionKata.model.FractionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FractionKataApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	//https://www.linkedin.com/pulse/summary-software-craft-chapter-7-fraction-kata-ilias-el-mhamdi/
	@Test
	public void testAddFractions() throws Exception {
		FractionRequest request = new FractionRequest(1, 2, 1, 3);

		mockMvc.perform(post("/fractions/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(5))
				.andExpect(jsonPath("$.denominator").value(6));
	}

	@Test
	public void testAddFractions2() throws Exception {
		FractionRequest request = new FractionRequest(2, 7, 3, 7);

		mockMvc.perform(post("/fractions/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(5))
				.andExpect(jsonPath("$.denominator").value(7));
	}

	@Test
	public void testSubtractFractions() throws Exception {
		FractionRequest request = new FractionRequest(3, 4, 1, 4);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(1))
				.andExpect(jsonPath("$.denominator").value(2));
	}

	@Test
	public void testMultiplyFractions() throws Exception {
		FractionRequest request = new FractionRequest(2, 3, 1, 4);

		mockMvc.perform(post("/fractions/multiply")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(1))
				.andExpect(jsonPath("$.denominator").value(6));
	}

	@Test
	public void testDivideFractions() throws Exception {
		FractionRequest request = new FractionRequest(3, 5, 2, 3);

		mockMvc.perform(post("/fractions/divide")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(9))
				.andExpect(jsonPath("$.denominator").value(10));
	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
