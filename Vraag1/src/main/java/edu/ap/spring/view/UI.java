package edu.ap.spring.view;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class UI implements InitializingBean {
	@Autowired
	EventHandler eventHandler;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}

	private JFrame jFrame;
	private JPanel controlPanel;
	private JLabel label, answerLabel;
	private JTextField questionField;
	private JButton askBtn;

	public UI(){};

	public void setupUI(){
		jFrame = new JFrame("Spring 8-ball");
		jFrame.setLayout(new FlowLayout());

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2,2));

		label = new JLabel("What is your question?");
		questionField = new JTextField(50);

		answerLabel = new JLabel();

		askBtn = new JButton();
		askBtn.setText("Ask away!");
		askBtn.setTransferHandler(new TransferHandler("text"));
		askBtn.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(label);
		controlPanel.add(questionField);
		controlPanel.add(answerLabel);
		controlPanel.add(askBtn);

		jFrame.add(controlPanel);

		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getAnswerLabel() {
		return answerLabel;
	}

	public void setAnswerLabel(JLabel answerLabel) {
		this.answerLabel = answerLabel;
	}

	public JTextField getQuestionField() {
		return questionField;
	}

	public void setQuestionField(JTextField questionField) {
		this.questionField = questionField;
	}

	public JButton getAskBtn() {
		return askBtn;
	}

	public void setAskBtn(JButton askBtn) {
		this.askBtn = askBtn;
	}

	public void update(String answer){
		answerLabel.setText(answer);
	}

}
