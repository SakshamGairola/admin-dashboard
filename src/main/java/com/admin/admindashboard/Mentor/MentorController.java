package com.admin.admindashboard.Mentor;

import com.admin.admindashboard.MentorRequest.MentorRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private MentorRequestService mentorRequestService;

    @GetMapping("/get/{mentor_id}")
    public ResponseEntity<Object> getById(@PathVariable("mentor_id") Long mentorId) {
        if(this.mentorService.getMentorById(mentorId).isPresent())
            return new ResponseEntity<>(this.mentorService.getMentorById(mentorId).get(), HttpStatus.OK);
        return new ResponseEntity<>("entry not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public List<MentorModel> getAllMentor(){
        return this.mentorService.getAllMentors();
    }

    @GetMapping("/get")
    public List<MentorModel> getBySearchKey(@RequestParam("searchKey") String searchKey){
        return this.mentorService.getBySearchKey(searchKey);
    }

    @PutMapping("/edit")
    public ResponseEntity<Object> editMentor(@RequestBody MentorModel mentorModel) {
        Long mentorId = mentorModel.getMentorId();
        Object body = getById(mentorId).getBody();
        if (body.getClass() != String.class){
            MentorModel newMentorModel = (MentorModel) body;
            if (mentorModel.getName() != null) newMentorModel.setName(mentorModel.getName());
            if (mentorModel.getAge() != 0) newMentorModel.setAge(mentorModel.getAge());
            if (mentorModel.getPhoneNumber() != null) newMentorModel.setPhoneNumber(mentorModel.getPhoneNumber());
            if (mentorModel.getJobRole() != null) newMentorModel.setJobRole(mentorModel.getJobRole());
            return new ResponseEntity<>(this.mentorService.editMentor(newMentorModel), HttpStatus.OK);
        }
        return new ResponseEntity<>("entry not found", HttpStatus.NOT_FOUND);
    }

}