package app.isa.domain.dto.converters;

import app.isa.domain.dto.DTO.AppointmentDTO;
import app.isa.domain.dto.DTO.AppointmentReportDTO;
import app.isa.domain.model.Appointment;
import app.isa.domain.model.AppointmentReport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;



public class AppointmentReposrtConverter {

    public static AppointmentReport fromDTO(AppointmentReportDTO appointmentReportDTO) {

        AppointmentReport appointmentReport = new AppointmentReport();
        appointmentReport.setId(appointmentReportDTO.getId());
        appointmentReport.setBlockClient(appointmentReportDTO.isBlockClient());
        appointmentReport.setText(appointmentReportDTO.getText());
        appointmentReport.setClientMissReservation(appointmentReportDTO.isClientMissReservation());
        appointmentReport.setOwner(null);
        appointmentReport.setClient(null);
        appointmentReport.setHouse(null);

        return appointmentReport;
    }

    public static AppointmentReportDTO toDTO(AppointmentReport appointmentReport){
        AppointmentReportDTO appointmentReportDTO = new AppointmentReportDTO();

        appointmentReportDTO.setId(appointmentReport.getId());
        appointmentReportDTO.setHouseId(appointmentReport.getHouse().getId());
        appointmentReportDTO.setClientMissReservation(appointmentReport.isClientMissReservation());
        appointmentReportDTO.setBlockClient(appointmentReport.isBlockClient());
        appointmentReportDTO.setClientId(appointmentReport.getClient().getId());
        appointmentReportDTO.setText(appointmentReport.getText());
        appointmentReportDTO.setOwnerId(appointmentReport.getOwner().getId());

        if(appointmentReport.getClient() != null && appointmentReport.getClient().getId()!=null)
        {
            appointmentReportDTO.setClientId(appointmentReport.getClient().getId());
            appointmentReportDTO.setHouseId(appointmentReport.getHouse().getId());
        }


        return appointmentReportDTO;
    }

    public static List<AppointmentReportDTO> toDTOList(List<AppointmentReport> reports){
        ArrayList<AppointmentReportDTO> appointmentReportDTOS = new ArrayList<AppointmentReportDTO>();
        for(AppointmentReport appointmentReport : reports){
            appointmentReportDTOS.add(toDTO(appointmentReport));
        }
        return  appointmentReportDTOS;
    }
}
