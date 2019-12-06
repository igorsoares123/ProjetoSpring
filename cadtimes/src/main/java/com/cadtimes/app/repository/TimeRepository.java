package com.cadtimes.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.cadtimes.app.models.Time;


public interface TimeRepository extends CrudRepository<Time, Long> {

}
