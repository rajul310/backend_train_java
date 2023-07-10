package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customException.NotFoundException;
import com.app.dto.TrainDTO;
import com.app.entities.Category;
import com.app.entities.Train;
import com.app.repository.TrainRepo;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {
     @Autowired
	private  TrainRepo tRepo;
     
     @Autowired
     private ModelMapper mapper;

	
     @Override
     public Train addRailway(TrainDTO t) {
 		Train train = mapper.map(t, Train.class);
 		return tRepo.save(train);
 	}
     
	

	@Override
	public String deleteRailway(Long id) throws NotFoundException{
		if (tRepo.existsById(id)) {
			tRepo.deleteById(id);
			return "Train with ID: " + id + " is deleted. Thank you!";
		} else {
			throw new NotFoundException("Train not found with ID: " + id);
		}
		
	}

	@Override
	public List<TrainDTO> getAllRailway(Category trainType) {
	    List<Train> trainList = tRepo.findByTrainType(trainType);
	    return trainList.stream()
	            .map(train -> mapper.map(train, TrainDTO.class))
	            .collect(Collectors.toList());
	}

	    //return tRepo.findByTrainType(trainType);
	}

	
	

