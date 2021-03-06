package com.camaratek.ecommerce;

import com.camaratek.ecommerce.entities.Category;
import com.camaratek.ecommerce.entities.Product;
import com.camaratek.ecommerce.repositories.CategoryJPARepository;
import com.camaratek.ecommerce.repositories.ProductJPARepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class LigthEcomV1Application implements CommandLineRunner {

	@Autowired
	private ProductJPARepository productJPARepository;
	@Autowired
	private CategoryJPARepository categoryJPARepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(LigthEcomV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//pour exposer l'ID
		repositoryRestConfiguration.exposeIdsFor( Product.class, Category.class );
		categoryJPARepository.save(new Category(null, "Ordinateur", null, "unknown.png",null));
		categoryJPARepository.save(new Category(null, "Imprimante", null, "unknown.png",null));
		categoryJPARepository.save(new Category(null, "Smart phones", null, "unknown.png",null));

		categoryJPARepository.findAll().forEach(c -> {
			for (int i=0; i < 5; i++) {
				Random rnd = new Random();
				Product p = new Product();
				p.setName(RandomString.make( 18 ) );
				p.setCurrentPrice( 100 + rnd.nextDouble() );
				p.setAvailable( rnd.nextBoolean() );
				p.setPromotion( rnd.nextBoolean() );
				p.setSelected( rnd.nextBoolean() );
				p.setPhotoName("unknown.png");
				productJPARepository.save(p);
			}
		});
	}

}
