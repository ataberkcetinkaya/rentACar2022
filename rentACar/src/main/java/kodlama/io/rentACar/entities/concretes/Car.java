package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="plate", unique=true)
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="state")
	private int state; // 1-Available 2-On Rent 3-Maintenance
	
	@ManyToOne //@ManyToOne bc of can be many Cars here related to the one model
	@JoinColumn(name="model_id") //just like how we managed the model class with brand class...
	private Model model;
	//WE DONT NEED THE BRAND HERE BC MODEL CLASS HAS ALREADY HAVE THE BRAND ID'S...
}
