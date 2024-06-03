package med.voll.api.model.mapper;

import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.model.entity.Medico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    Medico toEntity(CadastroMedicoDTO dto);

    CadastroMedicoDTO toDTO(Medico entity);
}
