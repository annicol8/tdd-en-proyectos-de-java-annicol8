package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    // CREATE
    public void agregarTarea(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    // READ
    public List<ToDo> obtenerTodas() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public ToDo buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    // UPDATE
    public void marcarComoCompletada(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    // DELETE
    public void eliminarTarea(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    // Emails
    public void agregarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public List<String> obtenerEmails() {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}