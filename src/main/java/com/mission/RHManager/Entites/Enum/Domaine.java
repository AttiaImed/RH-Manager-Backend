package com.mission.RHManager.Entites.Enum;
public enum Domaine {
    DEVELOPPEMENT_LOGICIEL(1, "Développement de logiciels"),
    TEST_ASSURANCE_QUALITE(2, "Test et assurance qualité"),
    GESTION_PROJET(3, "Gestion de projet"),
    CONCEPTION_UI_UX(4, "Conception d'interface utilisateur (UI/UX)"),
    SUPPORT_MAINTENANCE(5, "Support et maintenance"),
    SECURITE_INFORMATIQUE(6, "Sécurité informatique"),
    INFRASTRUCTURE_OPERATIONS(7, "Infrastructure et opérations"),
    RECHERCHE_DEVELOPPEMENT(8, "Recherche et développement"),
    MARKETING_VENTES(9, "Marketing et ventes"),
    RESSOURCES_HUMAINES(10, "Ressources humaines et gestion du personnel"),
    GESTION_DONNEES(11, "Gestion de données");

    private final int id;
    private final String description;

    Domaine(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Domaine valueOf(int id) {
        for (Domaine domaine : values()) {
            if (domaine.getId() == id) {
                return domaine;
            }
        }
        throw new IllegalArgumentException("WRONG ID: " + id);
    }
}
