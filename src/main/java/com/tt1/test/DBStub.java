package com.tt1.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación simulada de base de datos para uso en desarrollo.
 * Almacena tareas y emails en memoria mediante listas,
 * sin necesidad de una base de datos real.
 *
 * @author ana
 * @version 1.0
 */
public class DBStub {
    private List<ToDo> tareas = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    /**
     * Agrega una nueva tarea a la lista en memoria.
     * @param tarea La tarea a agregar
     */
    public void agregarTarea(ToDo tarea) {
        tareas.add(tarea);
    }

    /**
     * Devuelve todas las tareas almacenadas.
     * @return Lista completa de tareas
     */
    public List<ToDo> obtenerTodas() {
        return tareas;
    }

    /**
     * Busca una tarea por su nombre.
     * @param nombre Nombre de la tarea a buscar
     * @return La tarea encontrada, o null si no existe
     */
    public ToDo buscarPorNombre(String nombre) {
        return tareas.stream()
            .filter(t -> t.getNombre().equals(nombre))
            .findFirst()
            .orElse(null);
    }

    /**
     * Marca una tarea como completada buscándola por nombre.
     * @param nombre Nombre de la tarea a marcar como completada
     */
    public void marcarComoCompletada(String nombre) {
        ToDo tarea = buscarPorNombre(nombre);
        if (tarea != null) tarea.setCompletado(true);
    }

    /**
     * Agrega un email a la lista de notificaciones.
     * @param email Dirección de email a agregar
     */
    public void agregarEmail(String email) {
        emails.add(email);
    }

    /**
     * Devuelve todos los emails registrados.
     * @return Lista de emails registrados
     */
    public List<String> obtenerEmails() {
        return emails;
    }
}