package com.projects.votingsystem.repository;


import com.projects.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface DataJpaVoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId ORDER BY v.dateTime")
    List<Vote> getAllByUser(@Param("userId") int userId);

    @Query("SELECT v from Vote v WHERE v.dateTime BETWEEN :startDateTime AND :endDateTime")
    List<Vote> getAllByDateTime(@Param("startDateTime") LocalDateTime startDateTime,
                                @Param("endDateTime") LocalDateTime endDateTime);

    @Override
    Vote save(Vote item);
}
