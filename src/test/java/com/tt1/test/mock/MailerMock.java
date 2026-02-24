package com.tt1.test.mock;

import com.tt1.test.IMailer;

public class MailerMock implements IMailer {
    public int vecesLlamado = 0;
    public String ultimoEmail = "";
    public String ultimoMensaje = "";

    @Override
    public boolean enviarCorreo(String email, String mensaje) {
        vecesLlamado++;
        ultimoEmail = email;
        ultimoMensaje = mensaje;
        return true;
    }
}