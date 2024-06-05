package med.voll.api.model.mapper;

import med.voll.api.model.dto.AtualizarMedicoDTO;
import med.voll.api.model.dto.CadastroMedicoDTO;
import med.voll.api.model.dto.ListagemMedicoDTO;
import med.voll.api.model.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicoMapper {

    Medico toEntity(CadastroMedicoDTO dto);

    CadastroMedicoDTO toDTO(Medico entity);

    ListagemMedicoDTO toListagemDTO(Medico entity);

    @Mapping(target = "id", ignore = true)
    Medico toEntity(@MappingTarget Medico entity, AtualizarMedicoDTO dto);

}
