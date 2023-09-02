package com.admin.admindashboard.MentorRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRequestRepository extends JpaRepository<MentorRequestModel, Long> {
    // This is the data model
}