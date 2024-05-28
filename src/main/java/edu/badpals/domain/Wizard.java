package edu.badpals.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "t_wizards")
public class Wizard {
    @Id
    @Column(name = "wizard_name")
    private String wizardName="";
    @Column(name = "wizard_dexterity")
    private int wizardDexterity=0;
    @Column(name="wizard_person")
    @Enumerated(EnumType.STRING)
    private WizardPerson wizardPerson;

    Wizard() {
    }

    public String getWizardName() {
        return wizardName;
    }

    public int getWizardDexterity() {
        return wizardDexterity;
    }

    public WizardPerson getWizardPerson() {
        return wizardPerson;
    }
    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("Wizard name: ")
                .append(getWizardName())
                .append('\n')
                .append("Wizard dexterity: ")
                .append(getWizardDexterity())
                .append('\n')
                .append("Wizard type: ")
                .append(getWizardPerson())
                .append('\n');
        return sb.toString();
    }
}
