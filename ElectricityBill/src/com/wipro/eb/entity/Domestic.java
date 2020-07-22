package com.wipro.eb.entity;

public class Domestic extends Connection{
	public Domestic(int currentReading, int previousReading,float slabs[])
	{
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		double cost=0.0;
		int u=currentReading-previousReading;
		if(u<50)
		{
			cost=50*slabs[0];
		}
		else if(u<100)
		{
			cost=50*slabs[0]+(u-50)*slabs[1];
		}
		else
		{
			cost=50*slabs[0]+50*slabs[1]+(u-100)*slabs[2];
		}
		return (float) cost;
	}
}
