package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {
    
    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testAdd() {
        Paciente paciente1 = new Paciente("Juan Perez", "fractura de pierna", 'C');
        Paciente paciente2 = new Paciente("Maria Ramirez", "apendicitis", 'A');
        heap.add(paciente1);
        heap.add(paciente2);
        // La prueba asume que el paciente con mayor prioridad (A) debe ser el primero
        assertEquals("El paciente con la emergencia más alta debe ser 'Maria Ramirez'", paciente2, heap.peek());
    }

    @Test
    public void testRemove() {
        Paciente paciente1 = new Paciente("Juan Perez", "fractura de pierna", 'C');
        Paciente paciente2 = new Paciente("Maria Ramirez", "apendicitis", 'A');
        heap.add(paciente1);
        heap.add(paciente2);
        // Retira el paciente con la emergencia más alta y verifica que sea el correcto
        assertEquals("El paciente atendido debe ser 'Maria Ramirez'", paciente2, heap.remove());
        // Asegúrate de que el siguiente en la cola sea el correcto después de remover
        assertEquals("El siguiente paciente debe ser 'Juan Perez'", paciente1, heap.remove());
    }
}
