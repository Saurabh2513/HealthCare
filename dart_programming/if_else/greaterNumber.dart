// 1. Take 2 numbers from user and check which one is greater

import 'dart:io';

void main() {
  print('Enter x');
  var x = int.parse(stdin.readLineSync()!);
  print('Enter y');
  var y = int.parse(stdin.readLineSync()!);

  if (x > y) {
    print('x is greater');
  }else{
    print('y is greater');
  }
}
