package com.ust.StateService.service;


import com.ust.StateService.dto.DistrictDto;
import com.ust.StateService.dto.ResponseDto;
import com.ust.StateService.model.State;
import com.ust.StateService.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepo stateRepository;
    @Autowired
    WebClient webClient;

    // Save multiple states at one go
    public List<State> saveStates(List<State> states) {
        return stateRepository.saveAll(states);
    }

    // Get all states
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    // Get state by state ID
    public Optional<State> getStateById(String stateId) {
        return stateRepository.findById(stateId);
    }


    public ResponseDto getState(String stateId) {
        ResponseDto responseDto = new ResponseDto();
        State state=stateRepository.findById(stateId).get();

        List<DistrictDto> districtList = webClient.get()
                .uri("http://localhost:9098/district/byState/" + state.getStateId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<DistrictDto>>() {}).block();

        responseDto.setState(state);
        responseDto.setDistrictDto(districtList);

        return responseDto;
    }


}
