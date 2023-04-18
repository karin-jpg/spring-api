package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {

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
