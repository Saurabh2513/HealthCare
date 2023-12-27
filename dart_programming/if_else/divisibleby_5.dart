import 'dart:io';

void main() {

  stdout.write("Enter a number: ");

  var number = int.parse(stdin.readLineSync()!);


  if (number % 5 == 0) {
    print("$number is divisible by 5.");
  } else {
    print("$number is not divisible by 5.");
  }
}
