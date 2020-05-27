package model;

import java.sql.*;

/**
* classe Enseignant couche DAO
*/
public class EnseignantDAO extends DAO<Enseignant> {
    
   // METHODES                            
    
    /**
    * default constructor
    */
    public EnseignantDAO() {}

    /**
     * constructor
     */
    public EnseignantDAO(Connection connect) {
        // TODO
    }

    /**
    * recherche dans la BDD
    */
    public Enseignant find(Integer id) {
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    public boolean create(Enseignant obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    public boolean update(Enseignant obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    public boolean delete(Enseignant obj) {
        //TODO
        return false;
    }
    
}
