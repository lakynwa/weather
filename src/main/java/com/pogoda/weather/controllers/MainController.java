package com.pogoda.weather.controllers;

import com.pogoda.weather.models.WorldWth;
import com.pogoda.weather.models.WorldWth1;
import com.pogoda.weather.repo.WorldWthRepository;
import com.pogoda.weather.repo.WthRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Component
public class MainController {
private static WthRepository wthRepository;
       private static Document getPage1() throws IOException {
        String url="https://world-weather.ru/pogoda/russia/ufa/";
        Document page= Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void Ufafirst() throws IOException {
        String date,  temperature,  town,  vlaj,  davl,  yavl;
        Document page = getPage1();
        Element tableWth = page.select("div[id=content-left]").first();
        String number_month = tableWth.selectFirst("div[class=numbers-month]").text();
        String month = tableWth.selectFirst("div[class=month]").text();
        date = number_month + " " + month;
        temperature = tableWth.selectFirst("div[id=weather-now-number]").text();
        town = tableWth.selectFirst("span[id=bread-crumbs-c]").text();
        vlaj = tableWth.selectFirst("td[class=weather-humidity]").text();
        davl = tableWth.selectFirst("td[class=weather-pressure]").text();
        yavl = tableWth.selectFirst("span[class=dw-into]").text();
        yavl = "Ясно";
       WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
       // WthRepository wthRepository=null;
       //         worldWth = wthRepository.save(worldWth);
        System.out.println(date + "       Явления     Температура    Давл   Влажность");
        System.out.println("По данным сервиса world-weather.ru");
        System.out.println(worldWth.getTown() + "              " + worldWth.getYavl() + "          " + worldWth.getTemp() + "         " + worldWth.getDavl() + "       " + worldWth.getVlaj());
    }
    private static Document getPage2() throws IOException {
        String url="https://world-weather.ru/pogoda/russia/arkhangelskoye_1/";
        Document page= Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void Arhfirst() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl;
        Document page = getPage2();
        Element tableWth = page.select("div[id=content-left]").first();
        temperature = tableWth.selectFirst("div[id=weather-now-number]").text();
        town = tableWth.selectFirst("span[id=bread-crumbs-c]").text();
        vlaj = tableWth.selectFirst("td[class=weather-humidity]").text();
        davl = tableWth.selectFirst("td[class=weather-pressure]").text();
        yavl = tableWth.selectFirst("span[class=dw-into]").text();
        yavl = "Ясно";
        System.out.println(town + "    " + yavl + "          " + temperature + "         " + davl + "       " + vlaj);
    }
    private static Document getPage3() throws IOException {
        String url="https://world-weather.ru/pogoda/russia/uchaly/";
        Document page= Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void Uchalufirst() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl;
        Document page = getPage3();
        Element tableWth = page.select("div[id=content-left]").first();
        temperature = tableWth.selectFirst("div[id=weather-now-number]").text();
        town = tableWth.selectFirst("span[id=bread-crumbs-c]").text();
        vlaj = tableWth.selectFirst("td[class=weather-humidity]").text();
        davl = tableWth.selectFirst("td[class=weather-pressure]").text();
        yavl = tableWth.selectFirst("span[class=dw-into]").text();
        yavl = "Ясно";
        System.out.println(town + "            " + yavl + "          " + temperature + "         " + davl + "       " + vlaj);
    }
    private static Document getPage4() throws IOException {
        String url="https://www.gismeteo.ru/weather-ufa-4588/now/";
        Document page= Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void Ufasecond() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl;
        Document page = getPage4();
        Element tableWth = page.select("div[class=now]").first();
        temperature = tableWth.selectFirst("span[class=unit unit_temperature_c]").text();
        town = "Уфа";
        vlaj = tableWth.selectFirst("div[class=now-info-item humidity]").text();
        davl = tableWth.selectFirst("div[class=unit unit_pressure_mm_hg_atm]").text();
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(davl);
        if (matcher.find())
        {
            davl = matcher.group();
        }
        yavl = tableWth.selectFirst("div[class=now-desc]").text();
        Pattern pattern1 = Pattern.compile("\\d{2}\\s\\W");
        Matcher matcher1 = pattern1.matcher(vlaj);
        if (matcher1.find())
        {
            vlaj = matcher1.group();
        }
        System.out.println("По данным сервиса gismeteo.ru");
        System.out.println(town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
    }
    private static Document getPage5() throws IOException {
        String url="https://www.gismeteo.ru/weather-arkhangelskoye-4591/now/";
        Document page= Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void Arhsecond() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl;
        Document page = getPage5();
        Element tableWth = page.select("div[class=now]").first();
        temperature = tableWth.selectFirst("span[class=unit unit_temperature_c]").text();
        town = "Архангельское";
        vlaj = tableWth.selectFirst("div[class=now-info-item humidity]").text();
        davl = tableWth.selectFirst("div[class=unit unit_pressure_mm_hg_atm]").text();
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(davl);
        if (matcher.find())
        {
            davl = matcher.group();
        }
        yavl = tableWth.selectFirst("div[class=now-desc]").text();
        Pattern pattern1 = Pattern.compile("\\d{2}\\s\\W");
        Matcher matcher1 = pattern1.matcher(vlaj);
        if (matcher1.find())
        {
            vlaj = matcher1.group();
        }
        System.out.println(town + "    " + yavl + "          " + temperature + "        " + davl + "       " + vlaj);
    }
    private static Document getPage6() throws IOException {
        String url="https://www.gismeteo.ru/weather-uchaly-4592/now/";
        Document page= Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void Uchalusecond() throws IOException {
        String date, temperature,  town,  vlaj,  davl,  yavl;
        Document page = getPage6();
        Element tableWth = page.select("div[class=now]").first();
        temperature = tableWth.selectFirst("span[class=unit unit_temperature_c]").text();
        town = "Учалы";
        vlaj = tableWth.selectFirst("div[class=now-info-item humidity]").text();
        davl = tableWth.selectFirst("div[class=unit unit_pressure_mm_hg_atm]").text();
        Pattern pattern = Pattern.compile("\\d{3}");
        Matcher matcher = pattern.matcher(davl);
        if (matcher.find())
        {
            davl = matcher.group();
        }
        yavl = tableWth.selectFirst("div[class=now-desc]").text();
        Pattern pattern1 = Pattern.compile("\\d{2}\\s\\W");
        Matcher matcher1 = pattern1.matcher(vlaj);
        if (matcher1.find())
        {
            vlaj = matcher1.group();
        }
        //date = "31.08.22";
       // WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        //wthRepository.save(worldWth);
        System.out.println(town + "         " + yavl + "      " + temperature + "        " + davl + "       " + vlaj);
    }

    @Autowired
    private WorldWthRepository worldWthRepository;
    @GetMapping("/")
    public String home(Model model){
        Iterable<WorldWth> worldWths = worldWthRepository.findAll();
        model.addAttribute("worldWths",worldWths);
        //  model.addAttribute("date", WorldWth.date);
        //System.out.println(WorldWth.date);
        //  model.addAttribute("town", WorldWth.town);
        //model.addAttribute("yavl", WorldWth.yavl);
        //  model.addAttribute("vlaj", WorldWth.vlaj);
        //   model.addAttribute("davl", WorldWth.davl);
        //   model.addAttribute("temp", WorldWth.temp);

        return "home";
    }
}
