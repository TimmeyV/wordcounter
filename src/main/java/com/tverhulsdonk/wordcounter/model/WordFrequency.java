package com.tverhulsdonk.wordcounter.model;

public interface WordFrequency
{
	public String getWord();
	
	public int getFrequency();
	
	public void upgradeFrequency();
	
	public String toString();
}
