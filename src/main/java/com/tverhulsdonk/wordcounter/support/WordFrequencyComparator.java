package com.tverhulsdonk.wordcounter.support;

import java.util.Comparator;

import com.tverhulsdonk.wordcounter.model.WordFrequency;

public class WordFrequencyComparator implements Comparator<WordFrequency>
{
	@Override
	public int compare(WordFrequency o1, WordFrequency o2)
	{
		if (o1.getFrequency() > o2.getFrequency())
		{
			return -1;
		}
		else if (o1.getFrequency() < o2.getFrequency())
		{
			return 1;
		}
		
		return o1.getWord().compareToIgnoreCase(o2.getWord());
	}

}
