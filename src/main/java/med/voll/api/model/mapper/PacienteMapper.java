package med.voll.api.model.mapper;

import med.voll.api.model.dto.AtualizarPacienteDTO;
import med.voll.api.model.dto.CadastroPacienteDTO;
import med.voll.api.model.dto.ListagemPacienteDTO;
import med.voll.api.model.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PacienteMapper {

    Paciente toEntity(CadastroPacienteDTO dto);

    CadastroPacienteDTO toDTO(Paciente entity);

    ListagemPacienteDTO toListagemDTO(Paciente entity);

    @Mapping(target = "id", ignore = true)
    Paciente toEntity(@MappingTarget Paciente entity, AtualizarPacienteDTO dto);
}
