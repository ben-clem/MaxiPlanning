package model;

import java.sql.*;

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
     */
    public CoursDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Cours find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Cours obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Cours obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Cours obj) {
        // TODO
        return false;
    }

}
