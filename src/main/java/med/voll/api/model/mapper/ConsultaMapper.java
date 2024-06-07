package med.voll.api.model.mapper;

import med.voll.api.model.dto.DadosAgendamentoConsultaDTO;
import med.voll.api.model.entity.Consulta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    DadosAgendamentoConsultaDTO toDTO(Consulta entity);

    Consulta toEntity(DadosAgendamentoConsultaDTO dto);
}
