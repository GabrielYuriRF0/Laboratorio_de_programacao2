public class Eleitor {
    private String cpf;
    private String nome;
    private boolean statusVotacao;

    public Eleitor(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
        this.statusVotacao = false;
    }

    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }

    public boolean getStatusVotacao(){
        return this.getStatusVotacao();
    }

    public void setStatusVotacao(boolean statusVotacao){
        this.statusVotacao = statusVotacao;
    }



    @Override
    public String toString(){
        if (this.statusVotacao == true){
            return this.cpf +  " - " + this.nome +  " - " + "VOTO DEPOSITADO";
        }
        else{
            return this.cpf +  " - " + this.nome +  " - " + "VOTO NÃO DEPOSITADO";

        }
    }
}
