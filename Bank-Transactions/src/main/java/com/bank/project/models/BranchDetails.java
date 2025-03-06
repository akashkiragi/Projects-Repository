package com.bank.project.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "branch_details")
public class BranchDetails implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1437045975514293514L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "branch_code", unique = true, nullable = false)
    private String branchCode;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "ifsc_code", unique = true, nullable = false)
    private String ifscCode;

    
    
   

    public BranchDetails(String branchCode) {
		this.branchCode = branchCode;
	}

	public BranchDetails(String branchCode, String ifscCode) {
		this.branchCode = branchCode;
		this.ifscCode = ifscCode;
	}

	// Getters and Setters
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

}
