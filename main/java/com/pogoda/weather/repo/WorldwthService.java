package com.pogoda.weather.repo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pogoda.weather.models.WorldWth;
import org.apache.coyote.Response;
import org.aspectj.weaver.ast.Var;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
 import java.net.MalformedURLException;
 import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pogoda.weather.repo.WorldService;
@Service
public class WorldwthService {
    @Autowired
    WthRepository wthRepository;
    public void save(WorldWth worldWth) {
        wthRepository.save(worldWth);
       }
    public void Ufafirst() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl, date;
        String url = "https://api.weatherapi.com/v1/current.json?key=9a2cdb0b2f6740449ec122015222009&q=Ufa&aqi=yes&lang=ru";
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(url).openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) !=null) {
            stringBuilder.append(line);
        }
        JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
        town = jsonObject.getJSONObject("location").getString("region");
        yavl = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
        temperature = jsonObject.getJSONObject("current").getString("temp_c");
        davl = jsonObject.getJSONObject("current").getString("pressure_mb");
        vlaj = jsonObject.getJSONObject("current").getString("humidity");
        date = jsonObject.getJSONObject("location").getString("localtime");
        Pattern pattern = Pattern.compile("\\S{10}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find())
        {
            date = matcher.group();
        }
         System.out.println(date + " "+town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
        WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        this.wthRepository.save(worldWth);
    }
    public void Uchalyfirst() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl, date;
        String url = "https://api.weatherapi.com/v1/current.json?key=9a2cdb0b2f6740449ec122015222009&q=Uchaly&aqi=yes&lang=ru";
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(url).openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) !=null) {
            stringBuilder.append(line);
        }
        JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
        town = jsonObject.getJSONObject("location").getString("name");
        yavl = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
        temperature = jsonObject.getJSONObject("current").getString("temp_c");
        davl = jsonObject.getJSONObject("current").getString("pressure_mb");
        vlaj = jsonObject.getJSONObject("current").getString("humidity");
        date = jsonObject.getJSONObject("location").getString("localtime");
        Pattern pattern = Pattern.compile("\\S{10}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find())
        {
            date = matcher.group();
        }
        System.out.println(date + " "+town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
        WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        this.wthRepository.save(worldWth);
    }
    public void Belebeyfirst() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl, date;
        String url = "https://api.weatherapi.com/v1/current.json?key=9a2cdb0b2f6740449ec122015222009&q=Belebey&aqi=yes&lang=ru";
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(url).openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) !=null) {
            stringBuilder.append(line);
        }
        JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
        town = jsonObject.getJSONObject("location").getString("name");
        yavl = jsonObject.getJSONObject("current").getJSONObject("condition").getString("text");
        temperature = jsonObject.getJSONObject("current").getString("temp_c");
        davl = jsonObject.getJSONObject("current").getString("pressure_mb");
        vlaj = jsonObject.getJSONObject("current").getString("humidity");
        date = jsonObject.getJSONObject("location").getString("localtime");
        Pattern pattern = Pattern.compile("\\S{10}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find())
        {
            date = matcher.group();
        }
        System.out.println(date + " "+town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
        WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        this.wthRepository.save(worldWth);
    }
    public void Ufasecond() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl, date;
       String url = "https://api.weatherbit.io/v2.0/current?&city=Ufa&country=Russia&key=92475e4a4f7546f18a573f48700606b0&lang=ru";
       HttpURLConnection connection = null;
       connection = (HttpURLConnection) new URL(url).openConnection();
       StringBuilder stringBuilder = new StringBuilder();
       BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
       String line;
       while ((line = in.readLine()) !=null) {
           stringBuilder.append(line);
       }
       JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
       town = jsonObject.getJSONArray("data").getJSONObject(0).getString("city_name");
       yavl = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("weather").getString("description");
       temperature = jsonObject.getJSONArray("data").getJSONObject(0).getString("temp");
       davl = jsonObject.getJSONArray("data").getJSONObject(0).getString("pres");
       vlaj = jsonObject.getJSONArray("data").getJSONObject(0).getString("rh");
       date = jsonObject.getJSONArray("data").getJSONObject(0).getString("ob_time");
       Pattern pattern = Pattern.compile("\\S{10}");
       Matcher matcher = pattern.matcher(date);
       if (matcher.find())
       {
           date = matcher.group();
       }
        System.out.println(date + " "+town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
       WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        this.wthRepository.save(worldWth);
        }
    public void Uchalysecond() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl, date;
        String url = "https://api.weatherbit.io/v2.0/current?&city=Uchaly&country=Russia&key=92475e4a4f7546f18a573f48700606b0&lang=ru";
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(url).openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) !=null) {
            stringBuilder.append(line);
        }
        JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
        town = jsonObject.getJSONArray("data").getJSONObject(0).getString("city_name");
        yavl = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("weather").getString("description");
        temperature = jsonObject.getJSONArray("data").getJSONObject(0).getString("temp");
        davl = jsonObject.getJSONArray("data").getJSONObject(0).getString("pres");
        vlaj = jsonObject.getJSONArray("data").getJSONObject(0).getString("rh");
        date = jsonObject.getJSONArray("data").getJSONObject(0).getString("ob_time");
        Pattern pattern = Pattern.compile("\\S{10}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find())
        {
            date = matcher.group();
        }
        System.out.println(date + " "+town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
        WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        this.wthRepository.save(worldWth);
    }
    public void Belebeysecond() throws IOException {
        String  temperature,  town,  vlaj,  davl,  yavl, date;
        String url = "https://api.weatherbit.io/v2.0/current?&city=Belebey&country=Russia&key=92475e4a4f7546f18a573f48700606b0&lang=ru";
        HttpURLConnection connection = null;
        connection = (HttpURLConnection) new URL(url).openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) !=null) {
            stringBuilder.append(line);
        }
        JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
        town = jsonObject.getJSONArray("data").getJSONObject(0).getString("city_name");
        yavl = jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("weather").getString("description");
        temperature = jsonObject.getJSONArray("data").getJSONObject(0).getString("temp");
        davl = jsonObject.getJSONArray("data").getJSONObject(0).getString("pres");
        vlaj = jsonObject.getJSONArray("data").getJSONObject(0).getString("rh");
        date = jsonObject.getJSONArray("data").getJSONObject(0).getString("ob_time");
        Pattern pattern = Pattern.compile("\\S{10}");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find())
        {
            date = matcher.group();
        }
        System.out.println(date + " "+town + "              " + yavl + "          " + temperature + "          " + davl + "       " + vlaj);
        WorldWth worldWth = new WorldWth(date,town, temperature,yavl, vlaj, davl);
        this.wthRepository.save(worldWth);
    }
}
