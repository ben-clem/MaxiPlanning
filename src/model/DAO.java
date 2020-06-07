package model;

import java.sql.*;
import java.util.List;

/**
 * classe template mère abstract DAO
 *
 * @param <T>
 */
public abstract class DAO<T> {

    // ATTRIBUTS
    protected Connection connect = null;

    // GETTERS / SETTERS
    protected Connection getConnect() {
        return this.connect;
    }

    protected void setConnect(Connection connect) {
        this.connect = connect;
    }

    // METHODES
    /**
     * default constructor
     */
    public DAO() {
    }

    /**
     * constructor
     *
     * @param connect
     */
    public DAO(Connection connect) {
        this.connect = connect;
    }

    /**
     * recherche dans la BDD
     *
     * @param id
     * @return
     */
    public abstract T find(Integer id);

    /**
     * recherche dans la BDD
     *
     * @param email
     * @param password
     * @return
     */
    public abstract T find(String email, String password);
    
     /**
     * recherche dans la BDD
     *
     * @param id
     * @return
     */
    public abstract List<T> findWithStudentId(Integer id);

    public abstract List<T> findAllWithSeanceId(Integer id);
    
    public abstract T findWithSeanceID(Integer idSeance);
    
    public abstract List<T> findWithProfId(Integer profId);

    /**
     * ajout dans la BDD
     *
     * @param obj
     * @return
     */
    public abstract boolean create(T obj);

    /**
     * update dans la BDD
     *
     * @param obj
     * @return
     */
    public abstract boolean update(T obj);

    /**
     * suppression dans la BDD
     *
     * @param obj
     * @return
     */
    public abstract boolean delete(T obj);

   

}
