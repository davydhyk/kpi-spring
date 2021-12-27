package com.example.spring.repositories;

import com.example.spring.models.Voting;
import com.example.spring.repositories.interfaces.IVotingRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VotingRepository extends GenericRepository<Voting, Integer> implements IVotingRepository {

    public VotingRepository() {
        Voting voting = new Voting("First voting",
                new GregorianCalendar(2021, Calendar.JANUARY, 12).getTime(),
                new GregorianCalendar(2021, Calendar.FEBRUARY, 1).getTime(),
                false,
                1
        );
        this.create(voting);
        Voting voting1 = new Voting("Second voting",
                new GregorianCalendar(2021, Calendar.FEBRUARY, 2).getTime(),
                new GregorianCalendar(2021, Calendar.MARCH, 10).getTime(),
                false,
                2
        );
        this.create(voting1);
    }

    @Override
    public List<Voting> getByUser(int userId) {
        return entities.values().stream()
                .filter(voting -> voting.getUserId() == userId)
                .collect(Collectors.toList());
    }
}
