package edu.badpals.domain;

import jakarta.persistence.*;

import java.math.BigInteger;
@Entity
@Table (name = "t_orders")
public class Order {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private BigInteger Id;
    @ManyToOne
    @JoinColumn(name = "ord_wizard")
    private Wizard wizard;
    @OneToOne
    @JoinColumn(name = "ord_item")
    private MagicalItem item;

    public Order() {
    }

    public Order(Wizard ordWizard, MagicalItem ordItem) {
        this.wizard = ordWizard;
        this.item = ordItem;
    }

    public BigInteger getId() {
        return Id;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public MagicalItem getItem() {
        return item;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wizard name: ")
                .append(getWizard().getName())
                .append('\n')
                .append("Item: ")
                .append(getItem().getName())
                .append('\n')
                .append("Order ID: ")
                .append(getId())
                .append('\n');
        return sb.toString();
    }
}
