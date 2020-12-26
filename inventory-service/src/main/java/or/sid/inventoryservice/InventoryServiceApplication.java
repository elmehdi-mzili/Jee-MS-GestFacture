package or.sid.inventoryservice;

import or.sid.inventoryservice.dao.ProductRepository;
import or.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            productRepository.save(new Product(null,"Ordinateur",9000,10));
            productRepository.save(new Product(null,"SmartPhone",2500,5));
            productRepository.save(new Product(null,"Imprimante",3000,15));
            productRepository.findAll().forEach(product -> {
                System.out.println(product);
            });
            repositoryRestConfiguration.exposeIdsFor(Product.class);
        };
    }

}
