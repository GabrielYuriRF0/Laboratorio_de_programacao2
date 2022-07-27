import javax.print.DocFlavor;


public class Contato {
    /**
     * Primeiro nome do contato
     */
    private String nome;

    /**
     * Primeiro sobrenome do contato.
     */
    private String sobrenome;

    /**
     * Telefone do contato.
     */
    private String telefone;

    /**
     * Vai armazenar um coração, caso o contato seja um favorito.
     */
    private String emoji;

    /**
     * Array que voi conter todas as tags de um contato.
     */
    private String tags[] = new String[5];

    /**
     * Indica se um contato tem tag ou não.
     */
    private boolean temTag = false;

    /**
     * Indica se um contato é favorito ou não
     */
    private boolean ehFavorito = false;

    /**
     * Indica se um contato foi removido ou não.
     */
    private boolean estaDeletado = false;


    /**
     * Constrói um contato setando todas os atributos como vázio.
     */
    public Contato(){
        this.nome = "";
        this.sobrenome = "";
        this.telefone = "";
        this.emoji = "";

        for(int i = 0; i < tags.length;i++){
            tags[i] = "";
        }


    }

    /**
     * Constrói um contato com um nome, sobrenome e telefone e
     * não permitindo a criação caso o nome seja inválido.
     *
     * @param nome: Primeiro nome do contato.
     * @param sobrenome: Primeiro sobrenome do contato.
     * @param telefone: Telefone do contato.
     */
    public Contato(String nome, String sobrenome, String telefone){

        if(nome == null || sobrenome == null || telefone == null){
            throw new NullPointerException("Parâmetro nulo!");
        }


        else if(nome.trim().isEmpty()){
            throw  new IllegalArgumentException("Nome vazio ou composto apenas de espaços");
        }
        else{
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.telefone = telefone;

        }


    }

    /**
     * Método responsável por exibir todos os atributos de um contato.
     *
     * @return String contendo todos os dados associados ao contato.
     */
   @Override
    public String toString() {
       if(this.estaDeletado == true){
           return "Contato Removido!";
       }

       else if(this.ehFavorito = true && this.temTag == true){
           return  this.emoji + " " +this.nome + " " + this.sobrenome + "\n" + this.telefone + "\n"
                   + this.tags[0] + " " + this.tags[1] + " " + this.tags[2] + " " + this.tags[3] + " " + this.tags[4];

       }
       else if(this.ehFavorito == false && this.temTag == true){
           return this.nome + " " + this.sobrenome + "\n" + this.telefone + "\n"
                   + this.tags[0] + " " + this.tags[1] + " " + this.tags[2] + " " + this.tags[3] + " " + this.tags[4];

       }
       else if(this.ehFavorito = true && this.temTag == false){
           return  this.emoji + " " +this.nome + " " + this.sobrenome + "\n" + this.telefone;

       }
       else{
           return this.nome + " " + this.sobrenome + "\n" + this.telefone;

       }


    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }



    public String getTelefone(){
       return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmoji(){
       return this.emoji;
    }

    public void setEmoji(String emoji){
       this.emoji = emoji;
    }




    public boolean getTag(String tag){
       boolean achouTag = false;

       for(int i = 0; i < tag.length(); i++){
           if(tags[i].equals(tag)){
               achouTag = true;
           }

       }
       return achouTag;
    }
    public void setTags(String tag, int posicaoTag){
       this.tags[posicaoTag - 1] = tag;
    }


    public boolean getTemTag(){
       return this.temTag;
    }

    public void setTemTag(boolean temTag){
       this.temTag = temTag;
    }


    public void setEhFavorito(boolean ehfavorito){
       this.ehFavorito = ehFavorito;
    }

    public boolean getEhFavorito(){
       return this.ehFavorito;
    }

    public boolean getEstaDeletado(){
       return this.estaDeletado;
    }

    public void setEstaDeletado(boolean estaDeletado){
       this.estaDeletado = estaDeletado;
    }

}
