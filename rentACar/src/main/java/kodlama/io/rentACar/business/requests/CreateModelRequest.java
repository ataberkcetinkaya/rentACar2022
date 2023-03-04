package kodlama.io.rentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
	@NotNull //null validation
	@NotBlank
	@Size(min = 3, max=20)
	private String name;
	@NotNull //null validation
	@NotBlank
	private int brandId;
	
	//javax.validation.constraints >> search in google for more
}
