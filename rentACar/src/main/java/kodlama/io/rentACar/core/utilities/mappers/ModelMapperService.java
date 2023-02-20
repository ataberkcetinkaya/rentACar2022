package kodlama.io.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse(); //for responses
	ModelMapper forRequest(); //for requests
}
