package com.village.survey.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.survey.core.util.CustomException;
import com.village.survey.dao.VillagePhotosDao;
import com.village.survey.entity.VillagePhotos;

/**
 * @author
 *
 */
@Service
public class VillagePhotosService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VillagePhotosDao villagePhotosDao;

	/**
	 * 
	 * @param VillagePhotos
	 * @return
	 */
	public VillagePhotos saveVillagePhotos(VillagePhotos villagePhotos) {
		// TODO user id need to be loaded form user context.
		villagePhotos.setCreatedUser(1L);
		villagePhotos.setModifiedUser(1L);
		return villagePhotosDao.save(villagePhotos);
	}

	/**
	 * This method for update VillagePhotos
	 * 
	 * @param state
	 * @return
	 */
	public VillagePhotos updateVillagePhotos(VillagePhotos villagePhotos) {
		List<VillagePhotos> villagePhotosList = Optional.ofNullable(villagePhotosDao.findById(villagePhotos.getId()))
				.orElseThrow(
						() -> new CustomException("VillagePhotos not found for this id :: " + villagePhotos.getId()));
		VillagePhotos villagePhotosDto = new VillagePhotos();
		if (!villagePhotosList.isEmpty()) {
			villagePhotosDto = villagePhotosList.get(0);
			villagePhotosDto.setModifiedOn(new Date());
			villagePhotosDto.setModifiedUser(1L);
			villagePhotosDto.setName(villagePhotos.getName());
			villagePhotosDto.setVillage(villagePhotos.getVillage());
			villagePhotosDto.setSurvey(villagePhotos.getSurvey());
			villagePhotosDto.setS3Url(villagePhotos.getS3Url());
			villagePhotosDto = villagePhotosDao.update(villagePhotosDto);
			logger.info("VillagePhotos is updated");
		}
		return villagePhotosDto;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public VillagePhotos getVillagePhotosById(Long id) {
		List<VillagePhotos> villagePhotosList = Optional.ofNullable(villagePhotosDao.findById(id))
				.orElseThrow(() -> new CustomException("VillagePhotos not found for this id :: " + id));
		return !villagePhotosList.isEmpty() ? villagePhotosList.get(0) : new VillagePhotos();

	}

	/**
	 * This method for get all VillagePhotos
	 * 
	 * @return
	 */
	public List<VillagePhotos> getAllVillagePhotos() {
		return villagePhotosDao.findAll().stream().parallel()
				.sorted(Comparator.comparingLong(VillagePhotos::getId).reversed()).collect(Collectors.toList());
	}

}
