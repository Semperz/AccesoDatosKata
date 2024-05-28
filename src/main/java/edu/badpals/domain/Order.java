package edu.badpals.domain;

import jakarta.persistence.*;

import java.math.BigInteger;
@Entity
@Table (name = "t_orders")
public class Order {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private BigInteger Id;
    @OneToOne
    @JoinColumn(name = "ord_wizard")
    private Wizard ordWizard;
    @OneToOne
    @JoinColumn(name = "ord_item")
    private MagicalItem ordItem;

    public Order() {
    }

    public Order(Wizard ordWizard, MagicalItem ordItem) {
        this.ordWizard = ordWizard;
        this.ordItem = ordItem;
    }

    public BigInteger getId() {
        return Id;
    }

    public Wizard getOrdWizard() {
        return ordWizard;
    }

    public MagicalItem getOrdItem() {
        return ordItem;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wizard name: ")
                .append(getOrdWizard().getWizardName())
                .append('\n')
                .append("Item: ")
                .append(getOrdItem().getName())
                .append('\n')
                .append("Order ID: ")
                .append(getId())
                .append('\n');
        return sb.toString();
    }
}
