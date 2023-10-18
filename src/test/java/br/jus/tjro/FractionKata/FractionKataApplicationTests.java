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
	public void testAddFractionsTodosZeros() throws Exception {
		FractionRequest request = new FractionRequest(0, 1, 0, 1);

		mockMvc.perform(post("/fractions/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(0))
				.andExpect(jsonPath("$.denominator").value(1));
	}

	@Test
	public void testAddFractionsTodosUm() throws Exception {
		FractionRequest request = new FractionRequest(1, 1, 1, 1);

		mockMvc.perform(post("/fractions/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(2))
				.andExpect(jsonPath("$.denominator").value(1));
	}

	@Test
	public void testAddFractionsSomaNumerosNegativos() throws Exception {
		FractionRequest request = new FractionRequest(-1, -1, -1, -1);

		mockMvc.perform(post("/fractions/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(2))
				.andExpect(jsonPath("$.denominator").value(1));
	}

	@Test
	public void testAddFractionsSimplificado() throws Exception {
		FractionRequest request = new FractionRequest(10, 12, 6, 12);

		mockMvc.perform(post("/fractions/add")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(4))
				.andExpect(jsonPath("$.denominator").value(3));
	}

//	@Test
//	public void testAddFractionsDenominadorZero() throws Exception {
//		FractionRequest request = new FractionRequest(10, 0, 6, 0);
//
//		mockMvc.perform(post("/fractions/add")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(asJsonString(request)))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.numerator").value("Indeterminado"));
//	}

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
	public void testSubtractFractionsComZero() throws Exception {
		FractionRequest request = new FractionRequest(0, 1, 0, 1);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(0))
				.andExpect(jsonPath("$.denominator").value(1));
	}

	@Test
	public void testSubtractFractionsComUm() throws Exception {
		FractionRequest request = new FractionRequest(1, 3, 1, 4);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(1))
				.andExpect(jsonPath("$.denominator").value(12));
	}

	@Test
	public void testSubtractFractionsInteiros() throws Exception {
		FractionRequest request = new FractionRequest(3, 1, 1, 4);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(11))
				.andExpect(jsonPath("$.denominator").value(4));
	}

	@Test
	public void testSubtractFractionsMesmoDenominadores() throws Exception {
		FractionRequest request = new FractionRequest(3, 5, 1, 5);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(2))
				.andExpect(jsonPath("$.denominator").value(5));
	}

	@Test
	public void testSubtractFractionsDenominadoresDiferentes() throws Exception {
		FractionRequest request = new FractionRequest(3, 6, 1, 5);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(3))
				.andExpect(jsonPath("$.denominator").value(10));
	}

	@Test
	public void testSubtractFractionsFracoesNegativas() throws Exception {
		FractionRequest request = new FractionRequest(-3, 6, 2, 5);

		mockMvc.perform(post("/fractions/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.numerator").value(-9))
				.andExpect(jsonPath("$.denominator").value(10));
	}

//	@Test
//	public void testSubtractFractionsFracoesNegativasZero() throws Exception {
//		FractionRequest request = new FractionRequest(3, 0, 2, 0);
//
//		mockMvc.perform(post("/fractions/subtract")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(asJsonString(request)))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.numerator").value(0))
//				.andExpect(jsonPath("$.denominator").value(0));
//	}

//	@Test
//	public void testSubtractFractionsFracoesSimplificadas() throws Exception {
//		FractionRequest request = new FractionRequest(10, 2, 15, 30);
//
//		mockMvc.perform(post("/fractions/subtract")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(asJsonString(request)))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.numerator").value(1))
//				.andExpect(jsonPath("$.denominator").value(5));
//	}

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
