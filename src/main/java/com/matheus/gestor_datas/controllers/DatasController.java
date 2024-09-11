package com.matheus.gestor_datas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

import com.matheus.gestor_datas.services.DatasService;

@RestController
@RequestMapping("/datas")
public class DatasController {

    private final DatasService datasService;

    public DatasController(DatasService datasService) {
        this.datasService = datasService;
    }

    @GetMapping("/inicial")
    public LocalDate exibeInicial(){
        return datasService.getDataInicial();
    }

    @GetMapping("/final")
    public LocalDate exibeFinal(){
        return datasService.getDataFinal();
    }

    @GetMapping
    public LocalDate[] exibeDatas(){
        LocalDate[] datas = new LocalDate[2];
        datas[0] = datasService.getDataInicial();
        datas[1] = datasService.getDataFinal(); 
        return datas;
    }

    @PostMapping("/atualiza")
    public String atualizaDataInicial(@RequestBody Integer[] dataArray) {
        try{
            LocalDate novaDataInicial = LocalDate.of(dataArray[0], dataArray[1], dataArray[2]);
            datasService.setDataInicial(novaDataInicial);
            return "A data inicial foi atualizada para: " + novaDataInicial;
        } catch(IllegalArgumentException e){
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/dias/quantidade")
    public Long buscaQuantidadeDias() {
        return datasService.calcularDiasEntreDatas();
    }

}
