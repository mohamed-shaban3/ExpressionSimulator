# Expression Simulator 🧮

مشروع مادة الـ Data Structures - بيقوم بتحليل وحل المعادلات الرياضية المعقدة من خلال ملفات Input/Output.

## 🚀 التقنيات والمفاهيم المستخدمة:
* **Custom Data Structures:** قمت ببناء (Stack, Queue, HashTable, Expression Tree) من الصفر بدون استخدام المكتبات الجاهزة.
* **Shunting-yard Algorithm:** لتحويل المعادلات من Infix إلى Postfix.
* **Tokenizer Logic:** للتعامل مع الأرقام العشرية (Decimal Points) والإشارات السالبة.
* **File Handling:** قراءة البيانات ومعالجتها وتخزين النتائج في ملفات نصية.

## 📂 هيكلة المشروع:
- `MyStack.java` & `MyQueue.java`: الأساس البرمجي للمشروع.
- `Tokenizer.java`: المسؤول عن تقطيع المعادلة لأجزاء مفهومة.
- `Evaluator.java`: المسؤول عن حساب النتيجة النهائية.
