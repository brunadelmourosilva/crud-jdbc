package repository;

import classes.Cliente;
import conn.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import service.ClienteDAOService;

@Log4j2
public class ClienteDAO {

    public static List<Cliente> findAll(){
        return findByName("");
    }

    public static List<Cliente> findByName(String busca){
        String sql = "SELECT idcliente, nome, cpf FROM `automoveis`.`cliente` WHERE `nome` like ?";

        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Cliente cliente = new Cliente(
                        rs.getInt("idcliente"),
                        rs.getString("nome"),
                        rs.getString("cpf"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public static Cliente findById(Integer id){
        String sql = "SELECT idcliente, nome, cpf FROM `automoveis`.`cliente` WHERE `idcliente` = ?";

        Cliente c = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                c = new Cliente(
                        rs.getInt("idcliente"),
                        rs.getString("nome"),
                        rs.getString("cpf"));
            }
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void insert(Cliente cliente){
        String sql = "INSERT INTO `automoveis`.`cliente` (`nome`, `cpf`) VALUES (?, ?);";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            int linhasModificadas = ps.executeUpdate();

            log.info("Inserted costumer '{}' in the database, rows affected '{}'", cliente.getNome(), linhasModificadas);
        } catch (SQLException e) {
            log.error("Error while to insert costumer '{}'", cliente.getNome(), e);
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `automoveis`.`cliente` WHERE (`idcliente` = ?);";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int linhasAfetadas = ps.executeUpdate();

            log.info("Deleted costumer '{}' from the database, rows affected '{}'", id, linhasAfetadas);
        } catch (SQLException e) {
            log.error("Error while to delete costumer '{}'", id, e);
            e.printStackTrace();
        }
    }

    public static void update(Cliente cliente) {
        String sql = "UPDATE `automoveis`.`cliente` SET `nome` = ? , `cpf` = ? WHERE (`idcliente` = ?);";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setInt(3, cliente.getId());
            int linhasAfetadas = ps.executeUpdate();

            log.info("Update costumer '{}', rows affected '{}'", cliente.getId(), linhasAfetadas);
        } catch (SQLException e) {
            log.error("Error while to costumer producer '{}'", cliente.getId());

            e.printStackTrace();
        }

    }


}
