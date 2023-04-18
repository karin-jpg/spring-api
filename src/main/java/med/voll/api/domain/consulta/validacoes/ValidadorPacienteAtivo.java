package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {


    private PacienteRepository pacienteRepository;
    public void validar(DadosAgendamentoConsulta dados) {


        var medicoEstaAtivo = pacienteRepository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidationException("Consulta não pode ser agendada com médico inativo");
        }
    }
}
