import 'dart:io';

void main() {
  bool continueChecking = true;

  while (continueChecking) {
    stdout.write('Enter a string: ');
    String userString = stdin.readLineSync()!;


      int characterCount = userString.length;
      print('Character count of the string: $characterCount');

  }
}



