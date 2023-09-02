package com.admin.admindashboard.MentorRequest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "mentor_request")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MentorRequestModel {

    @Id
    @SequenceGenerator(name = "mentorReq_seq_generator", sequenceName = "mentorReq_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mentorReq_seq_generator")
    private Long mentorRequestId;

    @Column(name="name")
    private String name;

    @Column(name="cv")
    private String cv;

    @Column(name="isApproved")
    private String isApproved;

}
