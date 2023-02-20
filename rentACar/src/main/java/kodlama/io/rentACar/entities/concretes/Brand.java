package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="brands")
@Data //creates getters-setters & constructor without parameters
@AllArgsConstructor //creates constructor w parameters
@NoArgsConstructor //creates constructor without parameters
//@Getter //only getter
@Entity //means that its a db value
public class Brand {
	
	@Id //PK on db
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto id increase
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
}
