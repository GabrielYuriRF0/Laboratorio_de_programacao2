import java.util.Locale;

public class DogHost {
    private String nomeHost;
    private int maximoCachorro;
    private int maximoRacao;
    private Cachorro cachorros[];

    private int racaoRestante = maximoRacao;
    private int qtdCachorros;


    public DogHost(String nomeHost, int maximoCachorro, int maximoRacao){
        this.nomeHost = nomeHost;
        this.maximoCachorro = maximoCachorro;
        this.maximoRacao = maximoRacao;
        cachorros = new Cachorro[maximoCachorro];

    }

    public boolean adicionaDog(String nomeCachorro, String nomeTutor, int qtdRacao){
        boolean cachorroAdicionado = false;
        if(racaoRestante != 0){
            //Laço para verificar uma posição vázia no array de cachorros
            for(int i = 0; i < maximoCachorro; i++){
                if(cachorros[i] != null){
                    cachorros[i].setNomeCachorro(nomeCachorro);
                    cachorros[i].setNomeTutor(nomeTutor);
                    cachorros[i].setQtdRacaoDiaria(qtdRacao);
                    racaoRestante -= cachorros[i].getQtdRacaoDiaria();
                    cachorroAdicionado = true;
                    qtdCachorros++;
                    break;
                }

            }


        }
        return cachorroAdicionado;

    }
    public boolean adicionaDog(String nomeCachorro, String nomeTutor, int qtdRacao, String tipoRestricao){
        boolean cachorroAdicionado = false;

        if(racaoRestante != 0){
            //Laço para verificar uma posição vázia no array de cachorros
            for(int i = 0; i < maximoCachorro; i++){
                if(cachorros[i] != null){
                    cachorros[i].setNomeCachorro(nomeCachorro);
                    cachorros[i].setNomeTutor(nomeTutor);
                    cachorros[i].setQtdRacaoDiaria(qtdRacao);
                    racaoRestante -= cachorros[i].getQtdRacaoDiaria();
                    cachorroAdicionado = true;
                    qtdCachorros++;
                    break;
                }

            }

        }
        return cachorroAdicionado;


    }

    public String listaDogs(){
        String listaCachorros = this.nomeHost;

        for(int i = 0; cachorros[i] != null; i++){
            listaCachorros += cachorros[i].toString() + "\n";

        }
        return  listaCachorros;

    }

    public double consultaValorHospedagem(Cachorro cachorro, int dias){
        //Verificar se o cachorro fornecido está em DogHost
        for(int i = 0; cachorros[i].equals(cachorro); i++){

        }


    }


}
