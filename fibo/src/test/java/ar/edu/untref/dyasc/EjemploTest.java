package ar.edu.untref.dyasc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EjemploTest {

    @Test
    public void pruebaDeEjemplo() {
        Ejemplo ejemplo = new Ejemplo();
        assertThat(ejemplo.saludar()).isEqualTo("Hola!");
    }

}
