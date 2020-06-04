package br.com.lanchonete.model;

import br.com.lanchonete.util.Mensagens;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor(staticName = "of")
@ToString
public class Funcionario implements IAniversario {

    private final String cpf;
    @Getter
    private final String nome;
    private final String endereco;
    private final String telefone;
    @Getter
    private final LocalDate dataNascimento;
    private Cargo cargo;

    @Override
    public String felizAniversario() {
        return Mensagens.aniversario(getNome(), getDataNascimento());
    }

}
