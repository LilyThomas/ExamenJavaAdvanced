package edu.ap.spring;

import java.awt.Point;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


import org.springframework.stereotype.Component;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		List<Integer> nrs2 = toIntList(numbers);
		int[] primes =
				nrs2.stream()
				.filter(nr -> isPrime(nr))
				.mapToInt(nr -> nr).toArray();
		return primes;
	}
	
	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	//TODO
	public int countLowercaseCharacters(String string) {
		int result = 0;
		String stream = string.chars()
				.filter(Character::isLowerCase)
				.collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
				.toString();
		result = stream.length();
		return result;
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	//TODO
	public int sumOfX(List<Point> points) {
		List<Double> xs =
				points.stream()
				.map(p -> p.getX())
				.collect(Collectors.toList());

		double result = xs.stream().mapToDouble(Double::doubleValue).sum();
		return (int)result;
	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	//TODO
	public String getXOverTwo(List<Point> points) {
		List<String> xs = points.stream()
				.filter(p -> p.getX() >= 2)
				.map(p -> p.getX())
				.map(p -> String.format("%.0f", p))
				.collect(Collectors.toList());
		String result = String.join(",", xs);
		return result;
	}

	private boolean isPrime(int nr){
		if (nr < 2) return false;
		if (nr == 2) return true;
		if(nr % 2 == 0) return false;
		for(int i =  3; i * i <= nr; i += 2){
			if(nr % i == 0) return false;
		}
		return true;
	}

	private List<Integer> toIntList(int[] nrs){
		List<Integer> nrs2 = new ArrayList<>();
		for(int nr: nrs){
			nrs2.add(nr);
		}
		return nrs2;
	}
}
