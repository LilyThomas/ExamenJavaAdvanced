package edu.ap.spring.view;

import edu.ap.spring.jpa.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {
    private UI ui;
    private QuestionRepository repository;

    @Autowired
    public void setRepository(QuestionRepository repository){
        this.repository = repository;
    }

    @Autowired
    public void setUI(UI ui){
        this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent ae){

    }
}
