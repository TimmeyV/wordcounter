package com.tverhulsdonk.wordcounter.model;

public class WordFrequencyImpl implements WordFrequency
{
	private String word;

	private int frequency;

	
	public WordFrequencyImpl(String word)
	{
		this.word = word;
		this.frequency = 1;
	}


	@Override
	public String getWord()
	{
		return word;
	}


	@Override
	public int getFrequency()
	{
		return frequency;
	}


	@Override
	public void upgradeFrequency()
	{
		this.frequency++;
	}
	
	
	@Override
	public String toString()
	{
		return "(word=" + word + ", frequency=" + frequency + ")";
	}
}
