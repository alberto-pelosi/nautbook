package com.codermine.cookbook.service;

import com.codermine.cookbook.exception.CookbookException;
import com.codermine.cookbook.model.Dose;
import com.codermine.cookbook.repository.DoseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Singleton
public class DoseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private DoseRepository doseRepository;

    public Dose insertDose(@NotNull @Valid Dose dose) {
        logger.info("DoseService - insertDose - start - dose: {}", dose);
        List<Dose> doses = doseRepository.findByRecipe(dose.getRecipe());

        doses.stream().filter(d -> d.getIngredient().getId().equals(dose.getIngredient().getId()))
                .findAny().ifPresentOrElse(d -> {throw new CookbookException("Dose already present: " + d);},() -> doseRepository.save(dose));

        Dose savedDose = doseRepository.findByRecipe(dose.getRecipe()).stream().filter(d -> d.getIngredient().getId().equals(dose.getIngredient().getId()))
                .findAny().orElseThrow(() -> new CookbookException("Unable to save dose: " + dose));

        logger.info("DoseService - insertDose - stop - savedDose: {}", savedDose);
        return savedDose;
    }

}
