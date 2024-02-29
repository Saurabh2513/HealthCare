import 'dart:io';

void main() {

  stdout.write('Enter the first string: ');
  String string1 = stdin.readLineSync()!;

  stdout.write('Enter the second string: ');
  String string2 = stdin.readLineSync()!;


  if (string1 == string2) {
    print('The strings are similar.');
  } else {
    print('The strings are not similar.');
  }
}
