package repository;

import classes.Automovel;
import classes.Cliente;
import conn.ConnectionFactory;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class AutomovelDAO {

    //MODIFICAR
    public static List<Automovel> findAll(){
        return findByName("");
    }

    public static List<Automovel> findByName(String busca){
        String sql = "SELECT idautomovel, placa, marca, clienteid FROM `automoveis`.`automovel` WHERE `marca` like ?";

        List<Automovel> automovels = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Cliente c = ClienteDAO.findById(rs.getInt("clienteid"));
                Automovel automovel = new Automovel(
                        rs.getInt("idautomovel"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        c); //cliente objeto

                automovels.add(automovel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return automovels;
    }

    public static void insert(Automovel automovel){
        String sql = "INSERT INTO `automoveis`.`automovel` (`placa`, `marca`, `clienteid`) VALUES (? , ? , ?);";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, automovel.getPlaca());
            ps.setString(2, automovel.getMarca());
            ps.setInt(3, automovel.getCliente().getId());
            int linhasModificadas = ps.executeUpdate();

            log.info("Inserted costumer '{}' in the database, rows affected '{}'", automovel.getMarca(), linhasModificadas);
        } catch (SQLException e) {
            log.error("Error while to insert costumer '{}'", automovel.getMarca(), e);
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `automoveis`.`automovel` WHERE (`idautomovel` = ?);";

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

    public static void update(Automovel automovel) {
        String sql = "UPDATE `automoveis`.`automovel` SET `placa` = ? , `marca` = ? WHERE (`idautomovel` = ?);";

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, automovel.getPlaca());
            ps.setString(2, automovel.getMarca());
            ps.setInt(3, automovel.getIdautomovel());
            int linhasAfetadas = ps.executeUpdate();

            log.info("Update costumer '{}', rows affected '{}'", automovel.getIdautomovel(), linhasAfetadas);
        } catch (SQLException e) {
            log.error("Error while to update costumer '{}'", automovel.getIdautomovel());

            e.printStackTrace();
        }

    }

}
