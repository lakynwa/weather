package com.pogoda.weather.repo;

import com.pogoda.weather.models.WorldWth;

import java.util.Optional;

public interface WorldService {
    void save (WorldWth worldWth);
}
