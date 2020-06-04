package model;

import java.sql.*;
import java.util.List;

/**
 * classe SeanceEnseignants couche DAO
 */
public class SeanceEnseignantsDAO extends DAO<SeanceEnseignants> {

    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public SeanceEnseignantsDAO() {
    }

    /**
     * constructor
     *
     * @param connect
     */
    public SeanceEnseignantsDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD
     */
    @Override
    public SeanceEnseignants find(Integer id) {
        SeanceEnseignants result = null;
        //TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(SeanceEnseignants obj) {
        //TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(SeanceEnseignants obj) {
        //TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(SeanceEnseignants obj) {
        //TODO
        return false;
    }

    @Override
    public SeanceEnseignants find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceEnseignants> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceEnseignants> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
