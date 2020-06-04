package br.com.lanchonete.main;

import br.com.lanchonete.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            Cargo cargo = Cargo.builder()
                    .id(1L)
                    .descricao("Garçom")
                    .salario(BigDecimal.valueOf(1500.0))
                    .build();

            //CRIAÇÃO DE PRODUTOS
            Produto produto1 = Produto.of(
                    "Hot-Dog Duplo",
                    BigDecimal.valueOf(13.5),
                    1L,
                    true);

            Produto produto2 = Produto.of(
                    "Coca-Cola Zero 2L",
                    BigDecimal.valueOf(7.90),
                    1L,
                    false);

            Produto produto3 = Produto.of(
                    "Fanta 2L",
                    BigDecimal.valueOf(7.90),
                    1L,
                    false);

            Produto produto4 = Produto.of(
                    "X-Tudo",
                    BigDecimal.valueOf(15.60),
                    1L,
                    true);

            Cliente cliente = Cliente.of(
                    "45073070828",
                    "Cristhian Dias",
                    "José Conceição, 26",
                    "18997415398", LocalDate.of(1995, 9, 5));

            Funcionario funcionario1 = Funcionario.of(
                    "11011011011",
                    "João V. Franco",
                    "Rua dos Programadores",
                    "1899999999",
                    LocalDate.of(1990, 4, 12), cargo);

            Funcionario funcionario2 = Funcionario.of(
                    "11011011011",
                    "José da Silva",
                    "Rua dos Programadores",
                    "1899999999",
                    LocalDate.of(1990, 4, 12), cargo);

            cargo.adicionarFuncionario(funcionario1);
            cargo.adicionarFuncionario(funcionario2);

            //funcionario1.criarPedido(cliente)
            Pedido pedido1 = new Pedido(cliente, funcionario1);
            Pedido pedido2 = new Pedido(cliente, funcionario2);

            //Funcionario tbm cria os produtos do pedido
            pedido1.adicionarLista(Arrays.asList(produto1, produto2));
            pedido2.adicionarLista(Arrays.asList(produto3, produto4));

            cliente.adicionarPedidos(pedido1);
            cliente.adicionarPedidos(pedido2);

            cliente.imprimirPedidos();

            System.out.println("Todos os produtos do pedido 1: ");
            pedido1.getProdutos().forEach(produto -> System.out.println(produto.getDescricao()));
            System.out.println();
            System.out.println("Todos os produtos do pedido 2: ");
            pedido2.getProdutos().forEach(produto -> System.out.println(produto.getDescricao()));

            System.out.println("Impressão dos funcionários do cargo instânciado!");
            cargo.getFuncionarios().forEach(func -> System.out.println(func));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
