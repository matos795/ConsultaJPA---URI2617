package com.consultaJPA.uri2617;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.consultaJPA.uri2617.dto.ProductProviderDTO;
import com.consultaJPA.uri2617.projections.ProductProviderProjection;
import com.consultaJPA.uri2617.repositories.ProductProviderRepository;

@SpringBootApplication
public class Uri2617Application implements CommandLineRunner{

	@Autowired
	private ProductProviderRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2617Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductProviderProjection> list1 = repository.search1("Ajax SA");
		List<ProductProviderDTO> listDTO1= list1.stream().map(x-> new ProductProviderDTO(x)).collect(Collectors.toList());
		System.out.println("---------------- M O V I E S   F O U N D   S Q L ----------------");
		for (ProductProviderDTO productProviderDTO : listDTO1) {
			System.out.println(productProviderDTO);
		}
		System.out.println("-----------------------------------------------------------------");

		List<ProductProviderDTO> listDTO2 = repository.search2("Ajax SA");
		System.out.println("---------------- M O V I E S   F O U N D   J P Q L ----------------");
		for (ProductProviderDTO obj : listDTO2) {
			System.out.println(obj);
		}
		System.out.println("-----------------------------------------------------------------");
	}

}
