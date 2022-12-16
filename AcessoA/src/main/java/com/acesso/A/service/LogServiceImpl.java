package com.acesso.A.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Logistic;
import com.acesso.A.model.Op;
import com.acesso.A.repository.LogRepository;
import com.acesso.A.web.dto.LogRegistrationDto;
import com.acesso.A.web.dto.OpRegistrationDto;

@Service("logService")
public class LogServiceImpl implements LogService{
	
	@Autowired
	private LogRepository logRepository;
	
	@Override
	public Logistic save(LogRegistrationDto logRegistrationDto) {
		Logistic logistic = populateLogDto(logRegistrationDto);
		return logRepository.save(logistic);
	}
	

	private LogRegistrationDto populateLogDto(Logistic logistic) {
		LogRegistrationDto dto = new LogRegistrationDto();
		dto.setName(logistic.getName());
		dto.setLogistic(null);
		return dto;
	}
	
	private Logistic populateLogDto(LogRegistrationDto logRegistrtionDto) {
		Logistic logistic = new Logistic();
		logistic.setName(null);
		logistic.setOperation(null);
		return logistic;
	}
	
	@Override
    public List<LogRegistrationDto> findAll() {
        List<LogRegistrationDto> log = new ArrayList<> ();
        List<Logistic>logList = logRepository.findAll();
        logList.forEach(logg -> {
            log.add(populateLogDto(logg));
        });
        return log;
    }
	
}
