package model;

import java.sql.*;

/**
 * classe Utilisateur couche DAO
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    // METHODES

    /**
     * default constructor
     */
    public UtilisateurDAO() {}

    /**
     * constructor
     */
    public UtilisateurDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Utilisateur find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Utilisateur obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Utilisateur obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Utilisateur obj) {
        // TODO
        return false;
    }

}
