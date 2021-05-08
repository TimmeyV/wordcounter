package com.tverhulsdonk.wordcounter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tverhulsdonk.wordcounter.model.WordFrequency;
import com.tverhulsdonk.wordcounter.model.WordFrequencyImpl;
import com.tverhulsdonk.wordcounter.support.WordFrequencyComparator;

@Service
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer
{
	@Override
	public int calculateHighestFrequency(String text)
	{
		List<WordFrequency> wordFrequencies = parseText(text);
		if (CollectionUtils.isEmpty(wordFrequencies))
		{
			return 0;
		}
		//return first because list is sorted by frequency
		return wordFrequencies.get(0).getFrequency();
	}


	@Override
	public int calculateFrequencyForWord(String text, String word)
	{
		if (!StringUtils.hasText(word))
		{
			System.out.println("Error: Missing input word");
			return 0;
		}
		
		List<WordFrequency> wordFrequencies = parseText(text);
		for (WordFrequency wordFrequency : wordFrequencies)
		{
			if (wordFrequency.getWord().equalsIgnoreCase(word))
			{
				return wordFrequency.getFrequency();
			}
		}
		return 0;
	}


	@Override
	public List<WordFrequency> calculateMostFrequentNWords(String text, int n)
	{
		List<WordFrequency> wordFrequencies = parseText(text);
		//return first n objects because list is sorted by frequency
		return wordFrequencies.subList(0, n);
	}

	
	private List<WordFrequency> parseText(String text)
	{
		if (!StringUtils.hasText(text))
		{
			System.out.println("Error: Missing input text");
			return Collections.emptyList();
		}
		
		Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
		Matcher wordMatcher = wordPattern.matcher(text);
		
		Map<String, WordFrequency> wordFrequencyMap = new HashMap<>();
		while (wordMatcher.find())
		{
			String word = wordMatcher.group().toLowerCase();
			
			if (wordFrequencyMap.containsKey(word))
			{
				wordFrequencyMap.get(word).upgradeFrequency();
			}
			else
			{
				WordFrequency wordFrequency = new WordFrequencyImpl(word);
				wordFrequencyMap.put(word, wordFrequency);
			}
		}
		
		List<WordFrequency> wordFrequencyList = new ArrayList<WordFrequency>(wordFrequencyMap.values());
		Collections.sort(wordFrequencyList, new WordFrequencyComparator());
		
		return wordFrequencyList;
	}
}
