package com.tverhulsdonk.wordcounter;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tverhulsdonk.wordcounter.model.WordFrequency;
import com.tverhulsdonk.wordcounter.service.WordFrequencyAnalyzer;
import com.tverhulsdonk.wordcounter.service.WordFrequencyAnalyzerImpl;

@SpringBootTest
public class WordcounterApplicationTests
{
	private WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
	
	
	@Test
	public void test1() throws Exception
	{
		String text = "The sun shines over the lake";
		String word = "The";
		int n = 5;
		
		executeTest(text, word, n);
	}
	
	
	@Test
	public void test2() throws Exception
	{
		String text = "I've been waiting on a war since I was young. Since I was a little boy with a toy gun. Never really wanted to be number one. Just wanted to love everyone. Is there more to this than that? Is there more to this than that? Is there more to this than that? Is there more to this. More to this, more to this than. Just waiting on a war? Just waiting on a war? Every day waiting for the sky to fall. Big crash on a world that's so small. Just a boy with nowhere left to go. Fell in love with a voice on the radio. Is there more to this than that? Is there more to this than that? Is there more to this than that? Is there more to this. More to this, more to this than. Just waiting on a war? Just waiting on a war? Just waiting on a war for this and that. There's got to be more to this than.";
		String word = "War";
		int n = 5;
		
		executeTest(text, word, n);
	}
	
	
	@Test
	public void test3() throws Exception
	{
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		String word = "Lorem";
		int n = 5;
		
		executeTest(text, word, n);
	}
	
	
	private void executeTest(String text, String word, int n)
	{
		int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(text);
		int frequencyForWord = wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
		List<WordFrequency> mostFrequentNWords = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);
		
		System.out.println("Test for sentence: [" + text + "]");
		System.out.println("HighestFrequency: " + highestFrequency);
		System.out.println("Frequency for word [" + word + "]: " + frequencyForWord);
		System.out.println("Most frequent " + n + " words: " + mostFrequentNWords);
		System.out.println();
	}
}
