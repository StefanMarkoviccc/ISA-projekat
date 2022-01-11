package app.isa.service;

import app.isa.domain.dto.DTO.ComplainDTO;
import app.isa.domain.model.Complain;

import java.util.List;

public interface ComplainService {

    Complain getComplain(Long id);
    List<Complain> getList();
    Complain add(ComplainDTO complainDTO);

}
