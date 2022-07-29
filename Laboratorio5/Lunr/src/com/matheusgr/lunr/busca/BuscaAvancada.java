package com.matheusgr.lunr.busca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Busca avançada permite que sejam feitas pesquisas utilizando os 
 * MetaDados de um documento.
 * 
 * Deve ser considerado todos os documentos que possuem todos
 * os MetaDados.
 * 
 * Não é necessário ordenar nem limitar a quantidade de respostas.
 * 
 * @author Gabiel Yuri Ramalho Ferreira.
 *
 */

class BuscaAvancada implements  Busca{
	
	private HashMap<String, String> metaDados;
	
	public BuscaAvancada(HashMap <String, String> metaDados) {
		(new ValidadorBusca()).valida(metaDados);
		this.metaDados = metaDados;
	}
	 
	public Map <Documento,Integer> busca(DocumentoService ds) {
		int i = 0;
		
		Map <Documento,Integer> respostaDocumentos = new HashMap();
		
		for (Documento d : ds.busca(metaDados)) {
			respostaDocumentos.put(d,i++);
		}
		
		
		return respostaDocumentos;
	
	}
	
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metaDados.size()][];
		for (metaDados.) {
			resultado[i] = new String[] {"TERMO " + (i + 1), this.termos[i]};
		}
		return resultado;
	}
}