import 'dart:io';

void main() {
  stdout.write('Enter a number: ');
  int originalNumber = int.parse(stdin.readLineSync()!);

  if (isPalindrome(originalNumber)) {
    print('$originalNumber is a palindrome.');
  } else {
    print('$originalNumber is not a palindrome.');
  }
}

bool isPalindrome(int number) {
  String numberString = number.toString();

  String reversedString = numberString.split('').reversed.join();

  return numberString == reversedString;
}
