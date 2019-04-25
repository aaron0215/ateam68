package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuizGenerator {

  Quiz quiz;
  ArrayList<Question> questionBank;

  // Read in all questions
  QuizGenerator(String filePath) throws FileNotFoundException, IOException, ParseException {
    Object input = new JSONParser().parse(new FileReader(filePath));
    JSONObject jo = (JSONObject) input; // Typecast
    // Get question array
    JSONArray ja = (JSONArray) jo.get("questionArray");
    // Iterate JSONArray
    Iterator itr = ja.iterator();
    Question q;

    while (itr.hasNext()) {
      JSONObject obj = (JSONObject) itr.next();
      String questionText = (String) obj.get("name");
      String topic = (String) obj.get("topic");
      String imagePath = (String) obj.get("image");
      // Read through choices
      JSONArray ja2 = (JSONArray) obj.get("choiceArray");
      Iterator itr2 = ja2.iterator();
      String[] choices = new String[5];
      String correctAnswer = null;
      int index = 0;
      while (itr2.hasNext()) {
        JSONObject obj2 = (JSONObject) itr.next();
        choices[index] = (String) obj2.get("choice");
        if(((String)obj2.get("isCorrect")).equals("T")) {
          correctAnswer = choices[index];
        }
        if (imagePath.equals("none")) {
          // call corresponding question constructor
          q = new Question(questionText, choices, topic, correctAnswer);
        } else {
          // call corresponding question constructor
          q = new Question(questionText, choices, imagePath, topic, correctAnswer);
        }
        questionBank.add(q);
      }
    }
  }

  // Create a Quiz object with questions with selected topic and given amount
  public void generateQuiz(String topic, int amount) {
    int count = 0;
    ArrayList<Question> quizQuestions = new ArrayList<>();
    for (Question question : questionBank) {
      if (question.getTopic().equals(topic) && count < amount) {
        quizQuestions.add(question);
        count++;
      } else if (count >= amount) {
        break;
      }
    }
    quiz = new Quiz(quizQuestions);
  }

  public void save(String filePath) {

  }

  public void addNewQuestion(Question newQuestion) {
    questionBank.add(newQuestion);
  }

  public Quiz getQuiz() {
    return quiz;
  }
}
