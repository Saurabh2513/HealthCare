import 'dart:io';

void main() {
  print("Enter Number:");
  var number = int.parse(stdin.readLineSync()!);

  if (number % 5 == 0 && number % 7 == 0) {
    print("$number is divisible by 5 and 7.");
  } else if (number % 5 == 0) {
    print("$number is divisible by 5");
    print("$number is note divisible by 7");
  } else if (number % 7 == 0) {
    print("$number is divisible by 7");
    print("$number is note divisible by 5");
  }else{
    print("$number is not divisible by 5 and 7");
  }
}