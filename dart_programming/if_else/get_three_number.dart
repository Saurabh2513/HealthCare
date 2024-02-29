import 'dart:io';

void main() {
  print("Enter First Number:");
  var a = int.parse(stdin.readLineSync()!);
  print("Enter second Number:");
  var b = int.parse(stdin.readLineSync()!);
  print("Enter Third Number:");
  var c = int.parse(stdin.readLineSync()!);

  if (a > b && a > c) {
    print("$a is greater number");
  }
   else if ( b > a && b > c) {
    print("$b is greater number");
  }
  else{
    print("$c greater number");
  }
}
