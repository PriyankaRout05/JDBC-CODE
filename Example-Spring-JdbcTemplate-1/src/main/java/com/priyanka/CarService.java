package com.priyanka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepo;

	public List<Car> getAllcars() {
		return carRepo.getAll();
	}

	public Car savecardata(Car car) {
		return carRepo.savecardata(car);

	}

	public Car update(Car car, int quantity) {
		return carRepo.update(car, quantity);
	}

	public List<Car> getbyquantity(int quantity) {
		return carRepo.getbyquantity(quantity);

	}

	public void deleteCar(int carquantity) {

	}

}
