package com.matheusgr.apresentacao;


import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa 
 * a apresentação de documentos.
 */
public class ApresentacaoService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         ApresentacaoService.
	 */
	public ApresentacaoService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Realiza a apresentação do documento indicado.
	 * 
	 *  
	 * @param docId1 Documento a ser apresentado.
	 * @param tipoApresentacao modo de apresentacao a ser aplicado sobre o documento.
	 */
	public String apresenta(String docId, String tipoApresentacao) {
		String textoDocumento = this.documentoService.recuperaDocumento(docId).get().getTextoOriginal();
		String[] textoDocumentoSplitado = textoDocumento.split("\n");
		String[] ApresentacaoSplitada = tipoApresentacao.split(" ");
		String resultado = "";
		
		if(ApresentacaoSplitada.length == 4) {
			int numerosLinhas = Integer.parseInt(ApresentacaoSplitada[2]);
			int tamanhoTexto = textoDocumentoSplitado.length;
			//Imprimir n primeiras linhas
			if(ApresentacaoSplitada[1].equals("primeiras")) {
				for(int i = 0; i < numerosLinhas; i++) {
					resultado += textoDocumentoSplitado[i] + "\n";
				}	
				resultado = resultado.substring(0, resultado.length()-1);
				
				
			}
			//Imprimir n últimas linhas
			else {
				for(int i = tamanhoTexto - numerosLinhas; i < tamanhoTexto; i++) {
					resultado += textoDocumentoSplitado[i] + "\n";
				}
				resultado = resultado.substring(0, resultado.length()-1);
				
				
				
			}
			
			
		}
		//Imprimir todo o conteúdo em caixa alta
		else {
			for(int i = 0; i < textoDocumentoSplitado.length; i++) {
				resultado += textoDocumentoSplitado[i].toUpperCase() + "\n";
			}
			resultado = resultado.substring(0, resultado.length()-1);
			
		}
		return resultado;
		
	}

}
