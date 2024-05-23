package diegonobre.com.encryptapi.service;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Service;



@Service
public class EncryptService {
	
	private final AES256TextEncryptor textEncryptor;
	
	public EncryptService(AES256TextEncryptor textEncryptor) {
		this.textEncryptor = textEncryptor;
	}

	public String encryptData(String data) {
		return textEncryptor.encrypt(data);
	}

	    public String decryptData(String encryptedData) {
	        return textEncryptor.decrypt(encryptedData);
	    }
}
