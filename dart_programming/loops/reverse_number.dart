import 'dart:io';

void main() {
  stdout.write('Enter a number: ');
  int originalNumber = int.parse(stdin.readLineSync()!);

  int reversedNumber = reverseNumber(originalNumber);

  print('Original number: $originalNumber');
  print('Reversed number: $reversedNumber');
}

int reverseNumber(int number) {
  String numberString = number.toString();
  String reversedString = numberString.split('').reversed.join();
  int reversedNumber = int.parse(reversedString);
  return reversedNumber;
}
