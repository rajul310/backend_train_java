package com.app.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.Category;
import com.app.entities.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {
    List<Train> findByTrainType(Category trainType);
}

