package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    public void agregarTarea(ToDo tarea) {
        tareas.add(tarea);
    }

    public List<ToDo> obtenerTodas() {
        return tareas;
    }

    public ToDo buscarPorNombre(String nombre) {
        return tareas.stream()
            .filter(t -> t.getNombre().equals(nombre))
            .findFirst()
            .orElse(null);
    }

    public void marcarComoCompletada(String nombre) {
        ToDo tarea = buscarPorNombre(nombre);
        if (tarea != null) tarea.setCompletado(true);
    }

    public void agregarEmail(String email) {
        emails.add(email);
    }

    public List<String> obtenerEmails() {
        return emails;
    }
}