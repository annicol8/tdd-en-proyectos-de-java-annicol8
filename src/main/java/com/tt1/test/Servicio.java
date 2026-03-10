package com.tt1.test;

import java.time.LocalDate;
import java.util.List;
import com.tt1.test.*;

/**
 * Servicio principal de gestión de tareas.
 * Coordina las operaciones sobre tareas y el envío de notificaciones por email.
 * Actúa como capa de lógica de negocio entre el cliente y el repositorio.
 *
 * @author ana
 * @version 1.0
 */
public class Servicio {

    private IRepositorio repositorio;
    private IMailer mailer;

    /**
     * Crea una nueva instancia del servicio.
     * @param repositorio Implementación del repositorio de datos
     * @param mailer Implementación del servicio de correo
     */
    public Servicio(IRepositorio repositorio, IMailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    /**
     * Crea una nueva tarea y la guarda en el repositorio.
     * Lanza una excepción si el nombre es nulo o está vacío.
     * @param nombre Nombre identificador de la tarea
     * @param fechaLimite Fecha límite para completarla
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void crearTarea(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        ToDo tarea = new ToDo(nombre, "", fechaLimite);
        repositorio.guardarTarea(tarea);
        comprobarVencidas();
    }

    /**
     * Registra un email para recibir notificaciones de tareas vencidas.
     * Lanza una excepción si el email no es válido.
     * @param email Dirección de email a registrar
     * @throws IllegalArgumentException si el email es nulo o no contiene @
     */
    public void agregarEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Email no válido.");
        repositorio.guardarEmail(email);
        comprobarVencidas();
    }

    /**
     * Marca una tarea como completada y comprueba tareas vencidas.
     * @param nombre Nombre de la tarea a completar
     */
    public void marcarComoCompletada(String nombre) {
        repositorio.marcarComoCompletada(nombre);
        comprobarVencidas();
    }

    /**
     * Devuelve la lista de tareas que aún no han sido completadas.
     * @return Lista de tareas pendientes
     */
    public List<ToDo> listarPendientes() {
        comprobarVencidas();
        return repositorio.obtenerPendientes();
    }

    /**
     * Comprueba si hay tareas vencidas y notifica por email a los registrados.
     * Una tarea está vencida si su fecha límite es anterior a la fecha actual.
     */
    private void comprobarVencidas() {
        List<ToDo> pendientes = repositorio.obtenerPendientes();
        List<String> emails = repositorio.obtenerEmails();
        LocalDate hoy = LocalDate.now();
        for (ToDo tarea : pendientes) {
            if (tarea.getFechaLimite() != null && tarea.getFechaLimite().isBefore(hoy)) {
                for (String email : emails) {
                    mailer.enviarCorreo(email, "Tarea vencida: " + tarea.getNombre());
                }
            }
        }
    }
}