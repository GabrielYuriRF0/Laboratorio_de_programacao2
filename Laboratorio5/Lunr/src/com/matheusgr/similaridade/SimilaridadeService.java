package com.matheusgr.similaridade;


import java.util.Arrays;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;
import java.util.Optional;

/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 */
public class SimilaridadeService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}
	
	
	/**
	 * Criar um vetor contendo a intersercao entre os 2 conjuntos.
	 * @param conjunto1 Array contendo os termos do documento 1.
	 * @param conjunto2 Array contendo os termos do documento 2.
	 * @return intersecao Array contendo os elementos da interseção.
	 */
	
	private static String[] intersecao(String[] conjunto1, String[] conjunto2) {
			
			String[] aux = new String[conjunto1.length + conjunto2.length];
			int k = 0;
			
			for(int i = 0; i < conjunto1.length; i++) {
				for(int j = 0; j < conjunto2.length; j++) {
					if(conjunto1[i].equals(conjunto2[j])) {
						aux[k++] = conjunto1[i];
					}
				}
			}
			
			String[] intersecao = new String[k];
			for(int i = 0; i < k; i++) {
				intersecao[i] = aux[i];
			}
			return intersecao;
			
		}
	
	/**
	 * Criar um vetor contendo a união entre os 2 conjuntos.
	 * @param conjunto1 Array contendo os termos do documento 1.
	 * @param conjunto2 Array contendo os termos do documento 2.
	 * @return intersecao Array contendo os elementos da união.
	 */
	private static String[] uniao(String[] conjunto1, String[] conjunto2) {
		
		String[] uniao = new String[conjunto1.length + conjunto2.length];
		int k = 0;
		
		for(int i = 0; i < conjunto1.length;i++) {
			uniao[k++] = conjunto1[i];
		}
		
		for(int i = 0; i < conjunto2.length;i++) {
			if(!(existe(conjunto2[i],uniao,k))) {
				uniao[k++] = conjunto2[i];
			}
		}
		
		uniao = Arrays.copyOf(uniao, k);
		return uniao;
		
		
	}
	/**
	 * Método auxiliar ao método uniao(), que verifica
	 * se um elemento existe em determinado cojunto.
	 * @param texto Texto a ser verificado.
	 * @param uniao Conjunto que pode conter ou não o texto.
	 * @param k Tamanho do conjunto.
	 * @return boolean que retorna true caso exista e false caso contrário.
	 */
	private static boolean existe(String texto, String[] uniao, int k) {
		for(int i = 0; i < k; i++) {
			if(uniao[i].equals(texto)) {
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Método para remover duplicatas presentes no array de textos de cada documento.
	 * @param Array contendo o texto de cada documento.
	 * @return Array sem as duplicatas.
	 */
	private static String[] removerDuplicatas(String[] texto) {
		int n = texto.length;
		String[] textoFormatado = Arrays.copyOf(texto,n);
		
		for(int i = 0; i < n; i++) {
			int k = i + 1;
			int removidos = 0;
			for(int j = i + 1; j < n; j++) {
				if(textoFormatado[j].equals(textoFormatado[i])) {
					removidos++;
					
				}
				else {
					textoFormatado[k++] = textoFormatado[j];	 
				}
				
			}
			n -= removidos;
		}
		textoFormatado = Arrays.copyOf(textoFormatado, n);
		
		return textoFormatado;
		
	}
	
	
	
	

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		Optional <Documento> documento1 = this.documentoService.recuperaDocumento(docId1);
		Optional <Documento> documento2 = this.documentoService.recuperaDocumento(docId2);
		
		String[] texto1 = removerDuplicatas(documento1.get().getTexto());
		String[] texto2 = removerDuplicatas(documento2.get().getTexto());
		
		String[] intersecao = intersecao(texto1, texto2);
		String[] uniao = uniao(texto1, texto2);
		
		double similaridade = (double) intersecao.length /(double)uniao.length;
		
		return similaridade; 
		 
	}

}
