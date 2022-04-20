package com.greenbox.test.demo.repository;

import com.greenbox.test.demo.entity.GreenBox;
import com.greenbox.test.demo.entity.GrowProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GreenBoxRepository extends JpaRepository<GreenBox, Long> {
    @Override
    @Query(
            value = "select * from greenboxes " +
                    "join users on users.id = greenboxes.user_id " +
                    "join grow_programs on grow_programs.id = greenboxes.grow_program_id " +
                    "join watering_parameters on watering_parameters.id = grow_programs.watering_parameters_id",
            nativeQuery = true
    )
    List<GreenBox> findAll();

    @Query(
            value = "select * from greenboxes " +
                    "join users on users.id = greenboxes.user_id " +
                    "join grow_programs on grow_programs.id = greenboxes.grow_program_id " +
                    "where user_id = :id",
            nativeQuery = true
    )
    List<GreenBox> findAllByUserId(@Param("id") Long userId);

    @Query(
            value = "select * from greenboxes " +
                    "join users on users.id = greenboxes.user_id " +
                    "join grow_programs on grow_programs.id = greenboxes.grow_program_id " +
                    "where grow_programs.id = :id",
            nativeQuery = true
    )
    GrowProgram findByGrowProgramId(@Param("id") Long growProgramId);
}
