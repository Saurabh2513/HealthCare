import 'dart:io';

void main() {
  stdout.write("Enter name:");
  String name = stdin.readLineSync()!;
  int length = 0;

  for (int i = 0; i < name.length; i++) {
    length++;
  }
  print("the length of String is: $length ");
}

