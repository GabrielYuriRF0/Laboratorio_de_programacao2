package com.matheusgr.lunr.documento;


import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Repositório de documentos. O repositório pode ter operações simples de busca,
 * mas a lógica de ranking, limitação e ordenação deve ficar em outra entidade.
 * 
 * O ID de um documento é único.
 */
  class DocumentoRepository {
	private Map<String,Documento> documentos;
	private ValidadorDocumentos validador;

	/**
	 * Construção padrão do repositório de documentos.
	 */
	     DocumentoRepository() {
		this.documentos = new HashMap<>();
		this.validador = new ValidadorDocumentos();
		
	}

	/**
	 * Adiciona o documento. O documento é validado para garantir a consistência do
	 * documento (sem termos e id vazios).
	 * 
	 * @param d Documento a ser adicionado.
	 */
	void adiciona(Documento d) {
		this.validador.validacao(d.getId(), d.getTexto());
		this.documentos.put(d.getId(),d);
	}

	/**
	 * Recupera um documento do repositório.
	 * 
	 * @param id ID do documento.
	 * @return Documento, caso exista.
	 */
	Optional<Documento> recupera(String id) {
		this.validador.validacao(id);
		Documento doc = documentos.get(id);
		return Optional.ofNullable(doc);
	}

	/**
	 * Retorna o total de documentos cadastrados.
	 * 
	 * @return O total de documentos cadastrados.
	 */
	int totalDocumentos() {
		return this.documentos.size();
	}

	/**
	 * Realiza uma busca pelos termos.
	 * 
	 * @param termo Termo a ser buscado.
	 * @return Conjunto de documentos com o termo.
	 */
	public Set<Documento> busca(String termo) {
		return this.documentos.values().stream()
					.filter((x) -> Arrays.binarySearch(x.getTexto(), termo) > 0)
					.collect(Collectors.toSet());
	}
	
	public Set <Documento> busca(Map<String,String> metaDados){ 
		Set <Documento> documentos = new HashSet<>();
		boolean jaExiste;
		
	
		for(Documento documento: this.documentos.values()) {
			jaExiste = false;
			for(String chave: metaDados.keySet()) {
				if(documento.getMetadados().containsKey(chave) ) {
					if(documento.getMetadados().get(chave).equals(metaDados.get(chave))) {
						jaExiste = true;
						
		
					}
					else {
						break;
					}
				}
			}
			if(jaExiste == true) {
				documentos.add(documento);
				
			}
			
		}
		return documentos;
		
	}
	
	
 	
	
	
	
	
	
	
	
	

	

}
