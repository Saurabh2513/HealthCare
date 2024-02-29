
/*

10. Create program to determine Student is Pass or Fail.
Take marks of 5 subjects.
English, Marathi, Hindi, Maths, Geo.
Check if Student has failed in any subject. if student is failed in any subject then show the subject name and marks.
If student is pass then show the percentage.

*/
import 'dart:io';

void main() {

  List<String> subjects = ["English", "Marathi", "Hindi", "Maths", "Geo"];
  List<double> marks = [];

  for (int i = 0; i < 5; i++) {
    stdout.write("Enter marks for ${subjects[i]}: ");
    marks.add(double.parse(stdin.readLineSync()!));
  }
  bool hasFailed = false;
  String failedSubject = "";
  double failedMarks = 0.0;

  for (int i = 0; i < 5; i++) {
    if (marks[i] < 40) {
      hasFailed = true;
      failedSubject = subjects[i];
      failedMarks = marks[i];
      break;
    }
  }

  if (hasFailed) {
    print("Student has failed in $failedSubject with marks: $failedMarks");
  } else {
    double totalMarks = marks.reduce((a, b) => a + b);
    double percentage = (totalMarks / (5 * 100)) * 100;
    print("Student has passed with a percentage of $percentage%");
  }
}

