package app.isa.service;

import app.isa.domain.dto.DTO.ActionBoatDTO;
import app.isa.domain.dto.converters.ActionBoatConverter;
import app.isa.domain.model.ActionBoat;
import app.isa.domain.model.Boat;
import app.isa.repository.ActionBoatRepository;
import app.isa.repository.BoatRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionBoatServiceImplemetation implements ActionBoatService{

    @Autowired
    private ActionBoatService actionBoatService;

    @Autowired
    private ActionBoatRepository actionBoatRepository;

    @Autowired
    private BoatRepository boatRepository;


    @Override
    public List<ActionBoat> getForBoat(Long id) {
        return actionBoatRepository.getAllByBoat(boatRepository.findById(id).get());
    }

    @Override
    public ActionBoat add(ActionBoatDTO actionBoatDTO) {
        ActionBoat actionBoat = ActionBoatConverter.fromDTO(actionBoatDTO);
        Optional<Boat> boat = boatRepository.findById(actionBoatDTO.getBoatId());
        actionBoat.setBoat(boat.get());
        return  actionBoatRepository.save(actionBoat);
    }

    @Override
    public ActionBoat edit(Long id, ActionBoatDTO actionBoatDTO) {
        Optional<ActionBoat> actionBoat = actionBoatRepository.findById(id);

        if(actionBoat.isEmpty()){
            return  null;
        }

        ActionBoat actionBoat1 = ActionBoatConverter.fromDTO(actionBoatDTO);

        actionBoat.get().setPrice(actionBoat1.getPrice());
        actionBoat.get().setBoat(actionBoat1.getBoat());
        actionBoat.get().setDateTo(actionBoat1.getDateTo());
        actionBoat.get().setDateFrom(actionBoat1.getDateFrom());
        actionBoat.get().setAdditionalServices(actionBoat1.getAdditionalServices());
        actionBoat.get().setDeleted(actionBoat1.isDeleted());
        return actionBoatRepository.save(actionBoat.get());
    }

    @Override
    public boolean delete(Long id) {
        Optional<ActionBoat> actionBoat = actionBoatRepository.findById(id);

        if(actionBoat.isEmpty()){
            return false;
        }
        actionBoat.get().setDeleted(true);
        actionBoatRepository.save(actionBoat.get());
        return true;
    }

    @Override
    public ActionBoat getAction(Long id) {
        Optional<ActionBoat> actionBoat = actionBoatRepository.findById(id);

        if(actionBoat.isEmpty()){
            return  null;
        }
        return actionBoat.get();
    }
}
