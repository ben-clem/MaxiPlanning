package model;

import java.sql.*;

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
     */
    public SeanceSallesDAO(Connection connect) {
        // TODO
    }

    /**
    * recherche dans la BDD
    */
    public SeanceSalles find(Integer id) {
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    public boolean create(SeanceSalles obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    public boolean update(SeanceSalles obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    public boolean delete(SeanceSalles obj) {
        //TODO
        return false;
    }
    
}
