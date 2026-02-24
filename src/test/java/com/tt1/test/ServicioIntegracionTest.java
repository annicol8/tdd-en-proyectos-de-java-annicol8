package com.tt1.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import com.tt1.test.IRepositorio;

class ServicioIntegracionTest {
    private Servicio servicio;
    private Repositorio repositorio;
    private DBStub db;

    @BeforeEach
    void setUp() {
        db = new DBStub();
        repositorio = new Repositorio(db);
        servicio = new Servicio(repositorio, new MailerStub());
    }

    @Test
    void flujoCompletoCrearYCompletarTarea() {
        servicio.crearTarea("Integración", LocalDate.now().plusDays(3));
        servicio.marcarComoCompletada("Integración");
        assertTrue(servicio.listarPendientes().isEmpty());
    }

    @Test
    void flujoCompletoAgregarEmailYListar() {
        servicio.agregarEmail("user@test.com");
        servicio.crearTarea("Tarea", LocalDate.now().plusDays(1));
        assertEquals(1, servicio.listarPendientes().size());
    }
}