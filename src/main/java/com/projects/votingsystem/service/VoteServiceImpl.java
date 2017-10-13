package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.repository.DataJpaVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class VoteServiceImpl implements VoteService {

    private final DataJpaVoteRepository repository;

    @Autowired
    public VoteServiceImpl(DataJpaVoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vote> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

    @Override
    public Vote getLast(int userId) {
        List<Vote> list = new ArrayList<Vote>();
        list = repository.getAllByUser(userId);
        return list.get(list.size()-1);
    }

    @Override
    public List<Vote> getAlByDateTime(LocalDateTime dateTime) {
        return repository.getAllByDateTime(dateTime);
    }

    @Override
    public Vote save(Vote vote) {
        return repository.save(vote);
    }
}
