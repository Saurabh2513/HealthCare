import 'dart:io';

void main() {
  List<int> numbers = [];
  for (int i = 0; i < 5; i++) {
    print("enter numbers: ${i + 1}:");
    int num = int.parse(stdin.readLineSync()!);
    numbers.add(num);
  }
  print('small number: ${smallestNumber(numbers)}');
  print('biggest number: ${biggestNumber(numbers)}');
}

int smallestNumber(List<int> numbers) {
  var smallNumber = numbers.first;
  for (final num in numbers) {
    if (smallNumber >= num) {
      smallNumber = num;
    }
  }
  return smallNumber;
}

int biggestNumber(List<int> numbers) {
  var biggestNumber = numbers.first;
  for (final num in numbers) {
    if (biggestNumber < num) {
      biggestNumber = num;
    }
  }
  return biggestNumber;
}
