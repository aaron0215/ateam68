package application;

public class Question {
  public String questionText;
  public String imageFile;
  public String[] choiceArray;
  public String topic;
  
  // Constructor without image input
  public Question (String questionText, String[] choiceArray, String topic) {
    this.questionText = questionText;
    this.choiceArray = choiceArray;
    this.topic = topic;
  }
  
  // Constructor with image input
  public Question (String questionText, String[] choiceArray, String imagePath, String topic) {
    this.questionText = questionText;
    this.choiceArray = choiceArray;
    this.topic = topic;
    this.imageFile = imagePath;
  }
  
  public String getQuestion() {
    return questionText;
  }
  
  // Return image path
  public String getImage() {
    return imageFile;
  }
  
  public String getTopic() {
    return topic;
  }
  
  public String[] getChoices() {
    return choiceArray;
  }
  
}
