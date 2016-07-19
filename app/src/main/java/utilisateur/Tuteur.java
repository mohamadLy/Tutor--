package utilisateur;

/**
 * Created by mamadou on 7/9/16.
 */
public class Tuteur extends Utilisateur {
    private final int MAX_DIPLOMES = 4; // maximum of the diplome that are allowed
    private final int MAX_DOMAINES = 10;
    private Diplome[] diplomes;
    private  Domaine[] domaines;
    private double classement;
    private static int currentDiplome;
    private static int currentDomaine;
    public Tuteur(String nom, String prenom) {
        super(nom, prenom);
        this.diplomes = new Diplome[MAX_DIPLOMES];
        this.domaines = new Domaine[MAX_DOMAINES];
        this.classement = 0;
        currentDiplome = 0;
        currentDomaine = 0;
    }

    public Diplome[] getDiplomes() {
        return diplomes;
    }

    public void addDiplomes(Diplome diplome) {
        diplomes[currentDiplome++]= diplome;
    }

    public Domaine[] getDomaines() {
        return domaines;
    }

    public void addDomaines(Domaine domaine) {
        domaines[currentDomaine++] = domaine;
    }

    public double getClassement() {
        return classement;
    }

    public void setClassement(double classement) {
        this.classement = classement;
    }
}
