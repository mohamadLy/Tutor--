package utilisateur;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mamadou on 7/10/16.
 */
public class DummyData {

    public static List<Tuteur> DUMMY_CREDENTIALS = new LinkedList<>();

    public static List<Etudiant> DUMMY_CREDENTIALS_STUDENT = new LinkedList<>();

    public DummyData() {
        Utilisateur student1 = new Tuteur("Chris", "Brooks");
        student1.setIdUtilisateur(1);
        student1.setUserName("chris_brooks");
        student1.setEmail("cbrooks0@comcast.net");
        student1.setPassword("password");
        DUMMY_CREDENTIALS.add((Tuteur) student1);
        // student 2
        Utilisateur student2 = new Tuteur("Michelle", "Gordon");
        student2.setIdUtilisateur(2);
        student2.setUserName("Michelle_Gordon");
        student2.setEmail("mgordon2@spiegel.de");
        student2.setPassword("owt0OowbJ");
        DUMMY_CREDENTIALS.add((Tuteur)student2);

        // student 3
        Utilisateur student3 = new Tuteur("Kenneth", "Ross");
        student3.setIdUtilisateur(3);
        student3.setUserName("Kenneth_Ross");
        student3.setEmail("kross1@jigsy.com");
        student3.setPassword("ZD2U18WEQza");
        DUMMY_CREDENTIALS.add((Tuteur)student3);

        Utilisateur student4 = new Etudiant("Katherine", "Nichols");
        student3.setIdUtilisateur(1);
        student3.setUserName("Katherine_Nichols");
        student3.setEmail("knichols3@opera.com");
        student3.setPassword("sgTZqDkdh");
    }
}
