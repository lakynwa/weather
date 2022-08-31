package com.pogoda.weather.controllers;

import com.pogoda.weather.models.WorldWth;
import com.pogoda.weather.models.WorldWth1;
import com.pogoda.weather.repo.WorldWthRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MainService {
    private final WorldWthRepository worldWthRepository;

    public MainService(WorldWthRepository worldWthRepository) {
        this.worldWthRepository = worldWthRepository;
    }

    @GetMapping(path = "worldWths")
    public List<WorldWth> list(){
        return (List<WorldWth>) worldWthRepository.findAll();
    }
    public void add(WorldWth worldWth)
    {
        worldWthRepository.save(worldWth);
    }
}
