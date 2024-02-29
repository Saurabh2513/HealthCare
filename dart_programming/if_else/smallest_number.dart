// Print smallest number among three.
import 'dart:io';

void main() {
  print("Enter First Number");
  var a = int.parse(stdin.readLineSync()!);
  print("Enter Second Number");
  var b = int.parse(stdin.readLineSync()!);
  print("Enter Third Number");
  var c = int.parse(stdin.readLineSync()!);

  if (a < b && a < c) {
    print("$a is Smallest Number");
  } else if (b < a && b < c) {
    print("$b is Smallest Number");
  } else {
    print("$c is Smallest Number");
  }
}
