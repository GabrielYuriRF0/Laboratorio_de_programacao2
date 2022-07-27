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

class BuscaAvancada{
	
	private HashMap<String, String> metaDados;
	
	public BuscaAvancada(HashMap <String, String> metaDados) {
		(new ValidadorBusca()).valida(metaDados);
		this.metaDados = metaDados;
	}
	
	public ArrayList <Documento> busca(DocumentoService ds) {
		ArrayList <Documento> documentos = new ArrayList<>();
		for (String termo : this.metaDados.values()) {
			if (termo.isBlank()) {
				continue;
			}
			for (Documento d : ds.busca(termo)) {
				documentos.add(d);
			}
		
		
	}
		return documentos;
	
	}
}