package com.admin.admindashboard.MentorRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorRequestServiceImpl implements MentorRequestService {
    @Autowired
    private MentorRequestRepository mentorRequestRepository;

    @Override
    public List<MentorRequestModel> getAllRequests() {
        return this.mentorRequestRepository.findAll();
    }

    @Override
    public Optional<MentorRequestModel> getRequestById(Long requestId) {
        return this.mentorRequestRepository.findById(requestId);
    }

    @Override
    public MentorRequestModel createRequest(MentorRequestModel mentorRequestModel) {
        return this.mentorRequestRepository.save(mentorRequestModel);
    }

    @Override
    public MentorRequestModel updateRequest(MentorRequestModel mentorRequestModel) {
        return this.mentorRequestRepository.save(mentorRequestModel);
    }
}
