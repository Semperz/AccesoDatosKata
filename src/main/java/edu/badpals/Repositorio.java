package edu.badpals;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Order;
import edu.badpals.domain.Wizard;
import edu.badpals.repository.RepoMagicalItem;
import edu.badpals.repository.RepoOrder;
import edu.badpals.repository.RepoWizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class Repositorio {
    @Inject
    RepoMagicalItem itemRepo;
    @Inject
    RepoOrder orderRepo;
    @Inject
    RepoWizard wizardRepo;


    public Optional<Wizard> loadWizard(String name) {
        Optional<Wizard> wizard = wizardRepo.findByIdOptional(name);
        return wizard.isPresent() ? wizard : Optional.empty();
    }
    public Optional<MagicalItem> loadItem(String item) {
        return itemRepo.findByItemName(item);
    }
    public Optional<MagicalItem> loadItem(MagicalItem item) {
        List<MagicalItem> allItems = itemRepo.listAll();
        Optional<MagicalItem> targetItem = allItems
                .stream()
                .filter(i-> i.equals(item))
                .findAny();
        return targetItem.isPresent() ? targetItem : Optional.empty();
    }
    public List<MagicalItem> loadItems(String itemName){
        List<MagicalItem> items = new ArrayList<>();
        for (MagicalItem item : itemRepo.listAll()) {
            if (item.getName().equals(itemName)) {
                items.add(item);
            }
        }
        return items;
    }
    @Transactional
    public Optional<MagicalItem> createItem(String name, int quality, String type) {
        Optional<MagicalItem> item = Optional.of(new MagicalItem(name, quality, type));
        itemRepo.persist(item.get());
        return this.loadItem(item.get());
    }

    public Optional<Order> placeOrder(String wizardName, String itemName) {
        Optional<Order> orden = Optional.empty();
        Optional<MagicalItem> item = this.loadItem(itemName);
        Optional<Wizard> wizard = this.loadWizard(wizardName);
        if (wizard.get().getWizardPerson().toString() != "MUDBLOOD"){
            orden = Optional.of(new Order(wizard.get(), item.get()));
            orderRepo.persist(orden.get());
        }
        return orden;
    }

    public void createItems(List<MagicalItem> items) {
        for (MagicalItem item : items){
            itemRepo.persist(item);
        }
    }
}
