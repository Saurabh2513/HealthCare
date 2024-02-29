import 'dart:io';

void main() {
  stdout.write('Enter a String: ');
  String string = stdin.readLineSync()!;

  String reversedString = '';

  for (int i = string.length - 1;i >= 0;i--) {
reversedString += string[i];
  }
  print("reverse String: $reversedString");
}
