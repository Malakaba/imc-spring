package com.example.imcmatheus.controller;

import com.example.imcmatheus.model.Imc;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ImcController {

    @GetMapping("/imc")
    public Map<String, String> calculeImc(@RequestParam Map<String, String> allParams) {
        HashMap<String, String> map = new HashMap<>();
        try {
            float peso = Float.parseFloat(allParams.get("peso"));
            float altura = Float.parseFloat(allParams.get("altura"));
            Imc imc = new Imc(peso, altura);
            imc.imcCalculate();

            map.put("imc", Float.toString(imc.getImc()));
            map.put("classificacao", imc.getClassificacao());
            map.put("risco", imc.getRisco());

            return map;
        } catch (Exception exception) {
            map.clear();
            map.put("error", "Something went wrong...");
            return map;
        }
    }

}
