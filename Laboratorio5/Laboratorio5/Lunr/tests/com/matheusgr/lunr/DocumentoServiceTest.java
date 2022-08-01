package com.matheusgr.lunr;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class DocumentoServiceTest extends BaseTest {
	@Test
	void testeAdicionarDocumento() {
		this.documentoController.adicionaDocumentoTxt("Documento de teste", "Teste Teste Teste");
		assertEquals(5,this.documentoController.totalDocumentos());		
	}
	
	@Test
	void testeRecuperarDocumento() {
		var documentoOpt = this.documentoController.recuperarDocumento(TEXTO1_ID);
		assertTrue(documentoOpt.isPresent());
		var doc = documentoOpt.get();
		
		assertEquals("um arquivo! texto simples.\r\nuse DUAS linhas apenas.",doc.getTextoOriginal());
	}
	
	@Test
	void testRecuperaDocumentoOuFalhe() {
		var doc = this.documentoController.recuperaDocumentoOuFalhe(TEXTO2_ID);
		assertEquals("um arquivo! texto simples.\r\nuse TRÊS linhas agora.\r\nMAIS AVANÇO!",doc.getTextoOriginal());
			
	}
	
	@Test
	void testeRecuperarDocumentoOuFalheVazio(){
		try {
			this.documentoController.recuperaDocumentoOuFalhe("46546546");
		}
		catch(NoSuchElementException e){
			assertEquals("Documento não existe",e.getMessage());
			
		}
		
	}
	
	
}
