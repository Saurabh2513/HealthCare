import 'package:flutter/material.dart';

/// It uses a [RichText] widget to display a [text] with a [style] and a
/// [TextStyle.fontWeight] of [FontWeight.bold] for the bold texts
/// The bold texts are the ones between two asterisks, for example:
/// "This is a **bold text**"
class BoldableText extends StatelessWidget {
  final String text;
  final TextStyle? style;
  final TextAlign? textAlign;
  final bool isSelectable;

  const BoldableText(this.text,
      {super.key, this.isSelectable = false, this.style, this.textAlign});

  @override
  Widget build(BuildContext context) {
    final List<TextSpan> children = [];
    final List<String> split = text.split('**');
    for (int i = 0; i < split.length; i++) {
      if (i % 2 == 0) {
        children.add(TextSpan(text: split[i], style: style));
      } else {
        children.add(TextSpan(
            text: split[i],
            style: (style ?? const TextStyle())
                .copyWith(fontWeight: FontWeight.bold)));
      }
    }
    if (isSelectable) {
      return SelectableText.rich(
        TextSpan(children: children),
        style: style,
        textAlign: textAlign,
      );
    }
    return Text.rich(
      TextSpan(children: children),
      style: style,
      textAlign: textAlign,
    );
  }
}