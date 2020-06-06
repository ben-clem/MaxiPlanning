package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * classe Salle couche métier
 */
public class Salle {

    // ATTRIBUTS

    private Integer id;
    private String nom;
    private Integer capacite;
    private Integer idSite;

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

    public Integer getCapacite() {
        return this.capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getIdSite() {
        return this.idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    public Site getSite() {
        Site site = new Site();
        
        try {

                // Connection à la DB
                DB db = new DB();
                // On va cherche le cours correspondant
                try (Connection conn = db.connect()) {
                    // On va cherche le cours correspondant
                    DAO<Site> siteDAO = new SiteDAO(conn);
                    site = siteDAO.find(this.idSite);
                }

            } catch (SQLException e) {

                e.printStackTrace(System.err);

            }

            return site;
    }
    
    // METHODES

    /**
     * default constructor
     */
    public Salle() {}

    /**
     * constructor
     * @param id
     * @param nom
     * @param capacite
     * @param idSite
     */
    public Salle(Integer id, String nom, Integer capacite, Integer idSite) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.idSite = idSite;
    }

}
