package model;

import java.sql.*;

/**
 * classe TypeCours couche DAO
 */
public class TypeCoursDAO extends DAO<TypeCours> {

    // METHODES

    /**
     * default constructor
     */
    public TypeCoursDAO() {}

    /**
     * constructor
     */
    public TypeCoursDAO(Connection connect) {
        // TODO
    }

    /**
     * recherche dans la BDD
     */
    public TypeCours find(Integer id) {
        // TODO
        return result;
    }

    /**
     * ajout dans la BDD
     */
    public boolean create(TypeCours obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    public boolean update(TypeCours obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    public boolean delete(TypeCours obj) {
        // TODO
        return false;
    }

}