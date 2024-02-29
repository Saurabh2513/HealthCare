import 'dart:io';

void main() {
  print("Enter a Number:");
  String input = stdin.readLineSync()!;
  int number = int.parse(input);
  int factorial = 1;

  for (int i = 1; i <= number; i++) {
    factorial *= i;
  }
  print("Factorial of $number is: $factorial");
}

