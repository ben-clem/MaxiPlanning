package model;

import java.sql.*;

/**
* classe SeanceEnseignants couche DAO
*/
public class SeanceEnseignantsDAO extends DAO<SeanceEnseignants> {
    
   // METHODES                            
    
    /**
    * default constructor
    */
    public SeanceEnseignantsDAO() {}

    /**
     * constructor
     */
    public SeanceEnseignantsDAO(Connection connect) {
        // TODO
    }

    /**
    * recherche dans la BDD
    */
    public SeanceEnseignants find(Integer id) {
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    public boolean create(SeanceEnseignants obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    public boolean update(SeanceEnseignants obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    public boolean delete(SeanceEnseignants obj) {
        //TODO
        return false;
    }
    
}
