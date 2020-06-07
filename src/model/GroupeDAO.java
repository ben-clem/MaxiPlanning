package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * classe Cours couche DAO
 */
public class GroupeDAO extends DAO<Groupe> {

    // METHODES
    /**
     * default constructor
     */
    public GroupeDAO() {
    }

    /**
     * constructor
     *
     * @param connect
     */
    public GroupeDAO(Connection connect) {
        super(connect);
    }

    @Override
    public List<Groupe> findAllWithSeanceId(Integer id) {

        List<Groupe> groupes = new ArrayList<>();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance\n"
                            + "INNER JOIN seance_groupes ON seance.ID_seance  = seance_groupes.ID_seance\n"
                            + "INNER JOIN groupe ON seance_groupes.ID_groupe = groupe.ID_groupe\n"
                            + "WHERE seance.ID_seance = " + id);
            while (result.next()) {
                groupes.add(new Groupe(
                        result.getInt("ID_groupe"),
                        result.getString("Nom"),
                        result.getInt("ID_promotion")));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return groupes;

    }

    /**
     * recherche dans la BDD
     */
    @Override
    public Groupe find(Integer id) {
        Groupe groupe = new Groupe();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe\n"
                            + "WHERE ID_groupe = " + id);
            if (result.first()) {
                groupe = new Groupe(
                        result.getInt("ID_groupe"),
                        result.getString("Nom"),
                        result.getInt("ID_promotion"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return groupe;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Groupe obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Groupe obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Groupe obj) {
        // TODO
        return false;
    }

    @Override
    public Groupe find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Groupe> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Groupe> findWithProfId(Integer profId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
