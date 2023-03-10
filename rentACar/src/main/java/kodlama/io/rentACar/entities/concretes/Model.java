package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne //@ManyToOne bc of can be many models here related to the one brand
	@JoinColumn(name="brand_id") //this part will be added to the db with the name of brand_id (brand_id will be related with Brand)
	private Brand brand; //can be only one brand for many models
	
	@OneToMany(mappedBy = "model") //can be many Cars related with one model (just like we did in Brand)
	private List<Car> cars;
}
