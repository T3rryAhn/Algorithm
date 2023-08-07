import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] inputSplit;
        Subject[] subjects = new Subject[20];
        for (int i = 0; i < 20; i++) {
            input = br.readLine();
            inputSplit = input.split(" ");

            switch (inputSplit[2]) {
                case "A+":
                    inputSplit[2] = "4.5";
                    break;
                case "A0":
                    inputSplit[2] = "4.0";
                    break;
                case "B+":
                    inputSplit[2] = "3.5";
                    break;
                case "B0":
                    inputSplit[2] = "3.0";
                    break;
                case "C+":
                    inputSplit[2] = "2.5";
                    break;
                case "C0":
                    inputSplit[2] = "2.0";
                    break;
                case "D+":
                    inputSplit[2] = "1.5";
                    break;
                case "D0":
                    inputSplit[2] = "1.0";
                    break;
                case "F":
                    inputSplit[2] = "0.0";
                    break;
                case "P":
                    inputSplit[2] = "-1";
                    break;
            }
            subjects[i] = new Subject(inputSplit[0], Double.parseDouble(inputSplit[1]), Double.parseDouble(inputSplit[2]));
        }
        br.close();

        GradeCal gradeCal = new GradeCal();
        double result = gradeCal.avg(subjects);
        System.out.println(result);
    }


}

class Subject {
    String name;
    double credit;
    double score; // -1 >> P

    public Subject(String name, double credit, double score) {
        this.name = name;
        this.credit = credit;
        this.score = score;
    }

}

class GradeCal {
    double credit = 0;
    double totalScore = 0;
    double avgScore = 0;

    double avg(Subject[] subjects) {
        for (int i = 0; i < 20; i++) {
            if (subjects[i].score < 0) {
                continue;
            }
            credit += subjects[i].credit;
            totalScore += subjects[i].score * subjects[i].credit;
        }
        avgScore = totalScore / credit;
        return avgScore;
    }
}
