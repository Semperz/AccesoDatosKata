package edu.badpals.repository;

import edu.badpals.domain.MagicalItem;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RepoMagicalItem implements PanacheRepositoryBase<MagicalItem, BigInteger> {
public Optional<MagicalItem> findByItemName(String item) {
        List<MagicalItem> allItems = this.listAll();
        Optional<MagicalItem> objectOptional;
        objectOptional = allItems
                .stream()
                .filter(i -> i.getName().contains(item))
                .findFirst();
        return objectOptional.isPresent() ? objectOptional : Optional.empty();
    }
}
