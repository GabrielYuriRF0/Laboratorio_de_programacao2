
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface que vai interagir com o usuário e permitir
 * a manipulação de todos os contatos
 *
 * @author Gabriel Yuri Ramalho Ferreira
 *
 */
public class MainAgenda {
    /**
     * Método principal a ser executado na classe.
     * @param args
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        System.out.println("Carregando agenda inicial");
        try {
            /*
             * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
             */
            carregaAgenda("agenda_inicial.csv", agenda);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, agenda, scanner);
        }

    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(C)adastrar Contato\n" +
                        "(L)istar Contatos\n" +
                        "(LN)Listar Contatos Pelo Nome e Sobrenome\n" +
                        "(LT)Listar Contatos Pela Tag\n"+
                        "(E)xibir Contato\n" +
                        "(F)avoritos\n" +
                        "(A)dicionar Favorito\n" +
                        "(T)ags\n" +
                        "(R)emover Contato\n" +
                        "(M)udar Telefone\n" +
                        "(RT)Remover Tag\n" +
                        "(RF)Remover favorito\n" +
                        "(S)air\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param opcao   Opção digitada.
     * @param agenda  A agenda que estamos manipulando.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void comando(String opcao, Agenda agenda, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastraContato(agenda, scanner);
                break;
            case "L":
                listaContatos(agenda);
                break;


            case "LN":
                consultaNomeSobrenome(agenda, scanner);
                break;

            case "LT":
                consultaTag(agenda, scanner);
                break;

            case "E":
                exibeContato(agenda, scanner);
                break;

            case "F":
               agenda.listarFavoritos();
                break;

            case "A":
                adicionarFavorito(agenda, scanner);
                break;


            case "T":
                adicionarTag(agenda,scanner);
                break;


            case "R":
                removerContato(agenda, scanner);
                break;

            case "M":
                mudarTelefone(agenda, scanner);
                break;

            case "RT":
                removerTag(agenda, scanner);
                break;

            case "RF":
                removerFavorito(agenda, scanner);
                break;




            case "S":
                sai();
                break;



            default:
                System.out.println("Opção inválida!");
        }
    }

    /**
     * Imprime lista de contatos da agenda.
     *
     * @param agenda A agenda sendo manipulada.
     */
    private static void listaContatos(Agenda agenda) {
        System.out.println("\nLista de contatos: ");
        Contato contatos[] = agenda.getContatos();
        for (int i = 0; i < contatos.length; i++) {
            if (!(contatos[i].getNome().isEmpty()) && contatos[i].getEstaDeletado() == false) {
                System.out.println(i+1 + " - " + contatos[i].getEmoji() + " " + contatos[i].getNome() + " " + contatos[i].getSobrenome());
            }
        }
    }

    /**
     * Imprime os detalhes de um dos contatos da agenda.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para capturar qual contato.
     */
    private static void exibeContato(Agenda agenda, Scanner scanner) {
        System.out.print("\nQual contato> ");
        int posicao = scanner.nextInt();
        System.out.println(agenda.getContato(posicao));
    }

    /**
     * Formata um contato para impressão na interface.
     *
     * @param posicao A posição do contato (que é exibida)/
     * @param contato O contato a ser impresso.
     * @return A String formatada.
     */
    private static String formataContato(int posicao, Contato contato) {
        return posicao + " - " + contato;
    }

    /**
     * Cadastra um contato na agenda.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir informações do contato.
     */
    private static void cadastraContato(Agenda agenda, Scanner scanner) {
        boolean jaCastrado = false;

        System.out.print("\nPosição na agenda> ");
        int posicao = scanner.nextInt();
        scanner.nextLine();

        if (agenda.validarPosicaoContato(posicao) == false) {
            System.out.println("POSIÇÃO INVÁLIDA");

        } else {
            System.out.print("\nNome> ");
            String nome = scanner.nextLine();

            // Verificando se o nome está null ou vázio:
            if (agenda.validarNomeTelefone(nome) == false) {
                System.out.println("CONTATO INVÁLIDO");

            } else {
                System.out.print("\nSobrenome> ");
                String sobrenome = scanner.next();


                // Verifcar se o nome e sobrenome já estão cadastrados
                for (int i = 0; i < 100; i++) {
                    if (nome.equals(agenda.getContatos()[i].getNome()) && sobrenome.equals(agenda.getContatos()[i].getSobrenome())) {
                        System.out.println("CONTATO JÁ CADASTRADO");
                        jaCastrado = true;

                        break;
                    }
                }
                if (jaCastrado == false) {
                    scanner.nextLine();
                    System.out.println("\nTelefone> ");
                    String telefone = scanner.nextLine();

                    // Verificando se o telefone é vázio
                    if (agenda.validarNomeTelefone(telefone) == false) {
                        System.out.println("TELEFONE INVÁLIDO");


                    } else {
                        agenda.cadastraContato(posicao, nome, sobrenome, telefone);
                        System.out.println("CADASTRO REALIZADO COM SUCESSO!");


                    }

                }

            }

        }
    }


    /**
     *  Recebe dados do contato e caso os dados sejam válidos
     *  adicionar ele no array de favoritos.
     *
     * @param agenda A agenda
     * @param scanner Scanner para pedir as informações do contato.
     */
    private static void adicionarFavorito(Agenda agenda, Scanner scanner){
        System.out.print("Contato>");
        int posicaoContato = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Posição>");
        int posicaoFavorito = scanner.nextInt();



        System.out.println(agenda.adicionarFavorito(posicaoContato,posicaoFavorito));




    }

    /**
     * Adiciona uma determinada tag em um ou mais contatos.
     *
     * @param agenda A agenda
     * @param scanner Scanner para pedir as informações
     */
    private static void adicionarTag(Agenda agenda, Scanner scanner){
        String numerosString = new String();
        String tag;
        int posicaoTag;

        System.out.print("Contato(s) > ");
        numerosString = scanner.next();

        String[] numerosStringSplit = numerosString.split("-");

        int[] posicoesContatos = new int[numerosStringSplit.length];



        for(int i = 0; i < posicoesContatos.length; i++){
            posicoesContatos[i] = Integer.parseInt(numerosStringSplit[i]);
        }

        System.out.print("Tag> ");
        tag = scanner.next();
        System.out.print("Posição tag> ");
        posicaoTag = scanner.nextInt();
        scanner.nextLine();

        agenda.adicionarTag(posicoesContatos, tag, posicaoTag);



    }

    /**
     *  Remove um ou mais contatos da agenda, através da posição.
     * @param agenda A agenda.
     * @param scanner Scanner para pedir as informações.
     */
    private static void removerContato(Agenda agenda, Scanner scanner){
        String contatosString;

        System.out.print("Contato(s) > ");
        contatosString = scanner.next();

        String[] contatosStringSplit = contatosString.split("-");
        int[] contatosInt = new int[contatosStringSplit.length];


        for(int i = 0; i < contatosInt.length; i++){
            contatosInt[i] = Integer.parseInt(contatosStringSplit[i]);
        }


        System.out.println(agenda.removerContato(contatosInt));


    }

    /**
     * Mudar o telefone de um contato, informando a sua posição
     * e o novo número desejado.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir as informações.
     */
    private static void mudarTelefone(Agenda agenda,Scanner scanner){
        System.out.print("Digite a posição do contato na agenda: ");
        int posicaoContato = scanner.nextInt();

        while(agenda.validarPosicaoContato(posicaoContato) == false || agenda.validarContato(posicaoContato) == false){
            System.out.println("Posição inválida, digite novamente: ");
            posicaoContato = scanner.nextInt();
        }



        System.out.print("Digite o novo número de telefone: ");
        String novoTelefone = scanner.next();

        while(agenda.validarNomeTelefone(novoTelefone) == false){
            System.out.println("Telefone inválido, digite novamente: ");
            novoTelefone = scanner.next();
        }
        agenda.modificarTelefone(posicaoContato,novoTelefone);
    }


    /**
     * Remove uma tag de um contato.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir as informações.
     */
    private static void removerTag(Agenda agenda, Scanner scanner){
        System.out.print("Digite o contato que você deseja remover uma tag: ");
        int posicaoContato = scanner.nextInt();

        while(agenda.validarPosicaoContato(posicaoContato) == false || agenda.validarContato(posicaoContato) == false){
            System.out.println("Posição inválida, digite novamente: ");
            posicaoContato = scanner.nextInt();
        }
        scanner.nextLine();

        if(agenda.contatoTemTag(posicaoContato)){
            System.out.print("Digite a posição da tag que deseja remover: ");
            int posicaoTag = scanner.nextInt();
            agenda.removerTag(posicaoContato, posicaoTag);
        }
        else{
            System.out.println("Não foi possível remover a tag!");
        }




    }

    /**
     * Remove um contato da lista de favoritos através do seu nome e sobrenome.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir inforamções.
     */
    private static void removerFavorito(Agenda agenda, Scanner scanner){
        System.out.print("Digite o nome do contato que deseja remover: ");
        String nome = scanner.next();
        System.out.println("Digite o sobrenome do contato que deseja remover: ");
        String sobrenome = scanner.next();

        agenda.removerFavorito(nome, sobrenome);

    }

    /**
     *  Lista todos os contatos que possuem determinado nome ou sobrenome.
     *
     * @param agenda a agenda.
     * @param scanner Scanner para pedir informações.
     */
    private static void consultaNomeSobrenome(Agenda agenda, Scanner scanner){

        System.out.print("Digite um nome ou sobrenome para exibir todos os contatos que possuem ele: ");
        String nome = scanner.next();

        if(agenda.consultaNomeSobrenome(nome) == null){
            System.out.println("Nome inválido");

        }
        else{
            ArrayList <Contato> listaContatos = agenda.consultaNomeSobrenome(nome);
            for(int i = 0; i < listaContatos.size(); i++){
                System.out.println((i + 1) +" - " + listaContatos.get(i).toString());
                System.out.println("");
            }
        }
    }

    /**
     * Lista todos os contatos que possuem determinada tag.
     *
     * @param agenda A agenda.
     * @param scanner Scanner para pedir informações
     */
    private static void consultaTag(Agenda agenda, Scanner scanner){
        System.out.print("Digite uma tag para pesquisar um contato: ");
        String tag = scanner.next();


        if(agenda.consultaPelaTag(tag) == null){
            System.out.println("Contato não encontrado ou tag inválida");
        }
        else{
            ArrayList<Contato> listaContatos = agenda.consultaPelaTag(tag);
            for(int i = 0; i < listaContatos.size(); i++){
                System.out.println((i + 1) +" - " + listaContatos.get(i).toString());
                System.out.println("");

            }
        }



    }










    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }

    /**
     * Lê uma agenda de um arquivo csv.
     *
     * @param arquivoContatos O caminho para o arquivo.
     * @param agenda A agenda que deve ser populada com os dados.
     * @throws IOException Caso o arquivo não exista ou não possa ser lido.
     */
    private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
        LeitorDeAgenda leitor = new LeitorDeAgenda();

        int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}
