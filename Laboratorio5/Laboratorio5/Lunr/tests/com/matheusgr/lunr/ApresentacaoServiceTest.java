package com.matheusgr.lunr;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ApresentacaoServiceTest extends BaseTest {
	
	@Test
	void testApresentacaoPrimeirasLinhas(){
		assertEquals("um arquivo! texto simples.\r", this.apresentacaoController.apresenta(TEXTO1_ID, "Imprimir primeiras 1 linhas"));
		 
	}
	
	@Test
	void testeApresentacaoUltimasLinhas() {
		assertEquals("use TRÊS linhas agora.\r\nMAIS AVANÇO!", this.apresentacaoController.apresenta(TEXTO2_ID, "Imprimir ultimas 2 linhas"));
		
	}
	
	@Test
	void testApresentacaoExibirCaixaAlta() {
		assertEquals("um arquivo! texto simples.\r\nuse DUAS linhas apenas.".toUpperCase()
				,this.apresentacaoController.apresenta(TEXTO1_ID,"Imprimir caixa alta"));
	}

}
