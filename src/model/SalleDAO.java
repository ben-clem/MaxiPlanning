package model;

import java.sql.*;

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
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Salle find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Salle obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Salle obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Salle obj) {
        // TODO
        return false;
    }

}