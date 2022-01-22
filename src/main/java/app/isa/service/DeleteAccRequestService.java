package app.isa.service;

import app.isa.domain.dto.DTO.DeleteAccRequestDTO;
import app.isa.domain.model.DeleteAccRequest;

import java.util.List;

public interface DeleteAccRequestService {
    DeleteAccRequest getDeleteAccRequest(Long id);
    List<DeleteAccRequest> getList();
    DeleteAccRequest add(DeleteAccRequestDTO deleteAccRequestDTO);
}
