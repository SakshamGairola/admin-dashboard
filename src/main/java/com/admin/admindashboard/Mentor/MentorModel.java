package com.admin.admindashboard.Mentor;

import com.admin.admindashboard.MentorRequest.MentorRequestModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "mentor")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentorModel {

    @Id
    @SequenceGenerator(name = "mentor_seq_generator", sequenceName = "mentor_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mentor_seq_generator")
    private Long mentorId;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name = "job_role")
    private String jobRole;

    @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinColumn(name = "mentor_request_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MentorRequestModel mentorRequestModel;

}
