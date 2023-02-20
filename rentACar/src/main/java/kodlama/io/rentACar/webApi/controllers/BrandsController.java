package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

@RestController //means that this class will be the Controller
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired //autowired looks for the parameter and scans the project for who implements that interface and runs w that (new's it)
	public BrandsController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED) //201
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
}
