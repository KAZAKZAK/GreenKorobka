package com.greenbox.test.demo.repository;

import com.greenbox.test.demo.entity.GrowProgram;
import com.greenbox.test.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface GrowProgramRepository extends JpaRepository<GrowProgram, Long> {
    @Override
    @Query(
            value = "select * from grow_programs " +
                    "join watering_parameters on watering_parameters.id = grow_programs.watering_parameters_id",
            nativeQuery = true
    )
    List<GrowProgram> findAll();

    List<GrowProgram> findAllByUserCreator(User user);
}
