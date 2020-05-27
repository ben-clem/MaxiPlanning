package model;

import java.sql.*;

/**
 * classe template mère abstract DAO
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
    public DAO() {}

    /**
     * constructor
     */
    public DAO(Connection connect) {
        this.connect = connect;
    }

    /**
     * recherche dans la BDD
     */
    public abstract T find(Integer id);

    /**
     * ajout dans la BDD
     */
    public abstract boolean create(T obj);

    /**
     * update dans la BDD
     */
    public abstract boolean update(T obj);

    /**
     * suppression dans la BDD
     */
    public abstract boolean delete(T obj);

}
