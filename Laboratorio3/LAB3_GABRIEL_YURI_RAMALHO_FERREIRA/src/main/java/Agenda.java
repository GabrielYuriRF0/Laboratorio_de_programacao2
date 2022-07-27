
import java.util.ArrayList;

/**
 * Agenda que mantem uma lista de 100 contatos, permitindo várias operaçoes com esses
 * contatos, como adicionar novo contanto, remover contato, pesquisar contato
 * e listar todos os contatos.
 *
 * @author Gabriel Yuri Ramalho Ferreira
 */
public class Agenda {

    /**
     * Atributo responsável por armazenar o tamanho
     * do array de contatos.
     */
    public static final int TAMANHO_AGENDA = 100;
    /**
     *  Array do tipo contato, onde cada posição
     *  se referea um contato cadastrado.
     */
    private Contato[] contatos = new Contato[TAMANHO_AGENDA];
    /**
     * Array que vai armazenar todos os favoritos
     * criados durante a execução do programa.
     */
    private Contato[] favoritos = new Contato[10];


    /**
     * Responsável por inicializar o array de contatos e favoritos,
     */
    public Agenda() {

        for (int i = 0; i < TAMANHO_AGENDA; i++) {
            this.contatos[i] = new Contato();

        }

        for (int i = 0; i < 10; i++) {
            this.favoritos[i] = new Contato();
        }

    }

    /**
     * Método que lista todos os contatos que possuem um certo nome
     * ou sobrenome
     *
     * @param nome: Nome ou sobrenome realizado para listar contatos.
     *
     * @return ArrayList contendo todos os contatos que possuem o paramêtro em seu
     * nome ou sobrenome.
     */

    public ArrayList<Contato> consultaNomeSobrenome(String nome){
        ArrayList <Contato> listaContatos = new ArrayList<Contato>();

        if(validarNomeTelefone(nome) == false){
            return  null;
        }

        else{
            for(int i = 0; i < contatos.length; i++){
                if(contatos[i].getNome().equals(nome) || contatos[i].getSobrenome().equals(nome)){
                    listaContatos.add(contatos[i]);
                }
            }
        }
        return listaContatos;

    }

    /**
     * Método responsável por exibir todos os contatos que possuem
     * uma determinada tag.
     *
     * @param tag: String que sera a base da listagem.
     *
     * @return  ArrayList contendo todos os contatos que possuem
     * a tag em questão.
     */
    public ArrayList<Contato> consultaPelaTag(String tag){
        ArrayList<Contato> listaContatos = new ArrayList<Contato>();

        if(validarNomeTelefone(tag) == false){
            return  null;
        }

        for(int i = 0; i < contatos.length; i++){
            if(contatos[i].getTemTag() && contatos[i].getTag(tag)){
                listaContatos.add(contatos[i]);
                }
            }

        return listaContatos;
    }


    /**
     * Acessa a lista de contatos mantida.
     *
     * @return  array de contatos.
     */
    public Contato[] getContatos() {
        return this.contatos;
    }

    /**
     * Acessa os dados de um contato específico.
     *
     * @param posicao Posição do contato na agenda.
     *
     * @return Dados do contato naquela na posição especificada.
     */
    public String getContato(int posicao) {
        if (validarPosicaoContato(posicao) == false) {
            return "POSIÇÃO INVÁLIDA";
        } else if (contatos[posicao - 1].getNome().isEmpty() == true && contatos[posicao - 1].getEstaDeletado() == false) {
            return "CONTATO NÃO CADASTRADO";
        } else {
            return this.contatos[posicao - 1].toString();

        }

    }

    /**
     * Verifica se um contato tem tag
     * @param posicaoContato: Posição do contato na agenda
     * @return Um booleano que é true caso tenha tag e false caso contrário.
     */
    public boolean contatoTemTag(int posicaoContato){
        return this.contatos[posicaoContato - 1].getTemTag();
    }

    /**
     * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior
     * e não é permitido o cadastro de um mesmo contato, mesmo que seja em posições diferentes.
     *
     * @param posicao Posição do contato.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @param telefone Telefone do contato.
     *
     * @return booleano que indica se o cadastro foi realizado com sucesso.
     */
    public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
        boolean contatoCadastrado = true;

        if (validarPosicaoContato(posicao) == false || validarNomeTelefone(telefone) == false || validarNomeTelefone(nome) == false || validarNomeTelefone(sobrenome) == false ){
            contatoCadastrado = false;
        }
        else {
                // Verifcar se o nome e sobrenome já estão cadastrados
                for (int i = 0; i < 100; i++) {
                    if (nome.equals(contatos[i].getNome()) && sobrenome.equals(contatos[i].getSobrenome())) {
                        contatoCadastrado = false;
                        break;
                    }

                }
                if(contatoCadastrado){
                    this.contatos[posicao - 1].setNome(nome);
                    this.contatos[posicao - 1].setSobrenome(sobrenome);
                    this.contatos[posicao - 1].setTelefone(telefone);
                }

            }

        return contatoCadastrado;
    }


    /**
     * Método para adicionar um contanto na lista de favoritos
     *
     * @param posicaoContato: Posição do contato da agenda.
     * @param posicaoFavorito: Posição que o contato deve ser inserido na lista de favoritos.
     *
     * @return Uma String que indica a situação do contato em questõo, podendo ele ter
     * a posição inválida ou já estar cadastrado dentro da lista de favoritos.
     */
    public String adicionarFavorito(int posicaoContato, int posicaoFavorito) {
        // Verificar se o contato já está cadastrada na lista de favoritos

        if ((posicaoFavorito < 1 || posicaoFavorito > 10) || validarPosicaoContato(posicaoContato) == false) {
            return "Posição inválida!";

        }
        else {
            for (int i = 0; i < favoritos.length; i++) {
                if (contatos[posicaoContato - 1].getNome().equals(favoritos[i].getNome()) && contatos[posicaoContato - 1].getSobrenome().equals(favoritos[i].getSobrenome()) && favoritos[posicaoFavorito - 1].getEhFavorito() == false) {
                    return "Contato já favoritado!";


                } else {
                    favoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
                    favoritos[posicaoFavorito - 1].setEstaDeletado(false);
                    contatos[posicaoContato - 1].setEhFavorito(true);
                    favoritos[posicaoFavorito - 1].setEmoji("❤");

                    return "Contato favoritado na posição " + posicaoContato + "!";


                }
            }


        }
        return "";


    }


    /**
     * Lista os contatos existentes no array de favoritos, caso
     * eles não sejam nulos e não estejam setados como deletados.
     */
    public void listarFavoritos() {

        //Laço para verificar os favoritos:
        for (int i = 0; i < 10; i++) {
            if ((favoritos[i].getNome().isEmpty() == false) && favoritos[i].getEstaDeletado() == false) {
                System.out.println((i + 1) + " - " + favoritos[i].getNome() + " " + favoritos[i].getSobrenome());
            }
        }
    }


    /**
     * Método responsável por adicionar uma tag em um ou mais contatos.
     *
     * @param posicoesContato: Array que vai indicar os contatos que vão receber essa tag
     * @param tag: String que é a tag a ser recebida
     * @param posicaoTag: Posição da tag dentro do array de tags
     *
     * @return String que identifica qual a situação após tentar adicionar a tag.
     */
    public String adicionarTag(int[] posicoesContato, String tag, int posicaoTag) {
        String controle = "";
        // Verificando se a posição da tag é válida:
        if (validarPosicaoTag(posicaoTag) == false) {
            controle = "Posição da tag inválida!";
        } else if (posicoesContato.length == 1 && !(contatos[posicoesContato[0] - 1].getNome().equals(""))) {
            contatos[posicoesContato[0] - 1].setTags(tag, posicaoTag);
            contatos[posicoesContato[0] - 1].setTemTag(true);
        } else {
            //Verificando se todas as posições do vetor posicoesContato são válidas:
            for (int j = 0; j < posicoesContato.length; j++) {
                if (validarPosicaoTag(posicoesContato[j]) == false) {
                    controle = "Posição inválida!";
                }
            }

            if (controle.equals("Posição inválida!") == false) {
                for (int i = 0; i < posicoesContato.length; i++) {
                    if ((contatos[posicoesContato[i] - 1].getNome().isEmpty()) || (validarPosicaoContato(posicoesContato[i]) == false)) {
                        return "Contato inexistente!";
                    } else {
                        contatos[posicoesContato[i] - 1].setTags(tag, posicaoTag);
                        contatos[posicoesContato[i] - 1].setTemTag(true);


                    }

                }

            }

        }


        return controle;
    }

    /**
     * Remove um ou mais contatos, setando o atributo estaDeletado como true,
     * para não serem exibidos.
     *
     * @param posicoesContatos: Posições dos contatos que devem ser removidos.
     *
     * @return String que indica a situação após a execução do método.
     */
    public String removerContato(int[] posicoesContatos) {
        String status = "Remoção concluída!";

        // Verificando se as posições estão dentro do intervalo de 1 a 100
        for(int i = 0; i < posicoesContatos.length; i++){
            if(validarPosicaoContato(posicoesContatos[i]) == false){
                status = "Posição inválida!";
                break;
            }
        }
        if(status != "Posição inválida!"){
            //Verificar se os contatos em questão não existem ou já foram deletados
            for(int i = 0; i < posicoesContatos.length; i++){
                if(contatos[posicoesContatos[i] - 1].getEstaDeletado() ||contatos[posicoesContatos[i] - 1].getNome().isEmpty()){
                    status = "Posição inválida!";
                    break;
                }
            }

        }


        // Caso o contato possa ser removido:
        if(status.equals("Posição inválida!") == false){
            //Verififcando se os contatos estão dentro da lista de favoritos:
            for(int i = 0; i < posicoesContatos.length; i++){
                contatos[posicoesContatos[i] - 1].setEstaDeletado(true);

                for(int j = 0; j < favoritos.length; j++){
                    if(contatos[posicoesContatos[i] - 1].getNome().equals(favoritos[j].getNome())){
                        favoritos[j].setEstaDeletado(true);

                    }

                }

            }



        }

        return status;

    }

    /**
     * Método que modifica o telefone de um contato.
     *
     * @param posicaoContato: Posição do contato em questão
     * @param novoTelefone: String que representa o novo telefone do contato
     *
     * @return Booleano que indica se a modificação foi feita com sucesso ou não.
     */
    public boolean modificarTelefone(int posicaoContato, String novoTelefone){

        if(validarPosicaoContato(posicaoContato)  && validarNomeTelefone(novoTelefone)  && contatos[posicaoContato - 1].getNome().isEmpty() == false){
            contatos[posicaoContato - 1].setTelefone(novoTelefone);
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Método para remover a tag de um contato, desde que esse contato tenha
     * o atributo temTag como true.
     *
     * @param posicaoContato: Posição do contato em questão.
     * @param posicaoTag: Posiçao da tag a ser removida dentro do array de tags.

     * @return Booleano que indica se a remoção foi feita com sucesso ou não.
     */
    public boolean removerTag(int posicaoContato, int posicaoTag){

        if(validarPosicaoContato(posicaoContato) && validarPosicaoTag(posicaoTag) && validarContato(posicaoContato) && contatos[posicaoContato - 1].getTemTag()){
            contatos[posicaoContato - 1].setTags("",  posicaoTag);
            return  true;
        }

        else{
            return false;
        }
    }


    /**
     * Método para verificar se a posição inserida está dentro do intervalo de 1 a 100.
     *
     * @param posicaoContato: Posição a ser verificada.
     *
     * @return Booelano que indiica se o posição é valida ou não.
     */
    public boolean validarPosicaoContato(int posicaoContato){
        return !(posicaoContato < 1 || posicaoContato > 100);

    }


    /**
     * Método que valida um nome,sobrenome ou telefone, verificando se ele é nulo, vázio ou
     * composto somente por espaços.
     * @param dado: nome, sobrenome ou telefone a ser analisado
     * @return Booleano que indica se o dado é válido ou não.
     */
    public boolean validarNomeTelefone(String dado){
        return !(dado == null || dado.isEmpty() || dado.trim().isEmpty());
    }

    /**
     * Verifica se a posição da tag está no intervalo entre 1 e 5
     * @param posicaoTag: Posição a ser analisada
     *
     * @return Booleano que indica a validade da posição.
     */
    public boolean validarPosicaoTag(int posicaoTag){
        return !(posicaoTag < 1 || posicaoTag > 5);
    }

    /**
     * Verifica se um contato está cadastrado, verificando se sua posição é vázia.
     *
     * @param posicaoContato: Posição do contato a ser analisada.
     *
     * @return Booleano que indica a validade do contato.
     */
    public boolean validarContato(int posicaoContato){
        if(validarPosicaoContato(posicaoContato)){
            return contatos[posicaoContato - 1].getNome() != "";

        }
        return false;

    }

    /**
     * Remover um contato da lista de favoritos
     * de acordo com o nome e sobrenome.
     *
     * @param nome: Nome do contato.
     * @param sobrenome: Sobrenome do contato.
     *
     * @return Booelano que indica o sucesso da remoção.
     */
    public boolean removerFavorito(String nome, String sobrenome){
        boolean favoritoRemovido = false;
        // Verificar se o contato está dentro da lista de favoritos
        for(int i = 0; i < favoritos.length; i++){
            if(favoritos[0].getNome().equals(nome) && favoritos[0].getSobrenome().equals(sobrenome)){
                favoritos[i].setEmoji("");
                favoritos[i].setEstaDeletado(true);
                favoritoRemovido = true;
                break;
            }

        }
        return favoritoRemovido;
    }


}
