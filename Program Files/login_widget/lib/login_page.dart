import 'package:flutter/material.dart';
import 'package:flutter_login/flutter_login.dart';

class LogInPage extends StatelessWidget {
  const LogInPage({super.key});

// Login Time

Duration get lodingTime => const Duration(milliseconds: 2000); 

  // login
  Future<String?> _authUser(LoginData data){
    return Future.delayed(lodingTime).then((value)=> null);
  }

  // forgot password
  Future<String?> _recoverPassword(String data){
        return Future.delayed(lodingTime).then((value)=> null);

  }
  Future<String?> _signupUser(SignupData data){
        return Future.delayed(lodingTime).then((value)=> null);

  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: FlutterLogin(
        onLogin: _authUser,
        onRecoverPassword: _recoverPassword,
        onSignup: _signupUser,
      ),
    );
  }
}
