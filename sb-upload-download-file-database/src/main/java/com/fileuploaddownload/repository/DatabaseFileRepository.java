package com.fileuploaddownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileuploaddownload.model.DatabaseFile;


@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

}
