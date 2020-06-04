package model;

import java.sql.*;
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
    public List<Salle> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}