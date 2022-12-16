package com.acesso.A.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acesso.A.model.Client;
import com.acesso.A.model.Op;
import com.acesso.A.model.User;
import com.acesso.A.repository.ClientRepository;
import com.acesso.A.web.dto.ClientRegistrationDto;
import com.acesso.A.web.dto.FuncioRegistrationDto;
import com.acesso.A.web.dto.OpRegistrationDto;


@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client save(ClientRegistrationDto clientRegistrationDto) {
		Client client = populateClientDto(clientRegistrationDto);
		return clientRepository.save(client);
	}
	
	private Client populateClientDto(ClientRegistrationDto clientRegistrationDto) {	
		Client client = new Client();
		client.setName(null);
		client.setOperation(null);
		return client;
	}
	
	private ClientRegistrationDto populateCLientDto(Client client) {
		ClientRegistrationDto dto = new ClientRegistrationDto();
		dto.setName(null);
		dto.setClient(client);
		return dto;
	}
	
	@Override
    public List<ClientRegistrationDto> findAll() {
        List<ClientRegistrationDto> client = new ArrayList<> ();
        List<Client>clientList = clientRepository.findAll();
        clientList.forEach(clientt -> {
            client.add(populateCLientDto(clientt));
        });
        return client;
    }
}
