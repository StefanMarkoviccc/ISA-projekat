package app.isa.service;

import app.isa.domain.dto.DTO.ActionHouseDTO;
import app.isa.domain.dto.converters.ActionHouseConverter;
import app.isa.domain.model.ActionHouse;
import app.isa.domain.model.House;
import app.isa.domain.model.Room;
import app.isa.repository.ActionHouseRepository;
import app.isa.repository.HouseRepository;
import app.isa.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionHouseServiceImplementation implements ActionHouseService {
    @Autowired
    private ActionHouseService actionHouseService;

    @Autowired
    private ActionHouseRepository actionHouseRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<ActionHouse> getForHouse(Long id) {
        return actionHouseRepository.getAllByHouse(houseRepository.findById(id).get());
    }

    @Override
    public ActionHouse add(ActionHouseDTO actionHouseDTO) {
        ActionHouse actionHouse = ActionHouseConverter.fromDTO(actionHouseDTO);
        Optional<House> house = houseRepository.findById(actionHouseDTO.getHouseId());
        actionHouse.setHouse(house.get());
        Optional<Room> room = roomRepository.findById(actionHouseDTO.getRoomId());
        actionHouse.setRoom(room.get());
        return actionHouseRepository.save(actionHouse);
    }

    @Override
    public ActionHouse edit(Long id, ActionHouseDTO actionHouseDTO) {

        Optional<ActionHouse> actionHouse = actionHouseRepository.findById(id);

        if(actionHouse.isEmpty())
        {
            return null;
        }

        ActionHouse actionHouse1 = ActionHouseConverter.fromDTO(actionHouseDTO);

        actionHouse.get().setPrice(actionHouse1.getPrice());
        actionHouse.get().setHouse(actionHouse1.getHouse());
        actionHouse.get().setDateTo(actionHouse1.getDateTo());
        actionHouse.get().setDateFrom(actionHouse1.getDateFrom());
        actionHouse.get().setRoom(actionHouse1.getRoom());
        actionHouse.get().setDeleted(actionHouse1.isDeleted());

        return  actionHouseRepository.save(actionHouse.get());
    }

    @Override
    public boolean delete(Long id) {
        Optional<ActionHouse> actionHouse = actionHouseRepository.findById(id);

        if(actionHouse.isEmpty())
        {
            return false;
        }

        actionHouse.get().setDeleted(true);
        actionHouseRepository.save(actionHouse.get());
        return true;
    }

    @Override
    public ActionHouse getAction(Long id) {
        Optional<ActionHouse> actionHouse = actionHouseRepository.findById(id);

        if(actionHouse.isEmpty()){
            return null;
        }
        return  actionHouse.get();
    }
}
