package com.wipro.eb.entity;

public class Commercial extends Connection{
	public Commercial(int currentReading, int previousReading,float slabs[])
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
		if(cost<5000)
		{
			cost+=cost*0.02;
		}
		else if(cost>=5000 && cost<10000)
		{
			cost+=cost*0.06;
		}
		else
			cost+=cost*0.09;
		return (float) cost;
	} 

}
