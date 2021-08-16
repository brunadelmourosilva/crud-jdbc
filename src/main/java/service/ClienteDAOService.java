package service;

import classes.Cliente;
import repository.ClienteDAO;

import java.util.List;

public class ClienteDAOService {

    public static void findAll(){
        List<Cliente> clientes = ClienteDAO.findAll();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.printf(c.getId() + " - " + c.getNome() + " | " + c.getCpf() + "\n");
        }
    }

    public static void findByName(String busca){
        List<Cliente> clientes = ClienteDAO.findByName(busca);
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.printf(c.getId() + " - " + c.getNome() + " | " + c.getCpf());
        }
    }

    public static void insert(Cliente cliente){
        ClienteDAO.insert(cliente);
    }

    public static void delete(int id){
        ClienteDAO.delete(id);
    }

    public static void update(Cliente cliente) {
        ClienteDAO.update(cliente);
    }

    }

