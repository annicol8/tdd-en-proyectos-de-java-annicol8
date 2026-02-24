package com.tt1.test;

public interface IRepositorio {
    ToDo encontrarTarea(String nombre);
    void guardarTarea(ToDo tarea);
    void marcarComoCompletada(String nombre);
    void guardarEmail(String email);
    java.util.List<ToDo> obtenerPendientes();
    java.util.List<String> obtenerEmails();
}