import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EleitorTeste {
    @Test
    public void testeConstrutor(){
        Eleitor eleitor = new Eleitor("123.456.789-00","Gabriel");
        assertEquals("123.456.789-00",eleitor.getCpf());
        assertEquals("Gabriel",eleitor.getNome());
    }



}
