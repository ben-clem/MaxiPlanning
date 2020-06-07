package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * classe Salle couche DAO
 */
public class SalleDAO extends DAO<Salle> {

    // METHODES

    /**
     * default constructor
     */
    public SalleDAO() {}

    /**
     * constructor
     */
    public SalleDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD
     */
    @Override
    public Salle find(Integer id) {
        Salle result = null;
        // TODO
        return result;
    }

    @Override
    public List<Salle> findAllWithSeanceId(Integer id) {

        List<Salle> salles = new ArrayList<>();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance\n"
                            + "INNER JOIN seance_salles ON seance.ID_seance  = seance_salles.ID_seance\n"
                            + "INNER JOIN salle ON seance_salles.ID_salle = salle.ID_salle\n"
                            + "WHERE seance.ID_seance = " + id);
            while (result.next()) {
                salles.add(new Salle(
                        result.getInt("ID_salle"),
                        result.getString("Nom"),
                        result.getInt("Capacite"),
                        result.getInt("ID_site")));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return salles;

    }
    
    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Salle obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Salle obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Salle obj) {
        // TODO
        return false;
    }

    @Override
    public Salle find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salle> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salle> findWithProfId(Integer profId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Salle> findAllWithGroupId(Integer groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}