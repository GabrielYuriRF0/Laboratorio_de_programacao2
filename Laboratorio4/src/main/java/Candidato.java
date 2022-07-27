public class Candidato {
    private int id;
    private  String nome;
    private int quantidadeVotos;

    public Candidato(String nome, int id, int quantidadeVotos){
        this.nome = nome;
        this.id = id;
        this.quantidadeVotos = quantidadeVotos;
    }

    public String getNome(){
        return this.nome;
    }

    public void adicionarVoto(){
        this.quantidadeVotos++;
    }

    public void zerarVotos(){
        this.quantidadeVotos = 0;
    }

    public int getQuantidadeVotos(){
        return this.quantidadeVotos;
    }

    @Override
    public String toString(){
        return this.id + " - " + this.nome + " - " + "Quantidade de votos recebidos: " + this.quantidadeVotos;
    }
    @Override
    public boolean equals(Object obj){
        Candidato candidato = (Candidato) obj;
        return this.nome.equals(candidato.nome);

    }
}
