package app.isa.service;

import app.isa.domain.dto.DTO.AdventureDTO;
import app.isa.domain.model.Adventure;

import java.util.List;

public interface AdventureService {

    Adventure add(AdventureDTO adventureDTO);
    boolean deleted(Long id);
    List<Adventure> getList();
    Adventure getAdventure(Long id);
    Adventure edit(Long id, AdventureDTO adventureDTO);
}
