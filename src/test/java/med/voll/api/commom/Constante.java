package med.voll.api.commom;

import med.voll.api.model.entity.Endereco;
import med.voll.api.model.entity.Medico;
import med.voll.api.model.entity.Paciente;
import med.voll.api.model.enums.EspecialidadeEnum;

public class Constante {

    public static final Endereco ENDERECO = new Endereco("rua x",
        "bairro y",
        "1228720",
        "contagem",
        "MG",
        "",
        "123"
    );

    public static final Medico MEDICO_CARDIOLOGIA_ATIVO = new Medico(
            null,
            "medico",
            "31999999999",
            "medico@email.com",
            "123456",
            EspecialidadeEnum.CARDIOLOGIA,
            ENDERECO,
            Boolean.TRUE
    );

    public static final Paciente PACIENTE_ATIVO = new Paciente(
            null,
            "paciente",
            "paciente@email.com",
            "31829287651",
            "72899272640",
            ENDERECO,
            Boolean.TRUE
    );
}
