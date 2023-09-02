package com.admin.admindashboard.Mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public List<MentorModel> getAllMentors() {
        return this.mentorRepository.findAll();
    }

    @Override
    public Optional<MentorModel> getMentorById(Long mentorId) {
        return this.mentorRepository.findById(mentorId);
    }

    @Override
    public MentorModel editMentor(MentorModel mentorModel) {
        return this.mentorRepository.save(mentorModel);
    }

    @Override
    public MentorModel createMentor(MentorModel build) {
        return this.mentorRepository.save(build);
    }

    @Override
    public List<MentorModel> getBySearchKey(String searchKey) {
        MentorModel mentorProbe = new MentorModel();
        mentorProbe.setName(searchKey);
        mentorProbe.setJobRole(searchKey);
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("jobRole", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withIgnorePaths("age", "phoneNumber");
        Example<MentorModel> example = Example.of(mentorProbe, exampleMatcher);
        return this.mentorRepository.findAll(example);
    }
}
