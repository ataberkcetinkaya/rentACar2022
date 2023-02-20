package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
	
	private ModelMapper modelMapper; //only to create one and use it

	@Override
	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true) //block the possible errors. (research for more info)
		.setMatchingStrategy(MatchingStrategies.LOOSE); //LOOSE -> to not map every part from db
		
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true) //block the possible errors. (research for more info)
		.setMatchingStrategy(MatchingStrategies.STANDARD); //STANDARD -> requires every part
		
		return this.modelMapper;
	}

}
