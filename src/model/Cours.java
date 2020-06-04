package model;

/**
 * classe Cours couche métier
 */
public class Cours {

    // ATTRIBUTS

    private Integer id;
    private String nom;

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

    // METHODES

    /**
     * default constructor
     */
    public Cours() {}

    /**
     * constructor
     * @param id
     * @param nom
     */
    public Cours(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

}
