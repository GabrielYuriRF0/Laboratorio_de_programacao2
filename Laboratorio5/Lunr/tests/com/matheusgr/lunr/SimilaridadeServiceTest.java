package com.matheusgr.lunr;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimilaridadeServiceTest extends BaseTest {
	@Test
	void testSimilaridade() {
		var documentoOpt = this.documentoController.recuperarDocumento(TEXTO3_ID);
		assertTrue(documentoOpt.isPresent());
		var doc1 = documentoOpt.get();
		
		var documentoOpt2 = this.documentoController.recuperarDocumento(TEXTO4_ID);
		assertTrue(documentoOpt.isPresent());
		var doc2 = documentoOpt.get();
		
		assertEquals(0.2,this.similaridadeController.similaridade(TEXTO3_ID, TEXTO4_ID));
	}

}
