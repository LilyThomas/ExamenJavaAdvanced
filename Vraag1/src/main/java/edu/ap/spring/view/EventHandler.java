package edu.ap.spring.view;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {
    private UI ui;
    private QuestionRepository repository;
    private EightBall eightBall;

    @Autowired
    public void setRepository(QuestionRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUI(UI ui) {
        this.ui = ui;
    }

    @Autowired
    public void setEightBall(EightBall eightBall) {
        this.eightBall = eightBall;
    }

    public void whenButtonClicked(ActionEvent ae) {
        String questionAsked = ui.getQuestionField().getText();
        String answer = eightBall.getRandomAnswer(questionAsked);

        Question question = new Question(questionAsked, answer);
        repository.save(question);

        System.out.println("Find all:");
        repository.findAll().forEach(System.out::println);

        ui.update(answer);

    }
}