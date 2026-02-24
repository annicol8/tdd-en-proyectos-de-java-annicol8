package com.tt1.test;

import java.util.List;
import java.util.stream.Collectors;

public class Repositorio implements IRepositorio {
    private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    @Override
    public ToDo encontrarTarea(String nombre) {
        return db.buscarPorNombre(nombre);
    }

    @Override
    public void guardarTarea(ToDo tarea) {
        db.agregarTarea(tarea);
    }

    @Override
    public void marcarComoCompletada(String nombre) {
        db.marcarComoCompletada(nombre);
    }

    @Override
    public void guardarEmail(String email) {
        db.agregarEmail(email);
    }

    @Override
    public List<ToDo> obtenerPendientes() {
        return db.obtenerTodas().stream()
            .filter(t -> !t.isCompletado())
            .collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerEmails() {
        return db.obtenerEmails();
    }
}