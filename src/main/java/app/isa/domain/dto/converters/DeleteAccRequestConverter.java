package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.DeleteAccRequestDTO;
import app.isa.domain.model.DeleteAccRequest;

import java.util.ArrayList;
import java.util.List;

public class DeleteAccRequestConverter {

    public static DeleteAccRequest fromDTO(DeleteAccRequestDTO deleteAccRequestDTO){
        DeleteAccRequest deleteAccRequest = new DeleteAccRequest();
        deleteAccRequest.setText(deleteAccRequestDTO.getText());
        deleteAccRequest.setUserId(deleteAccRequestDTO.getUserId());
        deleteAccRequest.setRejected(deleteAccRequestDTO.isRejected());
        return deleteAccRequest;
    }

    public static DeleteAccRequestDTO toDTO(DeleteAccRequest deleteAccRequest){
        DeleteAccRequestDTO deleteAccRequestDTO = new DeleteAccRequestDTO();
        deleteAccRequestDTO.setText(deleteAccRequest.getText());
        deleteAccRequestDTO.setUserId(deleteAccRequest.getUserId());
        deleteAccRequestDTO.setRejected(deleteAccRequest.isRejected());
        return deleteAccRequestDTO;
    }

    public static List<DeleteAccRequestDTO> toDTOList(List<DeleteAccRequest> deleteAccRequests){
        ArrayList<DeleteAccRequestDTO> deleteAccRequestDTOList = new ArrayList<DeleteAccRequestDTO>();
        for(DeleteAccRequest deleteAccRequest : deleteAccRequests) {
            deleteAccRequestDTOList.add(toDTO(deleteAccRequest));
            }
        return deleteAccRequestDTOList;
        }

}
