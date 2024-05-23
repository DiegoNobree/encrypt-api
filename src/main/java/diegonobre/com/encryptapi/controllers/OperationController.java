package diegonobre.com.encryptapi.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import diegonobre.com.encryptapi.domain.Operation;
import diegonobre.com.encryptapi.domain.exception.OperationDelete;
import diegonobre.com.encryptapi.dtos.EncryptDTO;
import diegonobre.com.encryptapi.dtos.OperationReadDTO;
import diegonobre.com.encryptapi.service.OperationService;


@RestController
@RequestMapping("/api/operation")
public class OperationController {
	
	final private OperationService operationService;
	
	public OperationController (OperationService operationService) {
		this.operationService = operationService;
	}
	
	@PostMapping
	public ResponseEntity<Operation> create (@RequestBody EncryptDTO encryptDTO) {
		
		Operation newOperation = operationService.createOperation(encryptDTO);
		return ResponseEntity.ok(newOperation);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OperationReadDTO> read (@PathVariable Long id) {
		
		OperationReadDTO newOperation = operationService.readOperation(id);
		return ResponseEntity.ok(newOperation);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<OperationDelete> delete (@PathVariable Long id) {
		
		OperationDelete operationDelete = new OperationDelete();
		operationService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(operationDelete);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Operation> update (@RequestBody EncryptDTO encryptDTO, @PathVariable Long id) {
		
		Operation updateOperation = operationService.update(encryptDTO, id);
		return ResponseEntity.ok(updateOperation);
	}
}
