import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../viewmodels/calculator_viewmodel.dart';

class CalculatorView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final viewModel = Provider.of<CalculatorViewModel>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text('MVVM Calculator'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          Expanded(
            child: Container(
              padding: EdgeInsets.all(20),
              alignment: Alignment.bottomRight,
              child: Text(
                viewModel.input,
                style: TextStyle(fontSize: 32, fontWeight: FontWeight.bold),
              ),
            ),
          ),
          Expanded(
            child: Container(
              padding: EdgeInsets.all(20),
              alignment: Alignment.bottomRight,
              child: Text(
                viewModel.result,
                style: TextStyle(fontSize: 48, fontWeight: FontWeight.bold),
              ),
            ),
          ),
          _buildButtonGrid(viewModel),
        ],
      ),
    );
  }

  Widget _buildButtonGrid(CalculatorViewModel viewModel) {
    return Expanded(
      flex: 3,
      child: GridView.builder(
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 4,
          mainAxisSpacing: 8,
          crossAxisSpacing: 8,
        ),
        padding: EdgeInsets.all(16),
        itemCount: _buttons.length,
        itemBuilder: (context, index) {
          return _buildButton(_buttons[index], viewModel);
        },
      ),
    );
  }

  Widget _buildButton(String label, CalculatorViewModel viewModel) {
    return ElevatedButton(
      onPressed: () {
        if (label == '=') {
          viewModel.calculateResult();
        } else if (label == 'C') {
          viewModel.clear();
        } else {
          viewModel.addInput(label);
        }
      },
      child: Text(label, style: TextStyle(fontSize: 24)),
    );
  }

  final List<String> _buttons = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    'C', '0', '=', '+',
  ];
}
