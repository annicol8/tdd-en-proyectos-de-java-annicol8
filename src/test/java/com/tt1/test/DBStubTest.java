package com.tt1.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class DBStubTest {
    private DBStub db;

    @BeforeEach
    void setUp() {
        db = new DBStub();
    }

    @Test
    void agregarYBuscarTarea() {
        ToDo tarea = new ToDo("Estudiar", "Java", LocalDate.now());
        db.agregarTarea(tarea);
        assertEquals(tarea, db.buscarPorNombre("Estudiar"));
    }

    @Test
    void buscarTareaInexistenteDevuelveNull() {
        assertNull(db.buscarPorNombre("NoExiste"));
    }

    @Test
    void marcarComoCompletada() {
        db.agregarTarea(new ToDo("Estudiar", "Java", LocalDate.now()));
        db.marcarComoCompletada("Estudiar");
        assertTrue(db.buscarPorNombre("Estudiar").isCompletado());
    }

    @Test
    void agregarYObtenerEmails() {
        db.agregarEmail("test@test.com");
        assertTrue(db.obtenerEmails().contains("test@test.com"));
    }
}