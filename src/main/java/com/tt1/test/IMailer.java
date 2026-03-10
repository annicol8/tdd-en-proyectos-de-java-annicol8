package com.tt1.test;

/**
 * Interfaz para el servicio de envío de correos electrónicos.
 * Permite desacoplar la lógica de negocio del mecanismo concreto de envío.
 *
 * @author ana
 * @version 1.0
 */
public interface IMailer {

    /**
     * Envía un correo electrónico al destinatario indicado.
     * @param email Dirección de correo del destinatario
     * @param mensaje Contenido del mensaje a enviar
     * @return true si el envío fue exitoso, false en caso contrario
     */
    boolean enviarCorreo(String email, String mensaje);
}