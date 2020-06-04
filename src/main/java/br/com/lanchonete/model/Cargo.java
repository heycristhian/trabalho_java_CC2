package br.com.lanchonete.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor(staticName = "of")
@Builder
@ToString(of = {"descricao", "salario"})
public class Cargo {

    private long id;

    @Length(min = 5, max = 255)
    @NotNull
    private String descricao;

    @NotNull
    private BigDecimal salario;
    @Getter
    @Builder.Default private ArrayList<Funcionario> funcionarios;

    @Deprecated
    Cargo() {}

    public static class CargoBuilder {

        public Cargo build() {
            Cargo cargo = Cargo.of(this.id, this.descricao, this.salario, new ArrayList<>());

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

            Set<ConstraintViolation<Cargo>> violations = validator.validate(cargo);

            if (!violations.isEmpty()) {
                String message = violations.stream().map(v -> String.format("%s: %s", v.getPropertyPath(), v.getMessage())).collect(Collectors.joining("\n"));

                throw new RuntimeException(message);
            }

            return cargo;
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Funcionário não pode ser nulo!");
        getFuncionarios().add(funcionario);
    }
}
