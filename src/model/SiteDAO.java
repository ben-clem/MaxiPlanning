package model;

import java.sql.*;
import java.util.List;

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
     * @param connect
     */
    public SiteDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD
     */
    @Override
    public Site find(Integer id) {
        Site result = null;
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Site obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Site obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Site obj) {
        // TODO
        return false;
    }

    @Override
    public Site find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Site> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Site> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}