package model;

import java.sql.*;

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
     */
    public PromotionDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Promotion find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Promotion obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Promotion obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Promotion obj) {
        // TODO
        return false;
    }

}
