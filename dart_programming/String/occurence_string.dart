import 'dart:io';

void main() {
  stdout.write('Enter a string: ');
  String userInput = stdin.readLineSync()!;

  stdout.write('Enter the character to find: ');
  String charToFind = stdin.readLineSync()!;

  int occurrenceCount = findCharacterOccurrence(userInput, charToFind);

  print(
      'The character "$charToFind" occurs $occurrenceCount times in the string.');
}

int findCharacterOccurrence(String inputString, String charToFind) {
  int occurrenceCount = 0;

  for (int i = 0; i < inputString.length; i++) {
    if (inputString[i] == charToFind) {
      occurrenceCount++;
    }
  }

  return occurrenceCount;
}
