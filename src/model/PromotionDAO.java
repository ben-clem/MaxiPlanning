package model;

import java.sql.*;
import java.util.List;

/**
 * classe Promotion couche DAO
 */
public class PromotionDAO extends DAO<Promotion> {

    // METHODES

    /**
     * default constructor
     */
    public PromotionDAO() {}

    /**
     * constructor
     * @param connect
     */
    public PromotionDAO(Connection connect) {
       super(connect);
    }

    /**
     * récupérer une promotion avec son ID
     */
    @Override
    public Promotion find(Integer id) {
        
         Promotion promo = new Promotion();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion\n"
                            + "WHERE ID_promotion = " + id);
            if (result.first()) {
                promo = new Promotion(
                        result.getInt("ID_promotion"),
                        result.getString("Nom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return promo;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Promotion obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Promotion obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Promotion obj) {
        // TODO
        return false;
    }

    @Override
    public Promotion find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Promotion> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Promotion> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Promotion findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
