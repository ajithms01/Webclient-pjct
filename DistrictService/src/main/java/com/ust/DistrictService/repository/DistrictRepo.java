package com.ust.DistrictService.repository;

import com.ust.DistrictService.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepo extends JpaRepository<District,String> {
    Optional<List<District>> findAllByStateId(String districtId);
}
