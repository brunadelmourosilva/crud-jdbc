package service;

import classes.Automovel;
import classes.Cliente;
import repository.AutomovelDAO;
import repository.ClienteDAO;

import java.util.List;

public class AutomovelDAOService {

    public static void findAll(){
        List<Automovel> automoveis = AutomovelDAO.findAll();
        for (int i = 0; i < automoveis.size(); i++) {
            Automovel a = automoveis.get(i);
            System.out.printf(a.getIdautomovel() + " - " + a.getPlaca() + " | " + a.getMarca() + " | " + a.getCliente().getNome() + "\n");
        }
    }

    public static void findByName(String busca){
        List<Automovel> automoveis = AutomovelDAO.findByName(busca);
        for (int i = 0; i < automoveis.size(); i++) {
            Automovel a = automoveis.get(i);
            System.out.printf(a.getIdautomovel() + " - " + a.getPlaca() + " | " + a.getMarca() + " | " + a.getCliente().getNome());
        }
    }

    public static void insert(Automovel automovel){
        AutomovelDAO.insert(automovel);
    }

    public static void delete(int id){
        AutomovelDAO.delete(id);
    }

    public static void update(Automovel automovel) {
        AutomovelDAO.update(automovel);
    }


}

