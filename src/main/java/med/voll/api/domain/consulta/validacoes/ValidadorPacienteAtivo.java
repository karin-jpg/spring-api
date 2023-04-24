package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentoConsulta dados) {


        var medicoEstaAtivo = pacienteRepository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidationException("Consulta não pode ser agendada com médico inativo");
        }
    }
}
