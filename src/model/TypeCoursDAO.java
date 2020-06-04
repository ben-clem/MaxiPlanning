package model;

import java.sql.*;
import java.util.List;

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
     *
     * @param connect
     */
    public TypeCoursDAO(Connection connect) {
        super(connect);
    }

    /**
     * recherche dans la BDD
     */
    @Override
    public TypeCours find(Integer id) {

        TypeCours typeCours = new TypeCours();

        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type_cours\n"
                            + "WHERE ID_type = " + id);
            if (result.first()) {
                typeCours = new TypeCours(
                        result.getInt("ID_type"),
                        result.getString("Nom")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return typeCours;
    }

    /**
     * ajout dans la BDD
     */
    @Override
    public boolean create(TypeCours obj) {
        // TODO
        return false;
    }

    /**
     * update dans la BDD
     */
    @Override
    public boolean update(TypeCours obj) {
        // TODO
        return false;
    }

    /**
     * suppression dans la BDD
     */
    @Override
    public boolean delete(TypeCours obj) {
        // TODO
        return false;
    }

    @Override
    public TypeCours find(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TypeCours> findWithStudentId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TypeCours> findAllWithSeanceId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
