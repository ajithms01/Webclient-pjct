package com.ust.DistrictService.service;

import com.ust.DistrictService.model.District;
import com.ust.DistrictService.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepo districtRepository;
    public List<District> saveDistricts(List<District> districts) {
        return districtRepository.saveAll(districts);
    }

    // 2. Get all districts
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    // 3. Get district by district ID
    public Optional<List<District>> getDistrictByStateId(String districtId) {
        return districtRepository.findAllByStateId(districtId);
    }
}
