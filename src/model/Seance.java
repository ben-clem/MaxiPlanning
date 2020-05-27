package model;

import java.time.*;

/**
 * classe Seance couche métier
 */
public class Seance {

    // ATTRIBUTS

    private Integer id;
    private Integer semaine;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Integer etat;
    private Integer idCours;
    private Integer idType;

    // GETTERS / SETTERS

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemaine() {
        return this.semaine;
    }

    public void setSemaine(Integer semaine) {
        this.semaine = semaine;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return this.heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return this.heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getEtat() {
        return this.etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getIdCours() {
        return this.idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public Integer getIdType() {
        return this.idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    // METHODES

   /**
     * default constructor
     */
    public Seance() {}

    /**
     * constructor
     */
    public Seance(Integer id, Integer semaine, LocalDate date, LocalTime heureDebut, LocalTime heureFin, Integer etat, Integer idCours, Integer idType) {
        // TODO
    }

}
