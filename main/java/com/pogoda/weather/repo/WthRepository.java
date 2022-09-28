package com.pogoda.weather.repo;

import com.pogoda.weather.models.WorldWth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WthRepository extends CrudRepository<WorldWth, Long> {

}
