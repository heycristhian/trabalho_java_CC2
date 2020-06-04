package br.com.lanchonete.model;

import br.com.lanchonete.util.Mensagens;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor(staticName = "of")
@ToString(of = {"nome", "cpf"})
public class Cliente implements IAniversario {

    private final String cpf;
    @Getter
    @NonNull
    private final String nome;
    private final String endereco;
    private final String telefone;
    @Getter
    private final LocalDate dataNascimento;
    @Getter
    private Map<Cliente, List<Pedido>> pedidos = new LinkedHashMap<>();

    public void adicionarPedidos (Pedido pedido) {
        Objects.requireNonNull(this, "Cliente não pode ser nulo");
        Objects.requireNonNull(pedido, "Pedido não pode ser nulo");

        List<Pedido> pedidos = Optional.ofNullable(this.pedidos.get(this)).orElse(new LinkedList<>());
        pedidos.add(pedido);
        this.pedidos.put(this, pedidos);
    }

    @Override
    public String felizAniversario() {
        return Mensagens.aniversario(getNome(), getDataNascimento());
    }

    public void imprimirPedidos() {
        System.out.println("Produtos do cliente: " + this.getNome());
        getPedidos().get(this).forEach(pedido -> System.out.println(pedido));
    }
}
