package com.admin.admindashboard.Mentor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<MentorModel, Long> {
    // This is the data model
}