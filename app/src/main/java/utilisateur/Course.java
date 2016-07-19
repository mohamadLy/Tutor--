package utilisateur;

/**
 * Created by GlenJeffrey on 2016-07-14.
 */
public class Course {
    private int id;
    private String libelle;
    private String description;

    public Course (int id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.libelle = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
