package utilisateur;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mamadou on 7/9/16.
 */
public class Utilisateur implements Parcelable{
    private int id;
    private String prenom;
    private String nom;
    private String numeroTelephone;
    private String codePostal;

    public Utilisateur() {
        // default constructor
    }
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // We just need to write each field into the
        // parcel. When we read from parcel, they
        // will come back in the same order
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeString(email);
        //parcel.writeString();
        //parcel.writeInt(idUtilisateur);
    }

    private Utilisateur(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        email = in.readString();
    }


    /**
     *
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * */
    public static final Parcelable.Creator<Utilisateur> CREATOR
            = new Parcelable.Creator<Utilisateur>() {
        public Utilisateur createFromParcel(Parcel in) {
            return new Utilisateur(in);
        }

        public Utilisateur[] newArray(int size) {
            return new Utilisateur[size];
        }
    };

}
