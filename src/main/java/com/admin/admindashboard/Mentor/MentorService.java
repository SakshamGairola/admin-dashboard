package com.admin.admindashboard.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {

    List<MentorModel> getAllMentors();

    Optional<MentorModel> getMentorById(Long id);

    MentorModel editMentor(MentorModel mentorModel);

    MentorModel createMentor(MentorModel build);

    List<MentorModel> getBySearchKey(String searchKey);

}