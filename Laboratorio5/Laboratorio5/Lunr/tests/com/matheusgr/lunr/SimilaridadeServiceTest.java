package com.matheusgr.lunr;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimilaridadeServiceTest extends BaseTest {
	@Test
	void testSimilaridade() {
		var documentoOpt = this.documentoController.recuperarDocumento(TEXTO1_ID);
		assertTrue(documentoOpt.isPresent());
		
		var documentoOpt2 = this.documentoController.recuperarDocumento(TEXTO2_ID);
		assertTrue(documentoOpt.isPresent());
		var doc2 = documentoOpt.get();
		
		assertEquals(0.5,this.similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID));
	}

}
