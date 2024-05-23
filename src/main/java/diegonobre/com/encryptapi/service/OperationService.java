package diegonobre.com.encryptapi.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import diegonobre.com.encryptapi.domain.Operation;
import diegonobre.com.encryptapi.domain.exception.OperationNotFound;
import diegonobre.com.encryptapi.dtos.EncryptDTO;
import diegonobre.com.encryptapi.dtos.OperationReadDTO;
import diegonobre.com.encryptapi.repositories.OperationRepository;

@Service
public class OperationService {
	
	private OperationRepository repository;
	private EncryptService encryptService;
	
	public OperationService (OperationRepository repository, EncryptService encryptService) {
		this.encryptService = encryptService;
		this.repository = repository;
	}
	
	
	@Transactional
	public Operation createOperation (EncryptDTO encryptDTO) {
		
		Operation operation = new Operation();
		
		String userDocumentHashed = encryptService.encryptData(encryptDTO.userDocument());
		String creditCardHashed = encryptService.encryptData(encryptDTO.creditCardToken());
		
		operation.setCreditCardToken(creditCardHashed);
		operation.setUserDocument(userDocumentHashed);
		operation.setValue(encryptDTO.operationValue());

		repository.save(operation);

		return operation;
		
	}
	
	public OperationReadDTO readOperation (Long id) throws OperationNotFound {
		
		Operation operation = repository.findById(id).orElseThrow(()-> new OperationNotFound());
		
		String userDocumentHashed = encryptService.decryptData(operation.getUserDocument());
		String creditCardHashed = encryptService.decryptData(operation.getCreditCardToken());
		
		OperationReadDTO dto = new OperationReadDTO(operation.getId(),userDocumentHashed, creditCardHashed, operation.getValue());
		
		return dto;
		
	}
	
	public void delete (Long id) throws OperationNotFound {
		Operation operation = repository.findById(id).orElseThrow(()-> new OperationNotFound());
		repository.delete(operation);
		
	}
	
	public Operation update (EncryptDTO data,Long id) throws OperationNotFound {
		Operation operation = repository.findById(id).orElseThrow(()-> new OperationNotFound());
		
		if (!data.userDocument().isEmpty()) {
			operation.setUserDocument(encryptService.encryptData(data.userDocument()));
		}
		
		if (!data.creditCardToken().isEmpty()) {
			operation.setCreditCardToken(encryptService.encryptData(data.creditCardToken()));
		}
		
		if (data.operationValue() != null) {
			operation.setValue(data.operationValue());
		}
		
		repository.save(operation);
		
		return operation;
	}

}
