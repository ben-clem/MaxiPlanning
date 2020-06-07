package model;

import java.sql.*;
import java.util.List;

/**
 * classe Utilisateur couche DAO
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

    // METHODES
    /**
     * default constructor
     */
    public UtilisateurDAO() {}

    /**
     * constructor
     *
     * @param connect
     */
    public UtilisateurDAO(Connection connect) {
        super(connect);
    }

    /**
     * méthode de UtilisateurDAO qui recherche dans la BDD avec l'ID
     *
     * @return un objet Utilisateur
     */
    @Override
    public Utilisateur find(Integer id) {

        Utilisateur utilisateur = new Utilisateur();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID_utilisateur = " + id);
            if (result.first()) {
                 utilisateur = new Utilisateur(
                        result.getInt("ID_utilisateur"),
                        result.getInt("Droit"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("Password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return utilisateur;
    }

    /**
     * méthode de UtilisateurDAO qui recherche dans la BDD avec l'email et le
     * password
     *
     * @return un objet Utilisateur
     */
    @Override
    public Utilisateur find(String email, String password) {
        Utilisateur utilisateur = new Utilisateur();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE Email = '" + email
                            + "' AND Password = '" + password + "'");
            if (result.first()) {
                utilisateur = new Utilisateur(
                        result.getInt("ID_utilisateur"),
                        result.getInt("Droit"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("Password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return utilisateur;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(Utilisateur obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(Utilisateur obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(Utilisateur obj) {
        // TODO
        return false;
    }

    @Override
    public List<Utilisateur> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findWithSeanceID(Integer idSeance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findWithProfId(Integer profId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAllWithGroupId(Integer groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
