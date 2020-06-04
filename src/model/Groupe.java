package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * classe Groupe couche métier
 */
public class Groupe {

    // ATTRIBUTS
    private Integer id;
    private String nom;
    private Integer idPromotion;

    // GETTERS / SETTERS
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIdPromotion() {
        return this.idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getPromoName() {

        // Connection à la DB
        DB db = new DB();
        
        String nomPromo = null;

        try (Connection conn = db.connect()) {
            DAO<Promotion> promoDAO = new PromotionDAO(conn);
            Promotion promo = promoDAO.find(this.idPromotion);
            nomPromo = promo.getNom();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        
        return nomPromo;
    }

    // METHODES
    /**
     * default constructor
     */
    public Groupe() {
    }

    /**
     * constructor
     *
     * @param id
     * @param nom
     * @param idPromotion
     */
    public Groupe(Integer id, String nom, Integer idPromotion) {
        this.id = id;
        this.nom = nom;
        this.idPromotion = idPromotion;
    }

}
