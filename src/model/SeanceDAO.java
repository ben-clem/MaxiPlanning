package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * classe Seance couche DAO
 */
public class SeanceDAO extends DAO<Seance> {

    //////////////
    // METHODES //
    //////////////
    /**
     * default constructor
     */
    public SeanceDAO() {}

    /**
     * constructor
     *
     * @param connect
     */
    public SeanceDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD avec l'id d'un élève
     *
     * @param studentId
     * @return
     */
    @Override
    public List<Seance> findWithStudentId(Integer studentId) {
        List<Seance> seances = new ArrayList<>();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance\n"
                            + "INNER JOIN seance_groupes ON seance.ID_seance = seance_groupes.ID_seance\n"
                            + "INNER JOIN etudiant ON seance_groupes.ID_groupe = etudiant.ID_Groupe\n"
                            + "WHERE etudiant.ID_Utilisateur = " + studentId.toString());
            while (result.next()) {
                seances.add(new Seance(
                        result.getInt("ID_seance"),
                        result.getInt("Semaine"),
                        result.getDate("Date").toLocalDate(),
                        result.getTime("Heure_debut").toLocalTime(),
                        result.getTime("Heure_fin").toLocalTime(),
                        result.getInt("Etat"),
                        result.getInt("ID_cours"),
                        result.getInt("ID_type")));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return seances;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Seance obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Seance obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Seance obj) {
        // TODO
        return false;
    }

    @Override
    public Seance find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seance> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seance findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
