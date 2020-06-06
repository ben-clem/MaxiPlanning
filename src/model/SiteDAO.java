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
        
        Site site = new Site();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID_site = '" + id + "'");
            if (result.first()) {
                site = new Site(
                        result.getInt("ID_site"),
                        result.getString("Nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return site;
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

    @Override
    public Site findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}