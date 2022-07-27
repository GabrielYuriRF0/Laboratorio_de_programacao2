import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Classe responsável por testar as funções de cadastro de um contato
 * @author Gabriel Yuri Ramalho Ferreira
 */

  public class AgendaTest {
    private Agenda agenda;

    @BeforeEach
    public void inicializarAgenda(){
        agenda = new Agenda();
    }


    public void testePosicaoLimite1(){
        assertTrue(agenda.cadastraContato(1,"Gabriel","Yuri","400028922"));
    }

    @Test
    public void testePosicaoLimite2(){
        assertTrue(agenda.cadastraContato(100,"Gabriel","Yuri","400028922"));
    }

    @Test
    public void testePosicaoInvalida1(){
        assertFalse(agenda.cadastraContato(-1,"Gabriel","Yuri","400028922"));

    }

    @Test
    public void testePosicaoInvalida2(){
        assertFalse(agenda.cadastraContato(101,"Gabriel","Yuri","400028922"));

    }

    @Test
    public void testeNomeRepetido1(){
        agenda.cadastraContato(1,"Fabio","Morais","40028922");
        assertFalse(agenda.cadastraContato(1,"Fabio","Morais","400028922"));

    }
    @Test
    public void testeNomeRepetido2(){
        agenda.cadastraContato(1,"Fabio","Morais","40028922");
        assertFalse(agenda.cadastraContato(10,"Fabio","Morais","400028922"));

    }

    @Test
    public void testeNomeVazio(){
        assertFalse(agenda.cadastraContato(1,"","Yuri","400028922"));

    }
    @Test
    public void testeTelefoneVazio(){
        assertFalse(agenda.cadastraContato(1,"Gabriel","Yuri",""));

    }

    @Test
    public void testeCadastraContatoRepetido(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        assertEquals(false, agenda.cadastraContato(2,"gabriel","yuri","40028922"));
    }

    @Test
    public void testeExibirContatoLimite1(){
        assertNotEquals("POSIÇÃO INVÁLIDA", agenda.getContato(1));

    }

    @Test
    public void testeExibirContatoLimite2(){
        assertNotEquals("POSIÇÃO INVÁLIDA", agenda.getContato(100));

    }
    @Test
    public void testeExibirContatoLimite3(){
        assertNotEquals("POSIÇÃO INVÁLIDA", agenda.getContato(2));

    }
    @Test
    public void testeExibirContatoLimite4(){
        assertNotEquals("POSIÇÃO INVÁLIDA", agenda.getContato(99));

    }

    @Test
    public void testeExibirContatoInvalido1(){
        assertEquals("POSIÇÃO INVÁLIDA", agenda.getContato(0));

    }
    @Test
    public void testeExibirContatoInvalido2(){
        assertEquals("POSIÇÃO INVÁLIDA", agenda.getContato(101));

    }

    @Test
    public void testeCadastrarFavoritoRepetido1(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        agenda.adicionarFavorito(1,1);
        assertEquals("Contato já favoritado!",agenda.adicionarFavorito(1,1));
    }

    @Test
    public void testeCadastrarFavoritoRepetido2(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        agenda.adicionarFavorito(1,1);
        assertEquals("Contato já favoritado!",agenda.adicionarFavorito(1,2));
    }


    @Test
    public void testeAdicionarFavoritoInvalido1(){
        assertEquals("Posição inválida!", agenda.adicionarFavorito(0,1));
    }
    @Test
    public void testeAdicionarFavoritoInvalido2(){
        assertEquals("Posição inválida!", agenda.adicionarFavorito(101,1));
    }

    @Test
    public void testeAdicionarFavoritoInvalido3(){
        assertEquals("Posição inválida!", agenda.adicionarFavorito(1,0));
    }
    @Test
    public void testeAdicionarFavoritoInvalido4(){
        assertEquals("Posição inválida!", agenda.adicionarFavorito(1,101));
    }

    @Test
    public void testeAdicionarFavoritoInvalido5(){
        assertEquals("Posição inválida!", agenda.adicionarFavorito(0,0));
    }

    @Test
    public void testeAdicionarPosicaoTagInválida1(){
        int[] posicaoContatos = {1};
        assertEquals("Posição da tag inválida!", agenda.adicionarTag(posicaoContatos,"ccc",0));
    }

    @Test
    public void testeAdicionarPosicaoTagInválida2(){
        int[] posicaoContatos = {1};
        assertEquals("Posição da tag inválida!", agenda.adicionarTag(posicaoContatos,"ccc",6));
    }
    @Test
    public void testeAdicionarTagContatoInválido1(){
        int[] posicaoContatos = {0,1,2};
        assertEquals("Posição inválida!",agenda.adicionarTag(posicaoContatos,"ccc",1));


    }
    @Test
    public void testeAdicionarTagContatoInválido2(){
        int[] posicaoContatos = {1,2,55,101};
        assertEquals("Posição inválida!",agenda.adicionarTag(posicaoContatos,"ccc",1));


    }

    @Test
    public void testeAdicionarTagContatoInválido3(){
        int[] posicaoContatos = {1,2,400,100,55};
        assertEquals("Posição inválida!",agenda.adicionarTag(posicaoContatos,"ccc",1));

    }

    @Test
    public void testeRemoverContatoInvalido1(){
        int[] posicoesContatos = {0,1,2,3,4};
        assertEquals("Posição inválida!",agenda.removerContato(posicoesContatos));
    }

    @Test
    public void testeRemoverContatoInvalido2(){
        int[] posicoesContatos = {1,2,3,101};
        assertEquals("Posição inválida!",agenda.removerContato(posicoesContatos));
    }

    @Test
    public void testeRemoverContatoInvalido3(){
        int[] posicoesContatos = {1,2,-5,4,10};
        assertEquals("Posição inválida!",agenda.removerContato(posicoesContatos));
    }
    @Test
    public void testeRemoverContatoInvalido4(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        int[] posicoesContatos = {1};
        agenda.removerContato(posicoesContatos);
        assertEquals("Posição inválida!",agenda.removerContato(posicoesContatos));
    }

    @Test
    public void testeRemoverContatosMultiplos(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        agenda.cadastraContato(2,"Arthur","vinicius","40028922");
        int[] posicoesContatos = {1,2};
        assertEquals("Remoção concluída!",agenda.removerContato(posicoesContatos));

    }

    }
