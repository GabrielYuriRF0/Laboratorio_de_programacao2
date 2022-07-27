public class Cachorro {
    private String nomeCachorro;
    private String nomeTutor;
    private int qtdRacaoDiaria;
    private String restricaoAlimentar;


    public Cachorro(String nomeCachorro, String nomeTutor, int qtdRacaoDiaria){
        this.nomeCachorro = nomeCachorro;
        this.nomeTutor = nomeTutor;
        this.qtdRacaoDiaria = qtdRacaoDiaria;
    }

    public Cachorro(String nomeCachorro, String nomeTutor, int qtdRacaoDiaria, String restricaoAlimentar){
        this.nomeCachorro = nomeCachorro;
        this.nomeTutor = nomeTutor;
        this.qtdRacaoDiaria = qtdRacaoDiaria;
        this.restricaoAlimentar = restricaoAlimentar;

    }

    @Override
    public String toString() {
        return "Dog" + " [nome = " + this.nomeCachorro +  ", tutor = " + this.nomeTutor + "]" ;
    }

    @Override
    public boolean equals(Object obj){
        boolean saoiguais = false;

        if(obj == null){
            saoiguais = false;
        }
        Cachorro cachorro = (Cachorro) obj;

         if(this.nomeCachorro.equals(cachorro.getNomeCachorro()) && this.nomeTutor.equals(cachorro.getNomeTutor())){
            saoiguais =  true;

        }
         return saoiguais;

    }

    public String getNomeCachorro(){
        return this.nomeCachorro;

    }

    public String getNomeTutor(){
        return this.nomeTutor;
    }

    public int getQtdRacaoDiaria(){
        return this.qtdRacaoDiaria;

    }

    public void setNomeCachorro(String nomeCachorro){
        this.nomeCachorro = nomeCachorro;

    }

    public void setNomeTutor(String nomeTutor){
        this.nomeTutor = nomeTutor;
    }

    public void setQtdRacaoDiaria(int qtdRacaoDiaria){
        this.qtdRacaoDiaria = qtdRacaoDiaria;
    }

    public void setRestricaoAlimentar(String restricaoAlimentar){
        this.restricaoAlimentar = restricaoAlimentar;
    }
}
