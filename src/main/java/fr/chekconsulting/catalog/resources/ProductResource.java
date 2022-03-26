package fr.chekconsulting.catalog.resources;

import fr.chekconsulting.catalog.entities.Product;
import fr.chekconsulting.catalog.services.ProductService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1")
public class ProductResource {
    private final ProductService productService;

    @Value("${app-version}")
    String appVersion;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("version")
    public String appVersion() {
        return appVersion;
    }

    @SneakyThrows
    @GetMapping("liveness")
    public String liveness() {
        log.info("appel sur l'apu liveness ");
        Thread.sleep(10000);
        return "liveness-ok";
    }

    @SneakyThrows
    @GetMapping("readiness")
    public String readiness() {
        log.info("appel sur l'apu readiness ");
        Thread.sleep(20000);
        return "readiness-ok";
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }
}
