import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CandidatoTeste {
    @Test
    public void testeConstrutor(){
        Candidato candidato = new Candidato("Chico",0,0);
        assertEquals("Chico",candidato.getNome());
    }
}
