package com.tt1.test;
import com.tt1.test.IMailer;

public class MailerStub implements IMailer {
    @Override
    public boolean enviarCorreo(String email, String mensaje) {
        System.out.println("Para: " + email);
        System.out.println("Mensaje: " + mensaje);
        return true;
    }
}