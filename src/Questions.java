import java.io.Serializable;


public class Questions implements Serializable{
	private String question;
	private String answer;
	private String correctAnswer;
	
	 
	public Questions() {
		super();
	}
	public Questions(String question, String answer, String correctAnswer) {
		super();
		setQuestion(question);
		setAnswer(answer);
		setCorrectAnswer(correctAnswer);
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
}
