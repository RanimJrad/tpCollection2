package tp_collection2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DossierPharmacie {
	private String nom;
    private HashMap<String, Patient> patients;

    public DossierPharmacie(String n) {
        nom = n;
        patients = new HashMap<>();
    }

    public void nouveauPatient(String nom, String[] ord) {
        if (!patients.containsKey(nom.toLowerCase())) {
            Patient patient = new Patient(nom);
            for (String medicament : ord) {
                patient.ajoutMedicament(medicament);
            }
            patients.put(nom.toLowerCase(), patient);
        }
    }

    public boolean ajoutMedicament(String nom, String m) {
        Patient p = patients.get(nom.toLowerCase());
        if (p != null) {
            p.ajoutMedicament(m);
            return true;
        }
        return false;
    }

    public void affichePatient(String nom) {
        Patient p = patients.get(nom.toLowerCase());
        if (p != null) {
            p.affiche();
        } else {
            System.out.println("Le patient " + nom + " n'existe pas ");
        }
    }

    public void affiche() {
        System.out.println("Nom de la pharmacie : " + nom);
        for (Patient p : patients.values()) {
            p.affiche();
        }
    }

    public Collection<String> affichePatientAvecMedicament(String m) {
        Set<String> p = new HashSet<>();
        for (Patient patient : patients.values()) {
            if (patient.contientMedicament(m)) {
                p.add(patient.getNom());
            }
        }
        return p;
    }

}
