import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UrnaTeste {
    private Urna urna = new Urna();
//    @BeforeEach
//    public void inicializarUrna(){
//        Urna urna = new Urna();
//    }

    @Test
    public void testeCadastrarEleitorValido(){
        assertEquals("Eleitor Cadastrado corretamente", urna.cadastrarEleitor("123.456.789-00","Gabriel"));
    }

    @Test
    public void testeCadastrarEleitorCpfRepetido1(){
        urna.cadastrarEleitor("123.456.789-00","Lucas");
        assertEquals("Eleitor ja cadastrado", urna.cadastrarEleitor("123.456.789-00","Gabriel"));

    }

    @Test
    public void testeCadastrarEleitorCpfRepetido2(){
        urna.cadastrarEleitor("123.456.789-00","Gabriel");
        assertEquals("Eleitor ja cadastrado", urna.cadastrarEleitor("123.456.789-00","Gabriel"));

    }


    @Test
    public void testeCadastrarCandidatoValido(){
        assertTrue(urna.cadastrarCandidato("Gabriel"));
    }

    @Test
    public void testeCadastarCandidatoRepetido(){
        urna.cadastrarCandidato("Gabriel");
        assertFalse(urna.cadastrarCandidato("Gabriel"));
    }

    @Test
    public void testeIniciarVotacao(){
        urna.iniciarVotacao();
        assertEquals("Votação em andamento",urna.getStatusVotacao());
    }

    @Test
    public void testeIniciarVotacaoJaIniciada(){
        urna.iniciarVotacao();
        assertFalse(urna.iniciarVotacao());
    }

    @Test
    public void testeRegistrarVotoValido(){
        urna.cadastrarEleitor("000.000.000-00","Gabriel");
        urna.cadastrarCandidato("Paulo");
        urna.iniciarVotacao();
        assertEquals("Voto cadastrado corretamente",urna.registrarVoto("000.000.000-00","Paulo"));
    }

    @Test
    public void testeRegistrarVotoEleitorRepetido(){
        urna.cadastrarEleitor("000.000.000-00","Gabriel");
        urna.cadastrarCandidato("Paulo");
        urna.iniciarVotacao();
        urna.registrarVoto("000.000.000-00","Paulo");
        assertEquals("Eleitor já votou anteriormente - Voto desconsiderado",urna.registrarVoto("000.000.000-00","Paulo"));
    }






}
