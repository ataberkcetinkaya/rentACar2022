package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponse = 
				models.stream().map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

			return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = modelMapperService.forRequest().map(createModelRequest, Model.class); //will turn createModelRequest into a Model entity
		model.setId(0); //might be some probems with mapping(ModelMapper) about updating the prev one instead adding new one, so reset the ID here.
		this.modelRepository.save(model);
		
	}

}