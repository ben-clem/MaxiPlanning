package model;

import java.sql.*;
import java.util.List;

/**
* classe SeanceSalles couche DAO
*/
public class SeanceSallesDAO extends DAO<SeanceSalles> {
    
   // METHODES                            
    
    /**
    * default constructor
    */
    public SeanceSallesDAO() {}

    /**
     * constructor
     * @param connect
     */
    public SeanceSallesDAO(Connection connect) {
        super(connect);
    }

    /**
    * recherche dans la BDD
    */
    @Override
    public SeanceSalles find(Integer id) {
        SeanceSalles result = null;
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    @Override
    public boolean create(SeanceSalles obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    @Override
    public boolean update(SeanceSalles obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(SeanceSalles obj) {
        //TODO
        return false;
    }

    @Override
    public SeanceSalles find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceSalles> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SeanceSalles> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
