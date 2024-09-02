package com.matheus.gestor_datas.services;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Service
public class DatasService {
    
    private LocalDate dataInicial;
    private LocalDate dataFinal;


    public DatasService() {
        // Define a data inicial padrão como 26 de agosto de 2024
        this.dataInicial = LocalDate.of(2024, 8, 26);
        this.dataFinal = LocalDate.now();
    }

    public LocalDate getDataInicial() {
        return this.dataInicial;
    }

    public LocalDate getDataFinal() {
        return this.dataFinal;
    }

    public void setDataInicial(LocalDate dataInicial){
        this.dataInicial = dataInicial;
    }

    public long calcularDiasEntreDatas() {
        return ChronoUnit.DAYS.between(dataInicial, dataFinal);
    }
    
}
