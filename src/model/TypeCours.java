package model;

/**
 * classe TypeCours couche métier
 */
public class TypeCours {

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
    public TypeCours() {}

    /**
     * constructor
     */
    public TypeCours(Integer id, String nom) {
        // TODO
    }

}
