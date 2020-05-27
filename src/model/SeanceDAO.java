package model;

import java.sql.*;

/**
 * classe Seance couche DAO
 */
public class SeanceDAO extends DAO<Seance> {

    // METHODES

    /**
     * default constructor
     */
    public SeanceDAO() {}

    /**
     * constructor
     */
    public SeanceDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Seance find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Seance obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Seance obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Seance obj) {
        // TODO
        return false;
    }

}
