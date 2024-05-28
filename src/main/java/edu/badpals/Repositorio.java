package edu.badpals;

import edu.badpals.domain.MagicalItem;
import edu.badpals.domain.Wizard;
import edu.badpals.repository.RepoMagicalItem;
import edu.badpals.repository.RepoOrder;
import edu.badpals.repository.RepoWizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

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
        return wizard;
    }
      public Optional<MagicalItem> loadItem(String item) {
        return itemRepo.findByItemName(item);

    }
    @Transactional
    public Optional<MagicalItem> createItem(String name, int quality, String type) {
        Optional<MagicalItem> item = Optional.of(new MagicalItem(name, quality, type));
        itemRepo.persist(item.get());
        return this.loadItem(String.valueOf(item));
    }
}
