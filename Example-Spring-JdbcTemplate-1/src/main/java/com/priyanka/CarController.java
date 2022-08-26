package com.priyanka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	@Autowired
	private CarService carService;
	
	@GetMapping("/getAll")
	public List<Car>getAllCars(){
		return carService.getAllcars();	
	}

	@PostMapping("/savecardata")
	public Car savecardata(@RequestBody Car car) {
	return	carService.savecardata(car);
	}
	
	@PutMapping("/update/{quantity}")
	public Car  update(@RequestBody Car car, @PathVariable int quantity) {
		return carService.update(car,quantity);
	

	}
	@GetMapping("/get/{quantity}")
	public List<Car> getByQuantity(@PathVariable int quantity) {
		return carService.getbyquantity(quantity);
	
	}
	@DeleteMapping("/car/{carquantity}")
	public void deleteCar(@PathVariable int carquantity) {
		carService.deleteCar(carquantity);
	}

}
