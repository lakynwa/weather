package com.pogoda.weather.controllers;

import com.pogoda.weather.repo.WorldWthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HistoryController {
    @Autowired
    private WorldWthRepository worldWthRepository;
    @GetMapping("/history")
    public String allDB(Model model) throws IOException {
        model.addAttribute("worldwths",worldWthRepository.findAll());
        return "allDB";
    }
}
