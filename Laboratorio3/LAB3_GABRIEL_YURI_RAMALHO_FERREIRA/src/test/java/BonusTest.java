import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BonusTest {
    private Agenda agenda;

    @BeforeEach
    public void inicializarAgenda(){
        agenda = new Agenda();
    }

    @Test
    public void testNomeNull() {
        try {
            Contato contatoInvalido = new Contato(null, "Yuri", "40028922");

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());

        }
    }
    @Test
    public void testSobrenomeNull() {
        try {
            Contato contatoInvalido = new Contato("Gabriel", null, "40028922");

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());

        }
    }
    @Test
    public void testTelefoneNull() {
        try {
            Contato contatoInvalido = new Contato("Gabriel", "Yuri", null);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());

        }
    }

    @Test
    public void testeNomeVazio() {
        try{
            Contato contatoInvalido = new Contato("", "Yuri", "40028922");
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }

    @Test
    public void testeNomeEspacos(){
        try{
            Contato contatoInvalido = new Contato("     ", "Yuri", "40028922");
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }


    @Test
    public void testeModificarTelefoneContantoInvalido1(){
        assertFalse(agenda.modificarTelefone(0,"400288922"));

    }

    @Test
    public void testeModificarTelefoneContantoInvalido2(){
        assertFalse(agenda.modificarTelefone(101,"400288922"));

    }

    @Test
    public void testeModificarTelefoneContatoLimite1(){
        agenda.cadastraContato(1,"Gabriel","yuri","555555");
        assertTrue(agenda.modificarTelefone(1,"40028922"));
    }

    @Test
    public void testeModificarTelefoneContatoLimite2(){
        agenda.cadastraContato(100,"gabriel","yuri","555555");
        assertTrue(agenda.modificarTelefone(100,"40028922"));
    }

    @Test
    public void testeModificarTelefoneVazio(){
        assertFalse(agenda.modificarTelefone(1,""));
    }
    @Test
    public void testeModificarTelefoneNulo(){
        assertFalse(agenda.modificarTelefone(1,null));
    }
    @Test
    public void testeModificarTelefoneEspaco(){
        assertFalse(agenda.modificarTelefone(1,"     "));
    }

//    @Test
//    public void testeRemoverTagContatoLimite1(){
//        int[] posicoes = {1};
//        agenda.cadastraContato(1,"gabriel","yuri","40028922");
//        agenda.adicionarTag(posicoes, "ccc", 1);
//        assertTrue(agenda.removerTag(1 ,1));
//
//    }

    @Test
    public void testeRemoverFavorito1(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        agenda.adicionarFavorito(1,1);
        assertTrue(agenda.removerFavorito("gabriel","yuri"));
    }

    @Test
    public void testeRemoverFavorito2(){
        agenda.cadastraContato(100,"gabriel","yuri","40028922");
        agenda.adicionarFavorito(100,1);
        assertTrue(agenda.removerFavorito("gabriel","yuri"));
    }

    @Test
    public void testeRemoverFavoritoInexistente(){
        agenda.cadastraContato(100,"gabriel","yuri","40028922");
        assertFalse(agenda.removerFavorito("gabriel","yuri"));
    }

    @Test
    public void testeListarContatosPeloNome(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        agenda.cadastraContato(2,"gabriel","pato","40028922");
        agenda.cadastraContato(3,"gabriel","lins","40028922");

        assertEquals(3,agenda.consultaNomeSobrenome("gabriel").size());
    }
    @Test
    public void testeListarContatosPeloSobrenome(){
        agenda.cadastraContato(1,"Lucas","Sousa","40028922");
        agenda.cadastraContato(2,"Thiago","Sousa","40028922");
        agenda.cadastraContato(3,"Pedro","Sousa","40028922");

        assertEquals(3,agenda.consultaNomeSobrenome("Sousa").size());
    }

    @Test
    public void testeListarContatoTag(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        int[] posicao = {1};
        agenda.adicionarTag(posicao,"ccc",1);
        assertEquals(1,agenda.consultaPelaTag("ccc").size());

    }
    @Test
    public void testeListarContatosTag(){
        agenda.cadastraContato(1,"gabriel","yuri","40028922");
        agenda.cadastraContato(2,"Rodrigo","Ramalho","40028922");
        agenda.cadastraContato(3,"Lucas","Ferreira","40028922");

        int[] posicao = {1,2,3};
        agenda.adicionarTag(posicao,"ccc",1);
        assertEquals(3,agenda.consultaPelaTag("ccc").size());

    }

}
