package model;

import java.sql.*;
import java.util.List;

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
     * @param connect
     */
    public EnseignantDAO(Connection connect) {
        // TODO
    }

    /**
    * recherche dans la BDD
    */
    @Override
    public Enseignant find(Integer id) {
        Enseignant result = null;
        //TODO
        return result;
    }
    
    /**
    * ajout dans la BDD
    */
    @Override
    public boolean create(Enseignant obj) {
        //TODO
        return false;
    }
    
    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Enseignant obj) {
        //TODO
        return false;
    }
    
    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Enseignant obj) {
        //TODO
        return false;
    }

    @Override
    public Enseignant find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enseignant> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enseignant> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
