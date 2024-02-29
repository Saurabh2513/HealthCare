import 'dart:io';

void main() {
  List<int> marksList = [];

  for (int i = 0; i < 5; i++) {
    stdout.write('Enter marks for student ${i + 1}: ');
    int marks = int.parse(stdin.readLineSync()!);
    marksList.add(marks);
  }

  List<double> percentages = calculatePercentages(marksList);

  for (int i = 0; i < 5; i++) {
    print(
        'Student ${i + 1}: Marks = ${marksList[i]}, Percentage = ${percentages[i]}%');
  }
}

List<double> calculatePercentages(List<int> marksList) {
  List<double> percentages = [];

  for (int marks in marksList) {
    double percentage = (marks / 100) * 100;
    percentages.add(percentage);
  }

  return percentages;
}
