package com.matheusgr.lunr;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class DocumentoTextoTest extends BaseTest {
	@Test
	void testeMetricaUtil() {
		var documentoOpt = this.documentoController.recuperarDocumento(TEXTO1_ID);
		assertTrue(documentoOpt.isPresent());
		var doc = documentoOpt.get();
		assertEquals(0.803921568627451,doc.metricaTextoUtil());
		
	}
	
	@Test
	void testeGetMetaDados() {
		var documentoOpt = this.documentoController.recuperarDocumento(TEXTO1_ID);
		assertTrue(documentoOpt.isPresent());
		var doc = documentoOpt.get();
		Map<String,String> metaDados = doc.getMetadados();
		assertEquals(metaDados,doc.getMetadados());
		
	}
	

}
