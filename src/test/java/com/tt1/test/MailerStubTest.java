package com.tt1.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MailerStubTest {
    private MailerStub mailer;

    @BeforeEach
    void setUp() {
        mailer = new MailerStub();
    }

    @Test
    void enviarCorreoDevuelveTrue() {
        assertTrue(mailer.enviarCorreo("a@a.com", "Hola"));
    }
}