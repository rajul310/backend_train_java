package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.TrainDTO;
import com.app.entities.Category;
import com.app.entities.Train;

public interface TrainService {
	
  Train addRailway(TrainDTO t);
  
  String deleteRailway(Long id);
  
  List<TrainDTO> getAllRailway(Category cat);
  
  
}
