package med.voll.api.model.mapper;

import med.voll.api.model.dto.EnderecoDTO;
import med.voll.api.model.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEntity(EnderecoDTO dto);

    EnderecoDTO toDTO(Endereco entity);
}
