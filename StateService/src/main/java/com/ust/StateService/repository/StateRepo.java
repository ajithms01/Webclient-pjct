package com.ust.StateService.repository;

import com.ust.StateService.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State,String> {
}
