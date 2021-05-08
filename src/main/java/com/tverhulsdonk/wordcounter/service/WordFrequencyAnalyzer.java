package com.tverhulsdonk.wordcounter.service;

import java.util.List;

import com.tverhulsdonk.wordcounter.model.WordFrequency;

public interface WordFrequencyAnalyzer
{
	public int calculateHighestFrequency(String text);
	
	public int calculateFrequencyForWord(String text, String word);
	
	public List<WordFrequency> calculateMostFrequentNWords(String text, int n);
}
