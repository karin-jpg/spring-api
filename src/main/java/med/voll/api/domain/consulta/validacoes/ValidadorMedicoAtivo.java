package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMedicoAtivo {

    private MedicoRepository medicoRepository;
    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidationException("Consulta não pode ser agendada com médico inativo");
        }
    }

}
