import 'package:math_expressions/math_expressions.dart';

class CalculatorModel {
  String _input = "";
  String _result = "0";

  String get input => _input;
  String get result => _result;

  void addInput(String value) {
    _input += value;
  }

  void calculateResult() {
    try {
      _result = _evaluate(_input);
    } catch (e) {
      _result = "Error";
    }
  }

  void clear() {
    _input = "";
    _result = "0";
  }

  String _evaluate(String expression) {
    Parser parser = Parser();
    Expression exp = parser.parse(expression);
    ContextModel cm = ContextModel();
    double eval = exp.evaluate(EvaluationType.REAL, cm);
    return eval.toString();
  }
}
