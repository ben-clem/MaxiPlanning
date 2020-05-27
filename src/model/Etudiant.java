package model;

/**
 * class Etudiant couche métier
 */
public class Etudiant {

    // ATTRIBUTS

    private Integer idUtilisateur;
    private Integer numero;
    private Integer idGroupe;

    // GETTERS / SETTERS

    public Integer getIdUtilisateur() {
        return this.idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    // METHODES

    /**
     * default constructor
     */
    public Etudiant() {}

     /**
     * constructor
     */
    public Etudiant(Integer idUtilisateur, Integer numero, Integer idGroupe) {
        // TODO
    }

}
