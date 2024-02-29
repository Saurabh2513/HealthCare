import 'dart:io';

void main() {
  stdout.write('Enter a string: ');
  String userString = stdin.readLineSync()!;

  int characterCount = 0;
  int spaceCount = 0;
  int numberCount = 0;

  characterCount = userString.length;
  print('Characters count of the string: $characterCount');

  for (int i = 0; i < userString.length; i++) {
    if (userString[i] == " ") {
      spaceCount++;
    }
    if (isNumeric(userString[i])) {
      numberCount++;
    }
  }
  print("Numbers count of the String: $numberCount");
  print('Space count of the string: $spaceCount');
}

bool isNumeric(String s) {
  // Check if the string represents a numeric value
  return double.tryParse(s) != null;
}

/*
if (userString[i] == "$numberCount") {
      numberCount++;
    }
    print('Number count of the string: $numberCount');
 */
