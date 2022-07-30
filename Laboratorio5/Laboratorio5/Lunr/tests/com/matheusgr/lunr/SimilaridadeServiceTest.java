package com.matheusgr.lunr;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimilaridadeServiceTest extends BaseTest {
	@Test
	void testSimilaridade() {
		assertEquals(0.5,this.similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID));
		
	}

}
