package com.example.candiatePosition.repository;

import com.example.candiatePosition.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("SELECT p.positionId FROM Position p WHERE p.positionId IN :ids")
    List<Long> findExistingPositionIds(@Param("ids") List<Long> ids);

}
