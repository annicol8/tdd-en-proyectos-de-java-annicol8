package com.tt1.test;

public class Repositorio {
    private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    public ToDo encontrarTarea(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void guardarTarea(ToDo tarea) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void marcarComoCompletada(String nombre) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }

    public void guardarEmail(String email) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}