package com.tt1.test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación concreta de IRepositorio que usa DBStub como almacenamiento.
 * Actúa como adaptador entre la interfaz del repositorio y la base de datos simulada.
 *
 * @author ana
 * @version 1.0
 */
public class Repositorio implements IRepositorio {

    private DBStub db;

    /**
     * Crea el repositorio con la base de datos simulada proporcionada.
     * @param db Instancia de DBStub a utilizar como almacenamiento
     */
    public Repositorio(DBStub db) {
        this.db = db;
    }

    /**
     * Busca y devuelve una tarea por su nombre.
     * @param nombre Nombre de la tarea a buscar
     * @return La tarea encontrada, o null si no existe
     */
    @Override
    public ToDo encontrarTarea(String nombre) {
        return db.buscarPorNombre(nombre);
    }

    /**
     * Guarda una nueva tarea en el repositorio.
     * @param tarea La tarea a guardar
     */
    @Override
    public void guardarTarea(ToDo tarea) {
        db.agregarTarea(tarea);
    }

    /**
     * Marca una tarea existente como completada.
     * @param nombre Nombre de la tarea a marcar como completada
     */
    @Override
    public void marcarComoCompletada(String nombre) {
        db.marcarComoCompletada(nombre);
    }

    /**
     * Guarda un email de notificación en el repositorio.
     * @param email Dirección de email a guardar
     */
    @Override
    public void guardarEmail(String email) {
        db.agregarEmail(email);
    }

    /**
     * Devuelve la lista de tareas que aún no han sido completadas.
     * @return Lista de tareas pendientes
     */
    @Override
    public List<ToDo> obtenerPendientes() {
        return db.obtenerTodas().stream()
            .filter(t -> !t.isCompletado())
            .collect(Collectors.toList());
    }

    /**
     * Devuelve todos los emails registrados en el repositorio.
     * @return Lista de emails registrados
     */
    @Override
    public List<String> obtenerEmails() {
        return db.obtenerEmails();
    }
}