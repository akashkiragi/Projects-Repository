package com.bank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bank.project.models.BranchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchDetailsRepository extends JpaRepository<BranchDetails, Integer> {

    // Find branch by branch code
    @Query("SELECT b FROM BranchDetails b WHERE b.branchCode = :branchCode")
    BranchDetails findByBranchCode(@Param("branchCode") String branchCode);

    // Find branch by IFSC code
    @Query("SELECT b FROM BranchDetails b WHERE b.ifscCode = :ifscCode")
    BranchDetails findByIfscCode(@Param("ifscCode") String ifscCode);

    // Find all branches by location
    @Query("SELECT b FROM BranchDetails b WHERE b.location = :location")
    List<BranchDetails> findByLocation(@Param("location") String location);
}
