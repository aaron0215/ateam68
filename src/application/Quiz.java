package application;

public class Quiz {
  
  Question[] quizQuestion;
  double score = quizQuestion.length;

  Quiz (Question[] questions){
    this.quizQuestion = questions;
    this.score = questions.length;
  }
  
  public Question[] getQuizQuestion() {
    return quizQuestion;
  }
  
  // Set score 1 point off.
  public void pointDeduction() {
    score--;
  }
  
  // Convert score to percentage and return
  public double getScore() {
    return (score/quizQuestion.length)*100;
  }
  
}
