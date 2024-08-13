import 'package:flutter/material.dart';
import '../models/calculator_model.dart';

class CalculatorViewModel extends ChangeNotifier {
  final CalculatorModel _model = CalculatorModel();

  String get input => _model.input;
  String get result => _model.result;

  void addInput(String value) {
    _model.addInput(value);
    notifyListeners();
  }

  void calculateResult() {
    _model.calculateResult();
    notifyListeners();
  }

  void clear() {
    _model.clear();
    notifyListeners();
  }
}
