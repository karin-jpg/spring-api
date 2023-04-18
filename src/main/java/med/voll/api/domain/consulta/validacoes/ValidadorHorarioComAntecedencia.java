package med.voll.api.domain.consulta.validacoes;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioComAntecedencia {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();

        var diferencaTempo = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaTempo < 30) {
            throw new ValidationException("Consulta deve ser agendada com antecedencia minima de 30 minutos");
        }
    }
}
