package com.app.dto;

import java.time.LocalTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDTO {

    @NotBlank(message = "Train Name Can't be empty!!")
    private String trainName;

    @Enumerated(EnumType.STRING)
    private Category trainType;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @Future(message = "end time must be a future date!!")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime end_time;

    @Min(value = 1, message = "Distance should be greater than 0!!")
    private int distance;

    @Min(value = 1, message = "Value should be greater than 0!!")
    private int frequency;
    
//    @NotBlank(message = "Destination cannot be blank")
//	private String destination;
//    
//    private String source;

}
