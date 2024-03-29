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
	
	private Map<String, String> metaDados;
	
	public BuscaAvancada(Map <String, String> metaDados) {
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
		int i = 0;
		String[][] resultado = new String[this.metaDados.size()][];
		for (String key: metaDados.keySet()) {
			resultado[i] = new String[] {"METADADO " + (i++), key + metaDados.get(key)};
					
		}
		return resultado;
	}
}