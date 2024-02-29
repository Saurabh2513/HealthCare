import 'dart:io';

void main() {
  print("Enter table number: ");
  var num = int.parse(stdin.readLineSync()!);

 for(int i = 1; i <= 10; i++){
   int result = num * i;
   print(" $result");
 }
}
