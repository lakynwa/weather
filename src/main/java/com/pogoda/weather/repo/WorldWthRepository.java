package com.pogoda.weather.repo;

import com.pogoda.weather.models.WorldWth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldWthRepository extends CrudRepository<WorldWth, Long> {
}
