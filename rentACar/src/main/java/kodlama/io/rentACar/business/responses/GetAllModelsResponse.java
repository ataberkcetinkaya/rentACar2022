package kodlama.io.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	private int id;
	private String name;
	//private int brandId; //can bring the id, just like the name below
	private String brandName; //brandName doesn't exists in the Model entity but it can go inside to Brand brand and get its name there.
}
