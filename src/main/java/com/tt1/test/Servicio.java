package com.tt1.test;

import java.time.LocalDate;
import java.util.List;
import com.tt1.test.*;

public class Servicio {
    private IRepositorio repositorio;
    private IMailer mailer;

    public Servicio(IRepositorio repositorio, IMailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }

    public void crearTarea(String nombre, LocalDate fechaLimite) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        ToDo tarea = new ToDo(nombre, "", fechaLimite);
        repositorio.guardarTarea(tarea);
        comprobarVencidas();
    }

    public void agregarEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Email no válido.");
        repositorio.guardarEmail(email);
        comprobarVencidas();
    }

    public void marcarComoCompletada(String nombre) {
        repositorio.marcarComoCompletada(nombre);
        comprobarVencidas();
    }

    public List<ToDo> listarPendientes() {
        comprobarVencidas();
        return repositorio.obtenerPendientes();
    }

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