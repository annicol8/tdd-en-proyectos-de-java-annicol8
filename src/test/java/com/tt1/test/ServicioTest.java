package com.tt1.test;

import com.tt1.test.mock.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class ServicioTest {
    private Servicio servicio;
    private RepositorioMock repoMock;
    private MailerMock mailerMock;

    @BeforeEach
    void setUp() {
        repoMock = new RepositorioMock();
        mailerMock = new MailerMock();
        servicio = new Servicio(repoMock, mailerMock);
    }

    @Test
    void crearTareaSeGuardaEnRepositorio() {
        servicio.crearTarea("Tarea1", LocalDate.now().plusDays(5));
        assertEquals(1, repoMock.tareas.size());
    }

    @Test
    void crearTareaConNombreVacioLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> servicio.crearTarea("", LocalDate.now()));
    }

    @Test
    void agregarEmailInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
            () -> servicio.agregarEmail("correo-sin-arroba"));
    }

    @Test
    void tareaVencidaEnviaCorreo() {
        repoMock.emails.add("alerta@test.com");
        servicio.crearTarea("Vencida", LocalDate.now().minusDays(1));
        assertTrue(mailerMock.vecesLlamado > 0);
    }

    @Test
    void listarPendientesNoDevuelveCompletadas() {
        servicio.crearTarea("Tarea1", LocalDate.now().plusDays(5));
        servicio.marcarComoCompletada("Tarea1");
        assertTrue(servicio.listarPendientes().isEmpty());
    }
}