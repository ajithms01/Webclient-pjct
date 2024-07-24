package com.ust.StateService.controller;



import com.ust.StateService.dto.ResponseDto;
import com.ust.StateService.model.State;
import com.ust.StateService.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    StateService stateService;// Save multiple states at one go
    @PostMapping("/save")
    public List<State> saveStates(@RequestBody List<State> states) {
        return stateService.saveStates(states);
    }

    // Get all states
    @GetMapping
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    // Get state by state ID


    @GetMapping("{stateId}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("stateId") String stateId){
        ResponseDto responseDto = stateService.getState(stateId);
        return ResponseEntity.ok(responseDto);
    }
}
