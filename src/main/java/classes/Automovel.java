package classes;

import java.util.Objects;

public class Automovel {
    private int idautomovel;
    private String placa;
    private String marca;
    private Cliente cliente;

    public Automovel(String placa, String marca, Cliente cliente) {
        this.placa = placa;
        this.marca = marca;
        this.cliente = cliente;
    }

    public Automovel(int idautomovel, String placa, String marca, Cliente cliente) {
        this.idautomovel = idautomovel;
        this.placa = placa;
        this.marca = marca;
        this.cliente = cliente;
    }

    public Automovel(String placa, String marca, int idautomovel) {
        this.placa = placa;
        this.marca = marca;
        this.idautomovel = idautomovel;
    }

    public Automovel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automovel automovel = (Automovel) o;
        return idautomovel == automovel.idautomovel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idautomovel);
    }

    public int getIdautomovel() {
        return idautomovel;
    }

    public void setIdautomovel(int idautomovel) {
        this.idautomovel = idautomovel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
