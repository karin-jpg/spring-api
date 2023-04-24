package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesFuncionamentoClinida = dataConsulta.getHour() < 7;
        var depoisFuncionamentoClinica = dataConsulta.getHour() > 18;
        if (domingo || antesFuncionamentoClinida || depoisFuncionamentoClinica) {
            throw new ValidationException("Dia e/ou horário fora do horário de funcionamento da clínica");
        }
    }
}
