package com.masonwang.pnp.repository;

import com.masonwang.pnp.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}