// 1. Take 2 numbers from user and check which one is greater

import 'dart:io';

void main() {
  print('Enter x');
  var x = int.parse(stdin.readLineSync()!);
  print('Enter y');
  var y = int.parse(stdin.readLineSync()!);

  if(x > y){
    print("the number is $x and x is greater");
  }else{
    print("the number is $y and y is greater");
  }
}
