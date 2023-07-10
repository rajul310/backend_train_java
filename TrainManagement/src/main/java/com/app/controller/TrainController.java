package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponseDTO;
import com.app.dto.TrainDTO;
import com.app.entities.Category;
import com.app.entities.Train;
import com.app.service.TrainService;

@RestController
@RequestMapping("/railways")
public class TrainController {

    @Autowired
    private TrainService tServ;

    @GetMapping("/{trainType}")
    public ResponseEntity<?> getCourseByCategory(@PathVariable String trainType) {
        return ResponseEntity.status(HttpStatus.OK).body(tServ.getAllRailway(Category.valueOf(trainType)));
    }

    @PostMapping
    public ResponseEntity<?> saveTrain(@RequestBody @Valid TrainDTO t) {
        try {
            Train savedTrain = tServ.addRailway(t);
            return ResponseEntity.status(HttpStatus.CREATED).body("Train saved with ID: " + savedTrain.getId());
        } catch (RuntimeException e) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable Long id) {
        String deletedTrain = tServ.deleteRailway(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Your " + deletedTrain.getClass() + " is deleted");
    }
}
