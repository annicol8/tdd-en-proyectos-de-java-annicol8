package com.tt1.test.mock;

import com.tt1.test.*;
import java.util.*;

public class RepositorioMock implements IRepositorio {
    public List<ToDo> tareas = new ArrayList<>();
    public List<String> emails = new ArrayList<>();

    @Override public void guardarTarea(ToDo tarea) { tareas.add(tarea); }
    @Override public ToDo encontrarTarea(String nombre) {
        return tareas.stream().filter(t -> t.getNombre().equals(nombre)).findFirst().orElse(null);
    }
    @Override public void marcarComoCompletada(String nombre) {
        tareas.stream().filter(t -> t.getNombre().equals(nombre)).forEach(t -> t.setCompletado(true));
    }
    @Override public void guardarEmail(String email) { emails.add(email); }
    @Override public List<ToDo> obtenerPendientes() {
        return tareas.stream().filter(t -> !t.isCompletado()).toList();
    }
    @Override public List<String> obtenerEmails() { return emails; }
}