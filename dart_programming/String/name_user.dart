import 'dart:io';

void main() {
  print('Enter your first name: ');
  String firstName = stdin.readLineSync()!;

  print('Enter your middle name: ');
  String middleName = stdin.readLineSync()!;

  print ('Enter your last name: ');
  String lastName = stdin.readLineSync()!;

  String fullName = '$firstName $middleName $lastName';

  print('Your full name is: $fullName');
}
