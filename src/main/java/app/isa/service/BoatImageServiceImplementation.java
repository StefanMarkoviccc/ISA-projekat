package app.isa.service;

import app.isa.domain.dto.DTO.BoatImageDTO;
import app.isa.domain.dto.converters.BoatImageConverter;
import app.isa.domain.model.Boat;
import app.isa.domain.model.BoatImage;
import app.isa.repository.BoatImageRepository;
import app.isa.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatImageServiceImplementation implements  BoatImageService{

    @Autowired
    private BoatImageRepository boatImageRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Override
    public List<BoatImage> getList(Long id){
        Optional<Boat> boat = boatRepository.findById(id);
        return boatImageRepository.findAllByBoat(boat.get());
    }

    @Override
    public BoatImage getBoatImage(Long id){
        Optional<BoatImage> boatImage = boatImageRepository.findById(id);

        if(boatImage.isEmpty()){
            return null;
        }
        return  boatImage.get();
    }

    @Override
    public BoatImage add(BoatImageDTO boatImageDTO){
        BoatImage boatImage = BoatImageConverter.fromDTO(boatImageDTO);
        boatImage.setBoat(boatRepository.getById(boatImageDTO.getBoatId()));
        return boatImageRepository.save(boatImage);
    }
}
