package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name); //I make it boolean bc if exists it will showup true otherwise false...
	//spring jpa keywords
	//if its gonna be findByName then I can type Brand instead of boolean if its single, if its multiple List<Brand>
}
