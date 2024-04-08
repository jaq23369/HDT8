package uvg.edu.gt;

/**
 * Clase que representa a un paciente en un sistema de atención médica.
 * Cada paciente tiene un nombre, un síntoma y un código de emergencia.
 * Esta clase implementa la interfaz Comparable para permitir la comparación
 * de pacientes basada en su código de emergencia.
 */
public class Paciente implements Comparable<Paciente> {
    // Atributos privados para almacenar el nombre, el síntoma y el código de emergencia del paciente
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Constructor para crear una nueva instancia de un Paciente.
     *
     * @param nombre           El nombre del paciente.
     * @param sintoma          La descripción del síntoma del paciente.
     * @param codigoEmergencia El código de emergencia que representa la prioridad del paciente.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     *
     * @return La descripción del síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     *
     * @return El código de emergencia del paciente.
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara este paciente con otro para determinar el orden de prioridad.
     * La comparación se basa en los códigos de emergencia; los códigos más bajos
     * tienen mayor prioridad.
     *
     * @param otro El otro paciente con el que se compara.
     * @return Un valor negativo si este paciente tiene mayor prioridad,
     *         cero si tienen la misma prioridad, y un valor positivo si
     *         este paciente tiene menor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    /**
     * Proporciona una representación en cadena de un paciente, mostrando su nombre,
     * síntoma y código de emergencia.
     *
     * @return Una representación en cadena del paciente.
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}


