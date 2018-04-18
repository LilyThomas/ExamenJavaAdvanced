package edu.ap.spring.model;
import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.view.EventHandler;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class EightBall {
	List<Integer> alreadyUsed = new ArrayList<>();
	Random rnd = new Random();
	QuestionRepository repository;

	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};

	List<Question> askedQuestions = new ArrayList<>();
	int count = answers.length;
	List<Integer> used = new ArrayList<>();
	
	public String getRandomAnswer(String question) {
		String answer;
		int x = -1;

		if(count != answers.length){
			while(used.contains(x)) {
				x = rnd.nextInt(answers.length);
				used.add(x);
			}
			count++;
		} else{
			x = rnd.nextInt(answers.length);
		}

		answer = answers[x];

		return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}



}
