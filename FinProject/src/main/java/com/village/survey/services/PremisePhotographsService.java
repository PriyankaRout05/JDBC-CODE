package com.village.survey.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.entity.PremisePhotographs;
import com.village.survey.repo.PremisePhotographsRepo;

@Service
public class PremisePhotographsService {

	@Autowired
	private PremisePhotographsRepo pePhotographsRepo;

	public void savePhto(PremisePhotographs premisePhotograph) {
		pePhotographsRepo.save(premisePhotograph);
	}

	public List<PremisePhotographs> getAllPhotos() {
		return pePhotographsRepo.findAll();
	}

	public Optional<PremisePhotographs> getPhotoById(Long id) {
		return pePhotographsRepo.findById(id);
	}
}