package model;

import java.sql.*;
import java.util.List;

/**
 * classe Cours couche DAO
 */
public class CoursDAO extends DAO<Cours> {

    // METHODES

    /**
     * default constructor
     */
    public CoursDAO() {}

    /**
     * constructor
     * @param connect
     */
    public CoursDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD
     */
    @Override
    public Cours find(Integer id) {
        
        Cours cours = new Cours();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours\n"
                            + "WHERE ID_Cours = " + id);
            if (result.first()) {
                cours = new Cours(
                        result.getInt("ID_Cours"),
                        result.getString("Nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return cours;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Cours obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Cours obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Cours obj) {
        // TODO
        return false;
    }

    @Override
    public Cours find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cours> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cours> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
