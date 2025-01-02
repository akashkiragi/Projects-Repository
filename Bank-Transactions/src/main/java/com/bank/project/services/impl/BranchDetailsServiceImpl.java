package com.bank.project.services.impl;
import org.springframework.stereotype.Service;

import com.bank.project.models.BranchDetails;
import com.bank.project.repositories.BranchDetailsRepository;
import com.bank.project.services.BranchDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class BranchDetailsServiceImpl implements BranchDetailsService {
    private final BranchDetailsRepository branchDetailsRepository;

    @Autowired
    public BranchDetailsServiceImpl(BranchDetailsRepository branchDetailsRepository) {
        this.branchDetailsRepository = branchDetailsRepository;
    }

    @Override
	public BranchDetails createBranch(BranchDetails branchDetails) {
        return branchDetailsRepository.save(branchDetails);
    }

    @Override
	public List<BranchDetails> getAllBranches() {
        return branchDetailsRepository.findAll();
    }

    @Override
	public Optional<BranchDetails> getBranchById(Integer id) {
        return branchDetailsRepository.findById(id);
    }

    @Override
	public BranchDetails updateBranch(Integer id, BranchDetails updatedBranchDetails) {
        return branchDetailsRepository.findById(id).map(branch -> {
            branch.setBranchCode(updatedBranchDetails.getBranchCode());
            branch.setLocation(updatedBranchDetails.getLocation());
            branch.setIfscCode(updatedBranchDetails.getIfscCode());
            return branchDetailsRepository.save(branch);
        }).orElseThrow(() -> new RuntimeException("Branch not found"));
    }

    @Override
	public void deleteBranch(Integer id) {
        branchDetailsRepository.deleteById(id);
    }
}
