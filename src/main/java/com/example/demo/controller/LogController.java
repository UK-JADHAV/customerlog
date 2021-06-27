package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.LogModel;
import com.example.demo.repository.LogRepository;

@RestController

public class LogController {
	
	@Autowired
	LogRepository logRepository;
	
	
	@GetMapping(path="/getAllLog", produces= {"application/json"})
	public List<LogModel> getAllLog(){
		
		return logRepository.findAll();
	}
	
	
	
	@GetMapping(path="/checkIn", produces= {"application/json"}) 
	public LogModel checkIn(@RequestParam String name)
	{
		LogModel logModel=new LogModel();
		logModel.setName(name);
		logModel.setTime(java.time.LocalTime.now().toString());
		String date=java.time.LocalDate.now().toString();
		String strDate=date.replace("-","/");
		logModel.setDate(strDate);
        logModel.setLogType("In");
        logModel.setId(name+java.time.LocalTime.now().toString());
		logRepository.save(logModel);
		
		return logModel;
		
	}
	
    
	@GetMapping(path="/checkOut", produces= {"application/json"})
	public LogModel checkOut(@RequestParam String name)
	{
		LogModel logModel=new LogModel();
		logModel.setName(name);
		logModel.setTime(java.time.LocalTime.now().toString());
		String date=java.time.LocalDate.now().toString();
		String strDate=date.replace("-","/");
		logModel.setDate(strDate);
        logModel.setLogType("Out");
        logModel.setId(name+java.time.LocalTime.now().toString());
		logRepository.save(logModel);
		return logModel;
		
	}
	
	@GetMapping(path="/getLog", produces= {"application/json"})
	public List<LogModel> getLog(@RequestParam String date)
	{
		
		return logRepository.findByDate(date);
		
		
	}
	
	
}
