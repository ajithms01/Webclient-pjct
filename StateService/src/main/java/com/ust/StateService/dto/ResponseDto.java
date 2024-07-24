package com.ust.StateService.dto;

import com.ust.StateService.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    State state;
    List<DistrictDto> districtDto;
}
