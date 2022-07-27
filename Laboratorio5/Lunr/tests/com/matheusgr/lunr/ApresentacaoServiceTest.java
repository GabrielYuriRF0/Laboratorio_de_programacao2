package com.matheusgr.lunr;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ApresentacaoServiceTest extends BaseTest {
	
	@Test
	void testApresentacaoPrimeirasLinhas(){
		assertEquals("primeira linha\nsegunda linha\nterceira linha", this.apresentacaoController.apresenta(TEXTO5_ID, "Imprimir primeiras 3 linhas"));
		
		//assertEquals("", this.apresentacaoController.apresenta(TEXTO5_ID, "Imprimir conteúdo em caixa alta"));	
	}
	
	@Test
	void testeApresentacaoUltimasLinhas() {
		assertEquals("quarta linha\nquinta linha\nsexta linha.", this.apresentacaoController.apresenta(TEXTO5_ID, "Imprimir ultimas 3 linhas"));
		
	}
	
	@Test
	void testApresentacaoExibirCaixaAlta() {
		assertEquals("primeira linha\nsegunda linha\nterceira linha".toUpperCase()
				+ "\nquarta linha\nquinta linha\nsexta linha.".toUpperCase(),this.apresentacaoController.apresenta(TEXTO5_ID,"Imprimir caixa alta"));
	}

}
