package application;

public class Question {
  public String questionText;
  public String imageFile;
  public String[] choiceArray;
  public String topic;
  public boolean status;
  
  // Constructor without image input
  public Question (String questionText, String[] choiceArray, String topic, boolean status) {
    
  }
  
  // Constructor with image input
  public Question (String questionText, String[] choiceArray, String imagePath, String topic, boolean status ) {
    
  }
  
  public void setStatus (boolean status) {
    
  }
  
  public String getQuestion() {
    return null;
  }
  
  // Return image path
  public String getImage() {
    return null;
  }
  
  public String getTopic() {
    return null;
  }
  
  public String[] getChoices() {
    return null;
  }
  
  public boolean getStatus() {
    return false;
  }
}
