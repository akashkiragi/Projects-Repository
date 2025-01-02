package com.bank.project.controllers;

import org.springframework.web.bind.annotation.*;

import com.bank.project.models.BranchDetails;
import com.bank.project.services.BranchDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/branches")
public class BranchDetailsController {
    private final BranchDetailsService branchDetailsService;

    @Autowired
    public BranchDetailsController(BranchDetailsService branchDetailsService) {
        this.branchDetailsService = branchDetailsService;
    }

    @PostMapping
    public BranchDetails createBranch(@RequestBody BranchDetails branchDetails) {
        return branchDetailsService.createBranch(branchDetails);
    }

    @GetMapping
    public List<BranchDetails> getAllBranches() {
        return branchDetailsService.getAllBranches();
    }

    @GetMapping("/{id}")
    public Optional<BranchDetails> getBranchById(@PathVariable Integer id) {
        return branchDetailsService.getBranchById(id);
    }

    @PutMapping("/{id}")
    public BranchDetails updateBranch(@PathVariable Integer id, @RequestBody BranchDetails branchDetails) {
        return branchDetailsService.updateBranch(id, branchDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Integer id) {
        branchDetailsService.deleteBranch(id);
    }
}
