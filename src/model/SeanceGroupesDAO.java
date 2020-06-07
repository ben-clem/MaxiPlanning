package model;

import java.sql.*;
import java.util.List;

/**
* classe SeanceGroupes couche DAO
*/
public class SeanceGroupesDAO extends DAO<SeanceGroupes> {
    
   // METHODES                            
    
    /**
    * default constructor
    */
    public SeanceGroupesDAO() {}

    /**
     * constructor
     * @param connect
     */
    public SeanceGroupesDAO(Connection connect) {
        super(connect);
    }

    /**
    * recherche dans la BDD
    */
    @Override
    public SeanceGroupes find(Integer id) {
        SeanceGroupes result = null;
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    @Override
    public boolean create(SeanceGroupes obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    @Override
    public boolean update(SeanceGroupes obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(SeanceGroupes obj) {
        //TODO
        return false;
    }

    @Override
    public SeanceGroupes find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceGroupes> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceGroupes> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SeanceGroupes findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceGroupes> findWithProfId(Integer profId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
