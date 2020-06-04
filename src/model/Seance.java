package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

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
    public Cours getCours() {

        Cours cours = new Cours();

        try {

            // Connection à la DB
            DB db = new DB();
            // On va cherche le cours correspondant
            try (Connection conn = db.connect()) {
                // On va cherche le cours correspondant
                DAO<Cours> coursDAO = new CoursDAO(conn);
                cours = coursDAO.find(this.idCours);
            }
            
        } catch (SQLException e) {

            e.printStackTrace(System.err);

        }

        return cours;
    }

    public TypeCours getTypeCours() {

        TypeCours typeCours = new TypeCours();

        try {

            // Connection à la DB
            DB db = new DB();
            // On va cherche le cours correspondant
            try (Connection conn = db.connect()) {
                // On va cherche le cours correspondant
                DAO<TypeCours> typeCoursDAO = new TypeCoursDAO(conn);
                typeCours = typeCoursDAO.find(this.idType);
            }
        } catch (SQLException e) {

            e.printStackTrace(System.err);

        }

        return typeCours;
    }
    
    /**
     * méthode pour obtenir tous les groupes qui participent à une séance
     * @return
     */
    public List<Groupe> getGroupes() {

        List<Groupe> groupes = new ArrayList<>();

        try {

            // Connection à la DB
            DB db = new DB();
            // On va cherche les groupes correspondant
            try (Connection conn = db.connect()) {
                // On va cherche les groupes correspondant
                DAO<Groupe> groupeDAO = new GroupeDAO(conn);
                groupes = groupeDAO.findAllWithSeanceId(this.id);
            }
        } catch (SQLException e) {

            e.printStackTrace(System.err);

        }

        return groupes;
    }

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
     *
     * @param id
     * @param semaine
     * @param date
     * @param heureDebut
     * @param heureFin
     * @param etat
     * @param idCours
     * @param idType
     */
    public Seance(Integer id, Integer semaine, LocalDate date, LocalTime heureDebut, LocalTime heureFin, Integer etat, Integer idCours, Integer idType) {
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.etat = etat;
        this.idCours = idCours;
        this.idType = idType;
    }
    
}