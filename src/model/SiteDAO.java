package model;

import java.sql.*;

/**
 * classe Site couche DAO
 */
public class SiteDAO extends DAO<Site> {

    // METHODES

    /**
     * default constructor
     */
    public SiteDAO() {}

    /**
     * constructor
     */
    public SiteDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Site find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Site obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Site obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Site obj) {
        // TODO
        return false;
    }

}