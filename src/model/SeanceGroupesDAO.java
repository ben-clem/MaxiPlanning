package model;

import java.sql.*;

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
     */
    public SeanceGroupesDAO(Connection connect) {
        // TODO
    }

    /**
    * recherche dans la BDD
    */
    public SeanceGroupes find(Integer id) {
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    public boolean create(SeanceGroupes obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    public boolean update(SeanceGroupes obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    public boolean delete(SeanceGroupes obj) {
        //TODO
        return false;
    }
    
}
