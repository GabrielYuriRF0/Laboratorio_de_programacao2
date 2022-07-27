import java.util.ArrayList;

public class Urna {
    private Eleitor[] eleitores = new Eleitor[10];
    private Candidato[] candidatos = new Candidato[6]; // 1 Posição para nulo e 1 posição para branco

    private ArrayList<String> eleitoresCadastrados = new ArrayList<String>();
    private ArrayList<String> candidatosCadastrados = new ArrayList<String>();
    private ArrayList<Eleitor> eleitoresQuites = new ArrayList<Eleitor>();
    private String statusVotacao;
    private int totalVotos;

    public Urna(){
        //Inicializar eleitores
        for(int i = 0; i < eleitores.length; i++){
            eleitores[i] = new Eleitor("","");
        }

        //Inicalizar  cadidatos
        for(int i = 0; i < candidatos.length; i++){
            candidatos[i] = new Candidato("",0,0);
        }
        this.statusVotacao = "Votacão não iniciada";
        this.totalVotos = 0;
    }




    public String cadastrarEleitor(String cpf, String nome){
        if(estaCadastrado(cpf,"Eleitor")){
            return "Eleitor ja cadastrado";
        }

        else{
            for(int i = 0; i < eleitores.length; i++){
                if(eleitores[i].getNome().isEmpty()){
                    eleitores[i] = new Eleitor(cpf,nome);
                    eleitoresCadastrados.add(eleitores[i].getNome());
                    return "Eleitor Cadastrado corretamente";
                }
            }

        }

        return "Eleitor não cadastrado";

    }

    public boolean cadastrarCandidato(String nome){
        if(estaCadastrado(nome,"Candidato")){
            return false;
        }
        else{
            // Verificando se o candidato já está cadastrado no sistema
            if(candidatosCadastrados.isEmpty() == false){
                for(String nomeCandidato: candidatosCadastrados){
                    if(nomeCandidato.equals(nome)){
                        return  false;

                    }

                }


            }

        }

        for(int i = 0; i < candidatos.length; i++){
            if(candidatos[i].getNome().isEmpty()){
                candidatos[i] = new Candidato(nome,i + 1, 0);
                candidatosCadastrados.add(candidatos[i].getNome());
                break;
            }
        }
        return true;
    }

    public boolean iniciarVotacao(){
        if(statusVotacao.equals("Votacão não iniciada")){
            this.statusVotacao = "Votação em andamento";


            //Zerar os votos dos candidatos
            for(int i = 0; i < candidatos.length;i++){
                candidatos[i].zerarVotos();
            }

            // Atribuir falso no status de votação de cada eleitor:
            for(int i = 0; i < eleitores.length; i++){
                eleitores[i].setStatusVotacao(false);
            }
            return true;

        }
        return false;



    }

    public void fecharVotacao(){
        if(statusVotacao.equals("Votação em andamento")){
            this.statusVotacao = "Votação encerrada";

        }

    }

    public void exibirRelatorio(){
        System.out.print("---------- Urna ----------\n" +
                "Eleitores Permitidos: 10\n" +
                "Quantidade de Candidatos Permitidos: 4\n" +
                this.statusVotacao + "\n" +
                "Quantidade de votos depositados: " + this.totalVotos);

        System.out.print("---------- Candidadatos ----------");
        for(int i = 0; i < candidatos.length; i++){
            System.out.print(candidatos[i].toString());
        }

        System.out.print("---------- Eleitores ----------");
        for(int i = 0; i < eleitores.length; i++){
            System.out.print(eleitores[i].toString());

        }




    }

    public boolean exibirBoletim(){
        if(this.statusVotacao.equals("Votação encerrada") == false){
            return  false;
        }
        else{
            System.out.print("---------- Urna ----------\n" +
                    toString()+ "\n");

            System.out.print("---------- Candidatos ----------\n");
            for(int i = 0; i < candidatos.length; i++){
                System.out.println(candidatos[i].toString());
            }
            return true;
        }

    }

    public String registrarVoto(String identificacao, String nomeCandidato){
        if(statusVotacao.equals("Votacão não iniciada")){
            return "Votação não iniciada";
        }

        else if(candidatoJaVotou(identificacao)){
            return "Eleitor já votou anteriormente - Voto desconsiderado";
        }
        else if(estaCadastrado(identificacao,"Eleitor") == false){
            return "Eleitor não cadastrado";
        }

        else if(estaCadastrado(nomeCandidato,"Candidato")){
            for(int i = 0; i < candidatos.length; i++){
                if(candidatos[i].getNome().equals(nomeCandidato)){
                    candidatos[i].adicionarVoto();

                    for(int j = 0; j < eleitores.length; j++){
                        if(eleitores[j].getCpf().equals(identificacao)){
                            eleitores[j].setStatusVotacao(true);
                            totalVotos++;
                            break;

                        }
                    }
                    return "Voto cadastrado corretamente";
                }
            }


        }
        return "Candidato não cadastrado - Voto não Cadastrado";

    }

    public boolean estaCadastrado(String identificador, String tipo){
        if(tipo.equals("Candidato")){
            for(String nomeCandidato: candidatosCadastrados){
                if(nomeCandidato.equals(identificador)){
                    return true;

                }
            }

        }
        else{
            for(int i = 0; i < eleitores.length; i++){
                if(eleitores[i].getCpf().equals(identificador)){
                    return true;
                }
            }

        }

        return false;
    }

    public boolean candidatoJaVotou(String cpf){
       for(int i = 0; i < eleitores.length; i++){
           if(eleitores[i].getCpf().equals(cpf)){
               eleitores[i].setStatusVotacao(true);
               return true;
           }
       }
       return false;
    }

    public int eleitoresFaltantes(){
        int eleitoresFaltantes = 0;
        for(int i = 0; i < eleitores.length; i++){
            if(eleitores[i].getStatusVotacao() == false){
                eleitoresFaltantes++;
            }
        }
        return  eleitoresFaltantes;
    }

    public Candidato calcularVencedor(){
        Candidato vencedorAtual = candidatos[0];
        for(int i = 1; i < candidatos.length; i++){
            if(candidatos[i].getQuantidadeVotos() > vencedorAtual.getQuantidadeVotos()){
                vencedorAtual = candidatos[i];
            }

        }
        return vencedorAtual;

    }
    public String exibirVencedor(){
        if(this.statusVotacao.equals("Votação em andamento")){
            return "Votação ainda não foi encerrada";
        }
        else{
            return calcularVencedor().toString();

        }
    }

      @Override
    public String toString(){
        return "Quantidade de eleitores permitidos: 10\nQuantidade de candidatos permitidos: 4\n" +
                this.statusVotacao + " -  Quantidade de votos depositados: " + totalVotos;

    }

    public String getStatusVotacao(){
        return  this.statusVotacao;
    }

}
