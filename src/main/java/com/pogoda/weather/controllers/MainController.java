package com.pogoda.weather.controllers;

import com.pogoda.weather.models.WorldWth;
import com.pogoda.weather.repo.WorldService;
import com.pogoda.weather.repo.WorldWthRepository;
import com.pogoda.weather.repo.WthRepository;
import com.pogoda.weather.repo.WorldwthService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

import javax.persistence.Id;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MainController {
    @Autowired
    private WorldwthService worldService;

    @Autowired
    private WorldWthRepository worldWthRepository;

    @GetMapping("/")
    public String home(Model model) throws IOException {
        WorldWth worldWthufasecond = null;
        worldService.Ufafirst();
        worldService.Uchalyfirst();
        worldService.Belebeyfirst();
        worldService.Ufasecond();
         worldService.Uchalysecond();
        worldService.Belebeysecond();
        long max=worldWthRepository.count();
        model.addAttribute("Ufafirst",worldWthRepository.findById(max-3).get());
        model.addAttribute("Uchalyfirst",worldWthRepository.findById(max-2).get());
        model.addAttribute("Belebeyfirst",worldWthRepository.findById(max-1).get());
        model.addAttribute("Ufasecond",worldWthRepository.findById(max).get());
         model.addAttribute("Uchalysecond",worldWthRepository.findById(max+1).get());
         model.addAttribute("Belebeysecond",worldWthRepository.findById(max+2).get());
        return "home";
    }

}
