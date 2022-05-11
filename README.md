# FAF_L
## Description
FAF-L - is a functional interpreting static-typed language.
## Features
|Features       | Cost
|---            | ---
|Interpreter | mandatory
|Type checker   | mandatory
|Base types(int, double, bool, string)     | mandatory
|User-defined terms and types(structs) | mandatory
|Standard library(simple arithmetic, logic) | mandatory
|First-class functions | mandatory
|Nested functions | mandatory
|Simple inference(auto types) | mandatory
|Tuples | 3
|Exceptions | 3
|Built-in homogenious arrays | 4
|Built-in homogenious dicts | 4
## Team members
**Emil Khabibullin** - features implementation and managing the developing process
**Roman Mukhtarov** - interpreter developing and features implementation
**Ruslan Nurutdinov** - testing and features implementation
**Gleb Smetanin** - features and demo program implementation
**Alexey Rakov** - interpreter developing and features implementation
## Syntax Reference
> Syntax almost implemened. **Dictionaries**, **auto** types and **tuples** are in progress

Set global variable or struct:
```common-lisp
setq Name:Type Expr;
setq Name:StructType (Arg1, ...);
```
Define new function or lambda function:
```common-lisp
define Name (Arg1:Type, ...) -> ReturnType {FuncBody};
lambda (Arg1:Type, ...) -> ReturnType {FuncBody};
```
If construction:
```common-lisp
if Expr then Expr else Expr;
```
Define new struct and struct constructor:
```common-lisp
struct StructName (FieldName1:Type, ...);
StructName(Arg1, ...);
```
Get field of structure:
```common-lisp
StructName.FieldName;
```
Array construction:
```common-lisp
Type[N]{Elem1, ..., ElemN};
```
Raise and catch exceptions(for now only simple exception with some message):
```common-lisp
raise Exception(Message);
try Expr catch(Expr);
```
IO syntax:
```common-lisp
readline
printline String
```
Comments:
```java
//One line comment
/*
Multi line comment
*/
```
Syntax of types:
```common-lisp
[Type] //array
<StructName> //struct
(ArgTypes) -> ReturnType //func type
```
## Examples
### Valid programms
```common-lisp
setq x:Int plus(1, 2);
setq y:Int minus(2, 5);
plus(y,plus(minus(x, 3), 2));
define myFunc(x:Int, y:String)->String {if greater(x, 5) then "x greater 5" else "x less or equal 5"};
```
### Invalid programms
```common-lisp
setq x:String plus(1, 2); //TypeException: type of x String, type of literal Int
//TypeException: return type of function myFunc is Bool, but String returned
define myFunc(x:Int)->Bool
{
    if greater(x, 5) then "x greater 5" else "x less or equal 5"
}; 

```
## Demo programm
>In progress
## Installation
>In progress