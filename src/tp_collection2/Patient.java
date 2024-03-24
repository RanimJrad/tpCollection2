package tp_collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {
	private String nom;
    private Set<String> ordonnance;

    public Patient(String n) {
        nom = n.toLowerCase();
        ordonnance = new HashSet<>();
    }

    public String getNom() {
        return nom;
    }

    public boolean ordonnanceVide() {
        return ordonnance.isEmpty();
    }

    public void ajoutMedicament(String m) {
        ordonnance.add(m);
    }

    public void affiche() {
        System.out.println("Nom du patient : " + nom);
        System.out.println("Ordonnance : " + ordonnance);
    }

    public boolean contientMedicament(String m) {
        return ordonnance.contains(m);
    }

    public void trieOrdonnace() {
        TreeSet<String> trier = new TreeSet<>(ordonnance);
        System.out.println("Les oordonnances trie : "+trier);
    }
}
