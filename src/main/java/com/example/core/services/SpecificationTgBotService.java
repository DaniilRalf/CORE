package com.example.core.services;

import com.example.core.repositories.SpecificationTgBotRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecificationTgBotService {

    private final SpecificationTgBotRepository specificationTgBotRepository;

    public SpecificationTgBotService(SpecificationTgBotRepository specificationTgBotRepository) {
        this.specificationTgBotRepository = specificationTgBotRepository;
    }

    public boolean checkSpecification(String nameBot) {
        return this.specificationTgBotRepository.checkSpecification(nameBot).isPresent();
    }
}
