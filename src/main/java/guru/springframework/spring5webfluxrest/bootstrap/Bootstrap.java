package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0){
            System.out.println("Load Data");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Bread").build()).block();
            categoryRepository.save(Category.builder().description("Meat").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            vendorRepository.save(Vendor.builder().firstName("dw").lastName("ded").build()).block();
            vendorRepository.save(Vendor.builder().firstName("fe").lastName("de").build()).block();
            vendorRepository.save(Vendor.builder().firstName("fwfe").lastName("deded").build()).block();
            vendorRepository.save(Vendor.builder().firstName("fewfe").lastName("dedd").build()).block();
        }

    }
}
