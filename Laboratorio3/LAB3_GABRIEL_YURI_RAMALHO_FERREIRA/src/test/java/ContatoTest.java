import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContatoTest {
    @Test
    public void testeCriarContatoValido(){
        Contato contato = new Contato("Gabriel","Yuri","40028922");
        assertEquals("Gabriel",contato.getNome());
        assertEquals("Yuri",contato.getSobrenome());
        assertEquals("40028922",contato.getTelefone());
    }

    @Test
    public void testeCriarContatoSemSobrenome(){
        Contato contato = new Contato("Gabriel","","40028922");
        assertEquals("Gabriel",contato.getNome());
        assertEquals("",contato.getSobrenome());
        assertEquals("40028922",contato.getTelefone());
    }




}
