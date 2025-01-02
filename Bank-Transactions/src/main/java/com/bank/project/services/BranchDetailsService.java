package com.bank.project.services;

import java.util.List;
import java.util.Optional;

import com.bank.project.models.BranchDetails;

public interface BranchDetailsService {

	BranchDetails createBranch(BranchDetails branchDetails);

	List<BranchDetails> getAllBranches();

	Optional<BranchDetails> getBranchById(Integer id);

	BranchDetails updateBranch(Integer id, BranchDetails updatedBranchDetails);

	void deleteBranch(Integer id);

}