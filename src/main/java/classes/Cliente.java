package classes;

import java.util.Objects;

public class Cliente {
    private int idcliente;
    private String nome;
    private String cpf;

    public Cliente(int idcliente, String nome, String cpf) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idcliente == cliente.idcliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente);
    }

    public int getId() {
        return idcliente;
    }

    public void setId(int id) {
        this.idcliente = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
