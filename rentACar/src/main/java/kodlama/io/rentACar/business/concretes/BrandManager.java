package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service //IoC //will new that automatically
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService; //injecting to use
	
	@Autowired //autowired looks for the parameter and scans the project for who implements that interface and runs w that (new's it)
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) { //can get InMemory, Hibernate etc.
		super();
		this.brandRepository = brandRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll(); //infos that comes from the db
		
		/*
		 * List<GetAllBrandsResponse> brandsResponse = new ArrayList<>(); //creating an
		 * empty list
		 * 
		 * for (Brand br : brands) { //iterating over the infos from the db
		 * GetAllBrandsResponse responseItem = new GetAllBrandsResponse(); //creating an
		 * responseItem on every loop responseItem.setId(br.getId()); //and setting that
		 * infos to that new responseItem responseItem.setName(br.getName());
		 * 
		 * brandsResponse.add(responseItem); //and add those infos to my new type
		 * GetAllBrandsResponse arrayList }
		 */
		
		//code after using mapper...
		List<GetAllBrandsResponse> brandsResponse = 
				brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList()); //Loop through the list with stream map
		
			return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		/*
		 * Brand brand = new Brand(); brand.setName(createBrandRequest.getName());
		 * //creating a brand here bc brandRepository wants a Brand value from us //than
		 * we update the brand's name value via createBrandRequest.getName()
		 * this.brandRepository.save(brand);
		 */
		
		//code after using mapper...
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class); //will turn createBrandRequest into a Brand entity
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElseThrow(); //if u cannot find, throw an error
		GetByIdBrandResponse getByIdBrandResponse = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return getByIdBrandResponse;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class); //mapped w updateBrandRequest
		brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		brandRepository.deleteById(id);
	}
}
