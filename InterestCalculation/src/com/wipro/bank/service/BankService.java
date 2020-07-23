package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	public boolean validateData(float principal, int tenure,int age, String gender)
	{
		try
		{
			 if(principal<500 || !(tenure==5 || tenure==10) || age<1 || age> 100 || !(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")))
	                throw new BankValidationException();
		}
		catch (BankValidationException e)
		{
			return false;
		}
		return true;
	}
	public void calculate(float principal,int tenure, int age, String gender)
	{
	boolean b=validateData(principal, tenure, age, gender);
	System.out.println(b);
	System.out.println(principal);
    System.out.println(tenure);
    System.out.println(age);
    System.out.println(gender);
	if(b)
	{
		RDAccount rda=new RDAccount(tenure,principal);
        rda.setInterest(age, gender);
        float maturityIntrest=rda.calculateInterest();
        float totalPrincipleDeposited=rda.calculateAmountDeposited();
        System.out.println(maturityIntrest);
        System.out.println(totalPrincipleDeposited);
        System.out.println(rda.calculateMaturityAmount(totalPrincipleDeposited,maturityIntrest));
		
	}
	}
}
