package com.tt1.test;
/**
 * Interfaz que define las operaciones de persistencia del sistema de tareas.
 * Cualquier implementación debe permitir guardar, buscar y gestionar tareas y emails.
 *
 * @author ana
 * @version 1.0
 */
public interface IRepositorio {

    /**
     * Busca y devuelve una tarea por su nombre.
     * @param nombre Nombre de la tarea a buscar
     * @return La tarea encontrada, o null si no existe
     */
    ToDo encontrarTarea(String nombre);

    /**
     * Guarda una nueva tarea en el repositorio.
     * @param tarea La tarea a guardar
     */
    void guardarTarea(ToDo tarea);

    /**
     * Marca una tarea existente como completada.
     * @param nombre Nombre de la tarea a marcar
     */
    void marcarComoCompletada(String nombre);

    /**
     * Guarda un email de notificación en el repositorio.
     * @param email Dirección de email a guardar
     */
    void guardarEmail(String email);

    /**
     * Devuelve la lista de tareas pendientes (no completadas).
     * @return Lista de tareas pendientes
     */
    java.util.List<ToDo> obtenerPendientes();

    /**
     * Devuelve todos los emails registrados.
     * @return Lista de emails
     */
    java.util.List<String> obtenerEmails();
}