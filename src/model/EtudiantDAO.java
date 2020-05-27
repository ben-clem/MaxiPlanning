package model;

import java.sql.*;

/**
 * classe Etudiant couche DAO
 */
public class EtudiantDAO extends DAO<Etudiant> {
    
   // METHODES

    /**
     * default constructor
     */
    public EtudiantDAO() {}

    /**
     * constructor
     */
    public EtudiantDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public Etudiant find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(Etudiant obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(Etudiant obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(Etudiant obj) {
        // TODO
        return false;
    }
    
}
