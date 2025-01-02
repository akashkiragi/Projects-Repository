package com.bank.project.resource;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bank.project.dto.ErrorDTO;
import com.bank.project.dto.ResponseDTO;
import com.bank.project.exception.AccountHandleException;
import com.bank.project.models.BankAccount;
import com.bank.project.services.BankTransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/bank-acounts")
@Tag(name = "Bank-transactions", description = "Bank Transactions Controller")
public class DataResources {
	
	@Autowired
	BankTransactionService bankTrans;
	
	@Value("${app.bank.account.length}")
	private int accountNumLen;
	
	@GetMapping("/accounts/{accountNumber}")	
	@Operation(summary = "", description = "Fetch the Account details from Account Number", tags = "Bank-transactions")
	 @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "Successfully retrieved account details",
	                    content = @Content(schema = @Schema(implementation = BankAccount.class))),
	            @ApiResponse(responseCode = "404", description = "Account not found",
	                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
	    })	
	public ResponseDTO<BankAccount>  getAccountByAccNum(@PathVariable("accountNumber") long  accountNumber) {
		int accountNumberLength = Long.toString(Math.abs(accountNumber)).length();
		if(accountNumberLength != accountNumLen) {
			throw new AccountHandleException("The length of the account Number must be 12", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseDTO<>(HttpStatus.CREATED.value(), bankTrans.getAccountBayAccountNum(accountNumber), java.time.ZonedDateTime.now().toString());
	}
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "201", description = "Created" ,content = @Content(schema = @Schema(hidden = true))),
			@ApiResponse(responseCode = "401", description = "Unauthorized" ,content = @Content(schema = @Schema(hidden = true))),
			@ApiResponse(responseCode = "403", description = "Forbidden" ,content = @Content(schema = @Schema(hidden = true))),
			@ApiResponse(responseCode = "404", description = "Not Found" ,content = @Content(schema = @Schema(hidden = true)))})
	@GetMapping("/accounts")	
	public ResponseDTO<List<BankAccount>>  getAccount() {		
		return new ResponseDTO<>(HttpStatus.OK.value(), bankTrans.getAccounts(), java.time.ZonedDateTime.now().toString());
	}
	
	
	@PostMapping("/NewAccount")
	public ResponseDTO<Optional<BankAccount>> createNewAccount(@RequestBody BankAccount bankAccount ) {
		return new ResponseDTO<>(HttpStatus.CREATED.value(), bankTrans.createBankAccount(bankAccount), java.time.ZonedDateTime.now().toString());
			
	}
	
	@PostMapping("/update-account/{type}")
	public String createNewAccount(@RequestBody BankAccount bankAccount, @PathVariable("type") String type ){
		bankTrans.updateTheBankAccount(bankAccount, type);
		return "Updaetd";
	}
	
	

	
}



 