import 'dart:io';

void main() {
  stdout.write('Enter a string: ');
  String userString = stdin.readLineSync()!;

  int characterCount = 0;

  for (int i = 0; i < userString.length; i++) {
    if (userString[i] == " ") {
      characterCount++;
    }
  }
  print('Character count of the string: $characterCount');
}
