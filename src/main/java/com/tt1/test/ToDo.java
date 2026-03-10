package com.tt1.test;

import java.time.LocalDate;

/**
 * Representa una tarea pendiente (To-Do) en el sistema.
 * Contiene información sobre el nombre, descripción, fecha límite
 * y estado de completado de la tarea.
 *
 * @author ana
 * @version 1.0
 */

public class ToDo {
    private String nombre;
    private String descripcion;
    private LocalDate fechaLimite;
    private boolean completado;

    /** Constructor vacío por defecto. */
    public ToDo() {}

    /**
     * Crea una nueva tarea con los datos proporcionados.
     * @param nombre Nombre identificador de la tarea
     * @param descripcion Descripción detallada de la tarea
     * @param fechaLimite Fecha límite para completar la tarea
     */
    public ToDo(String nombre, String descripcion, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }

    /** @return El nombre de la tarea */
    public String getNombre() { return nombre; }

    /** @param nombre El nuevo nombre de la tarea */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return La descripción de la tarea */
    public String getDescripcion() { return descripcion; }

    /** @param descripcion La nueva descripción de la tarea */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /** @return La fecha límite de la tarea */
    public LocalDate getFechaLimite() { return fechaLimite; }

    /** @param fechaLimite La nueva fecha límite */
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }

    /** @return true si la tarea está completada, false en caso contrario */
    public boolean isCompletado() { return completado; }

    /** @param completado true para marcar como completada, false para pendiente */
    public void setCompletado(boolean completado) { this.completado = completado; }}