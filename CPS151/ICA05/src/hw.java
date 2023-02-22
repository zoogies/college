public class hw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("CPS 151 ICA05 by Ryan Zmuda");
        Student s = new Student("Ryan");
        s.addQuiz(25);
        s.addQuiz(20);
        s.addQuiz(23);
        System.out.printf("%s%s%n", "Grade report for ", s.getName());
        System.out.printf("%s%d%n", "Number of quizzes: ", s.getQuizCount());
        System.out.printf("%s%d%n", "Total score: ", s.getTotalScore());
        System.out.printf("%s%.2f%n", "Average score: ", s.getAverageScore());
        System.out.println("That's all folks!");
    } // end main
    
} // end class

//-------------- class Student

class Student {
    // define instance variables here
	String studentname;
	int numberquizzes = 0;
	int totalscore = 0;
    // complete the constructor
    public Student(String name) {
        this.studentname = name;
    } // end constructor
    
    public void addQuiz(int Score) {
        this.numberquizzes++;
        this.totalscore += Score;
    } // end method
    
    public String getName() {
        return this.studentname;
    }
    
    public int getTotalScore() {
        return this.totalscore;
    }
    
    public int getQuizCount() {
        return this.numberquizzes;
    }
    
    public double getAverageScore() {
        return this.totalscore / this.numberquizzes;
    }
    
} // end class