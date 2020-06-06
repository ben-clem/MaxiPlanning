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
    public EnseignantDAO() {
    }

    /**
     * constructor
     *
     * @param connect
     */
    public EnseignantDAO(Connection connect) {
       super(connect);
    }

    /**
     * recherche dans la BDD
     *
     * @param idSeance
     * @return
     */
    @Override
    public Enseignant findWithSeanceID(Integer idSeance) {

        Enseignant enseignant = new Enseignant();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery(
                    "SELECT * FROM enseignant\n"
                    + "INNER JOIN seance_enseignants ON enseignant.ID_utilisateur = seance_enseignants.ID_utilisateur\n"
                    + "WHERE ID_seance = " + idSeance
            );
            if (result.first()) {
                enseignant = new Enseignant(
                        result.getInt("ID_utilisateur")
                );
                result.beforeFirst();
                
                while (result.next()) {
                    //enseignant.addCoursID(result.getInt("ID_cours"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return enseignant;

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

    @Override
    public Enseignant find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
