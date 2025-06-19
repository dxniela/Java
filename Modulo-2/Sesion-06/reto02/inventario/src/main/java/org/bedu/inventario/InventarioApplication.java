package org.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
        return (args) -> {
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");

            marcaRepo.save(apple);
            marcaRepo.save(samsung);

            productoRepo.save(new Producto("iPhone 15", "Nuevo modelo 2025", 1200.00, apple));
            productoRepo.save(new Producto("iPad Pro", "Pantalla M4", 1500.00, apple));
            productoRepo.save(new Producto("Galaxy S23", "Android potente", 1000.00, samsung));
            productoRepo.save(new Producto("Smart TV", "4K QLED", 800.00, samsung));

            System.out.println("\nProductos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println(marca.getNombre() + ":");
                productoRepo.findAll().stream()
                    .filter(p -> p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
