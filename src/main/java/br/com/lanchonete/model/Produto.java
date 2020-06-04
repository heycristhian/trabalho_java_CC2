package br.com.lanchonete.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor(staticName = "of")
@ToString
public class Produto {

    @Getter
    private final String descricao;
    @Getter
    private final BigDecimal valor;
    private final Long quantidade;
    @Getter
    private final Boolean produz;

}
