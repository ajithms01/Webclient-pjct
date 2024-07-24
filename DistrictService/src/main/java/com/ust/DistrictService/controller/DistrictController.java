package com.ust.DistrictService.controller;

import com.ust.DistrictService.model.District;
import com.ust.DistrictService.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping("/save")
    public ResponseEntity<List<District>> saveDistricts(@RequestBody List<District> districts) {
        List<District> savedDistricts = districtService.saveDistricts(districts);
        return ResponseEntity.ok(savedDistricts);
    }

    @GetMapping("/all")
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/byState/{stateId}")
    public ResponseEntity<List<District>> getDistrictByStateId(@PathVariable String stateId) {
        Optional<List<District>> district = districtService.getDistrictByStateId(stateId);
        return district.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

