package com.pogoda.weather;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

import static com.pogoda.weather.controllers.MainController.*;


@SpringBootApplication

public class WeatherApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(WeatherApplication.class, args);
	}
	}
