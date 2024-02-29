import 'dart:io';

void main() {
  print("enter first number: ");
  // var num1 = int.parse(stdin.readLineSync()!);
  double num1 = double.parse(stdin.readLineSync()!);
  print("select operator: (+,-,*,/) ");
  final operator = stdin.readLineSync()!;
  print("enter second number: ");
 // var num2 = int.parse(stdin.readLineSync()!);
  double num2 = double.parse(stdin.readLineSync()!);

  double result;
  if (operator == '+') {
    result = num1 + num2;
  } else if (operator == '-') {
    result = num1 - num2;
  } else if (operator == '*') {
    result = num1 * num2;
  } else if (operator == '/') {
    if (num2 != 0) {
      result = num1 / num1;
    } else {
      print("Error: Division by zero is not allowed.");
      return;
    }
  } else {
    print("Error: Invalid operator entered.");
    return;
  }
  print("result:$num1 $operator $num2 = $result");
}