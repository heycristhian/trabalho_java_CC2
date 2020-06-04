package br.com.lanchonete.util;

import java.time.LocalDate;

public class Mensagens {

    public static String aniversario(String nome, LocalDate dataNascimento) {
        return LocalDate.now().getMonth() == dataNascimento.getMonth()
                && LocalDate.now().getDayOfMonth() == dataNascimento.getDayOfMonth() ?
                nome + " desejamos um feliz aniversário e muitas felicidades" : "";
    }
}
