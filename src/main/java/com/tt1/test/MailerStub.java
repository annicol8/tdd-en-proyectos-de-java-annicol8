package com.tt1.test;

/**
 * Implementación simulada del servicio de correo electrónico.
 * No envía correos reales; imprime los mensajes por consola
 * y registra los envíos en memoria para su uso en desarrollo.
 *
 * @author ana
 * @version 1.0
 */
public class MailerStub implements IMailer {

    /**
     * Simula el envío de un correo imprimiéndolo por consola.
     * @param email Dirección de correo del destinatario
     * @param mensaje Contenido del mensaje a enviar
     * @return true siempre, simulando un envío exitoso
     */
    @Override
    public boolean enviarCorreo(String email, String mensaje) {
        System.out.println("Para: " + email);
        System.out.println("Mensaje: " + mensaje);
        return true;
    }
}