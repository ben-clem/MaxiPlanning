package model;

import java.sql.*;

/**
 * classe Cours couche DAO
 */
public class GroupeDAO extends DAO <Groupe> {
    
    // METHODES

    /**
     * default constructor
     */
    public GroupeDAO() {}

    /**
     * constructor
     */
    public GroupeDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Groupe find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Groupe obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Groupe obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Groupe obj) {
        // TODO
        return false;
    }
    
}
