package diegonobre.com.encryptapi.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="operations")
public class Operation {
	@Id 
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="userdocument",nullable = false)
	private String userDocument;
	
	@Column(name="creditcardtoken",nullable = false)
	private String creditCardToken;
	
	@Column(name="operationvalue",nullable = false)
	private Long value;
	

	
	
}
