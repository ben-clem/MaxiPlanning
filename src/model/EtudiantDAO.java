package model;

import java.sql.*;
import java.util.List;

/**
 * classe Etudiant couche DAO
 */
public class EtudiantDAO extends DAO<Etudiant> {

    // METHODES
    /**
     * default constructor
     */
    public EtudiantDAO() {
    }

    /**
     * constructor
     *
     * @param connect
     */
    public EtudiantDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD
     */
    @Override
    public Etudiant find(Integer id) {
        Etudiant result = null;
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Etudiant obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Etudiant obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Etudiant obj) {
        // TODO
        return false;
    }

    @Override
    public Etudiant find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
