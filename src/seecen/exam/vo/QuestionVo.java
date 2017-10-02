package seecen.exam.vo;

import java.util.List;

import seecen.exam.po.Question;
import seecen.exam.po.QuestionOption;

public class QuestionVo {
	private Question question;
	private List<QuestionOption> options;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<QuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOption> options) {
		this.options = options;
	}

}
