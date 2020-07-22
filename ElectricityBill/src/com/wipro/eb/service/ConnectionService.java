package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException,InvalidConnectionException
	{
		if(currentReading < previousReading || previousReading<0 || currentReading<0)
		{
			throw new InvalidReadingException();
		}
		if(!(type.equals("Domestic")|| type.equals("Commercial")))
		{
			throw new InvalidConnectionException();
		}
		return true;
		
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		float bill=0.0f;
		try
		{
			if(validate(currentReading,previousReading,type))
			{
				float slabs[]=new float[3];
				if(type.equals("Domestic"))
				{
					slabs[0]=2.3f;
					slabs[1]=4.2f;
					slabs[2]=5.5f;
					Connection c =new Domestic(currentReading,previousReading,slabs);
					 bill= c.computeBill();

				}
				else
				{
					slabs[0]=5.2f;
					slabs[1]=6.8f;
					slabs[2]=8.3f;
					Connection c =new Commercial(currentReading,previousReading,slabs);
					 bill=c.computeBill();
				}
				
			}
		}
		catch(InvalidReadingException e){
            return -1;
        } catch(InvalidConnectionException e){
            return -2;
        }
		return bill;
	}
	public String generateBill(int currentReading, int previousReading, String type)
	{
		float val=calculateBillAmt(currentReading,previousReading,type);
		if(val==-1)
		{
			return "Incorrect Reading";
		}
		else if(val==-2)
		{
			return "Invalid ConnectionType";
		}
		else
			return"Amount to be paid:"+val;
	}
}
