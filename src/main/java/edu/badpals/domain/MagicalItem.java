package edu.badpals.domain;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "t_items")
public class MagicalItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private BigInteger Id;
    @Column(name = "item_name")
    private String itemName="";
    @Column(name = "item_quality")
    private int itemQuality=0;
    @Column(name = "item_type")
    private String itemType="";

    public MagicalItem() {
    }

    public MagicalItem(String itemName, int itemQuality, String itemType) {
        this.itemName = itemName;
        this.itemQuality = itemQuality;
        this.itemType = itemType;
    }

    public BigInteger getId() {
        return this.Id;
    }

    public String getName() {
        return itemName;
    }

    public int getQuality() {
        return itemQuality;
    }

    public String getType() {
        return itemType;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("Item name: ")
                .append(getName())
                .append('\n')
                .append("Item quality: ")
                .append(getQuality())
                .append('\n')
                .append("Item type: ")
                .append(getType())
                .append('\n')
                .append("Item ID: ")
                .append(getId());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagicalItem that = (MagicalItem) o;
        return itemQuality == that.itemQuality &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemQuality, itemType);
    }
}
