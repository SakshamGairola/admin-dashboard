package com.admin.admindashboard.Admin;

import com.admin.admindashboard.Mentor.MentorModel;
import com.admin.admindashboard.Mentor.MentorService;
import com.admin.admindashboard.MentorRequest.MentorRequestModel;
import com.admin.admindashboard.MentorRequest.MentorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MentorRequestService mentorRequestService;

    @Autowired
    private MentorService mentorService;


    @PutMapping("/approval")
    public ResponseEntity<Object> requestHandler(@RequestParam("approvalStatus") String status,
                                         @RequestParam("requestId") Long requestId) {
        if(this.mentorRequestService.getRequestById(requestId).isPresent()){
            MentorRequestModel request = this.mentorRequestService.getRequestById(requestId).get();
            if(status.equalsIgnoreCase("approve")){
                request.setIsApproved("approve");
                this.mentorService.createMentor(MentorModel.builder().name(request.getName()).mentorRequestModel(request).build());
            } else if (status.equalsIgnoreCase("reject")) {
                request.setIsApproved("reject");
            }
            this.mentorRequestService.updateRequest(request);
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
        return new ResponseEntity<>("Object does not exist", HttpStatus.NOT_FOUND);
    }

}
