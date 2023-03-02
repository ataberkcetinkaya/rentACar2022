package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	//mappedBy = "brand" > stands for the "Brand brand" in Model class.
	@OneToMany(mappedBy = "brand") //look for class its Brand, it can be "One" and "Many" models related w brand here. So its @OneToMany
	private List<Model> models; //can be many models related to only one brand
}
