package com.tverhulsdonk.wordcounter.web;

import java.util.Collections;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tverhulsdonk.wordcounter.model.WordFrequency;
import com.tverhulsdonk.wordcounter.service.WordFrequencyAnalyzer;

@RestController
@RequestMapping("wordcounter")
public class WordFrequencyAnalyzerController
{
	private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

	
	public WordFrequencyAnalyzerController(WordFrequencyAnalyzer wordFrequencyAnalyzer)
	{
		this.wordFrequencyAnalyzer = wordFrequencyAnalyzer;
	}
	
	
	@GetMapping("highestFrequency/{text}")
	public int calculateHighestFrequency(@PathVariable String text)
	{
		if (!StringUtils.hasText(text))
		{
			return 0;
		}
		return wordFrequencyAnalyzer.calculateHighestFrequency(text);
	}
	
	
	@GetMapping("frequencyForWord/{text}/{word}")
	public int calculateFrequencyForWord(@PathVariable String text, @PathVariable String word)
	{
		if (!StringUtils.hasText(text) || !StringUtils.hasText(word))
		{
			return 0;
		}
		return wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
	}
	
	
	@GetMapping("mostFrequentNWord/{text}/{n}")
	public List<WordFrequency> calculateMostFrequentNWords(@PathVariable String text, @PathVariable int n)
	{
		if (!StringUtils.hasText(text) || n < 1)
		{
			return Collections.emptyList();
		}
		return wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);
	}
}
