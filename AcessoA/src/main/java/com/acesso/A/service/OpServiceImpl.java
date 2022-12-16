package com.acesso.A.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Op;
import com.acesso.A.repository.OpRepository;
import com.acesso.A.web.dto.OpRegistrationDto;

@Service("opService")
public class OpServiceImpl implements OpService {
	
	@Autowired
	private OpRepository opRepository;
	
	public Op save(OpRegistrationDto opRegistrationDto) {
		Op op = populateOpDto(opRegistrationDto);
		return opRepository.save(op);
	}

	private OpRegistrationDto populateOpDto(Op op) {
		OpRegistrationDto dto = new OpRegistrationDto();
		dto.setLogName(null);
		dto.setClientName(null);
		dto.setPlaca(null);
		dto.isEntry();
		dto.setTara(0);
		dto.isECopies();
		dto.getPeso();
		dto.isEndWO();
		return dto;
	}
	
	private Op populateOpDto(OpRegistrationDto opRegistrationDto) {
		Op opp = new Op();
		opp.setLogistic(null);
		opp.setClient(null);
		opp.setPlaca(null);
		opp.isEntry();
		opp.setTara(0);
		opp.isECopies();
		opp.getPeso();
		opp.isEndWO();
		return opp;
	}
	
	@Override
    public List<OpRegistrationDto> findAll() {
        List<OpRegistrationDto> op = new ArrayList<> ();
        List<Op>opList = opRepository.findAll();
        opList.forEach(opp -> {
            op.add(populateOpDto(opp));
        });
        return op;
    }
}
