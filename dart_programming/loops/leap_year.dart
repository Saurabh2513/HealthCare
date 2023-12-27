void main() {
  int startYear = 2000;
  int endYear = 3000;

  for (int year = startYear; year <= endYear; year++) {
    if (isLeapYear(year)) {
      print('$year is a leap year.');
    }
  }
}

bool isLeapYear(int year) {
  if (year % 4 != 0) {
    return false;
  } else if (year % 100 != 0) {
    return true;
  } else if (year % 400 != 0) {
    return false;
  } else {
    return true;
  }
}
