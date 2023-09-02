package com.admin.admindashboard.MentorRequest;

import java.util.List;
import java.util.Optional;

public interface MentorRequestService {

    List<MentorRequestModel> getAllRequests();

    Optional<MentorRequestModel> getRequestById(Long requestId);

    MentorRequestModel createRequest(MentorRequestModel mentorRequestModel);

    MentorRequestModel updateRequest(MentorRequestModel mentorRequestModel);

}