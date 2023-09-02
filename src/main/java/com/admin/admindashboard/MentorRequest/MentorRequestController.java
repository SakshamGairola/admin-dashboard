package com.admin.admindashboard.MentorRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentorRequest")
public class MentorRequestController {

    @Autowired
    private MentorRequestService mentorRequestService;

    @GetMapping("/all")
    public List<MentorRequestModel> getAllRequests(){
        return this.mentorRequestService.getAllRequests();
    }

    @PostMapping("/create")
    public MentorRequestModel createRequest(@RequestBody MentorRequestModel mentorRequestModel){
        return this.mentorRequestService.createRequest(mentorRequestModel);
    }

}