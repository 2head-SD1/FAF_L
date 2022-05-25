# FAF_L
## Description
FAF-L - is a functional interpreting static-typed language.
## Features
| Features                                   | Cost      |
|--------------------------------------------|-----------|
| Interpreter                                | mandatory |
| Type checker                               | mandatory |
| Base types(int, double, bool, string)      | mandatory |
| User-defined terms and types(structs)      | mandatory |
| Standard library(simple arithmetic, logic) | mandatory |
| First-class functions                      | mandatory |
| Nested functions                           | mandatory |
| Simple inference(auto types)               | mandatory |
| Tuples                                     | 3         |
| Exceptions                                 | 3         |
| Built-in homogenious arrays                | 4         |
| Built-in homogenious dicts                 | 4         |

## Team members
**Emil Khabibullin** - features implementation and managing the developing process\
**Roman Mukhtarov** - interpreter developing and features implementation\
**Ruslan Nurutdinov** - testing and features implementation\
**Gleb Smetanin** - features and demo program implementation\
**Alexey Rakov** - interpreter developing and features implementation\
## Syntax Reference

### Set variable
```common-lisp
setq Name:Type Expr; //Creating variable
```
Example:
```common-lisp
setq x:Int 5;
setq y:Double plus(1.0, 3.0);
```
Basic types are ***Int***, ***Double***, ***Bool*** and ***String***. For user types see [Structures](#structures)

### If construction
```common-lisp
if Expr then Expr else Expr;
```
Example:
```common-lisp
setq x:Int 3;
setq y:Int 5;
if isgreater(x, y) then setq x:Int y else setq y:Int x;
```

### Functions and lambda-functions
```common-lisp
define Func (Arg1:Type, ...) -> ReturnType {Expr}; //Creating function with name Func
lambda (Arg1:Type, ...) -> ReturnType {Expr}; //Creating lambda-function
call Func (Arg1, Arg2 ...); //Calling function with name Func
```
Example:
```common-lisp
define sumOfSquares (x:Int, y:Int) -> Int{plus(mul(x, x), mul(y, y))};
define applyFunc(x:(Int)->Int, y:Int) -> Int{call x(y)};
call applyFunc(lambda (x:Int) -> Int{mul(x, x)}, 3);
```

### Structures
```common-lisp
struct StructType (FieldName1:Type, ...); //Defining new structure StructType
StructType(Arg1, ...); //Creating new structure
setq StructName:StructType (Arg1, ...); //Setting structure StructType with name StructName
StructName.FieldName; //Getting field from structure
```
Example:
```common-lisp
struct IntDoubleStruct (intField:Int, doubleField:Double);
setq s:<IntDoubleStruct> (1, 0.1);
setq x:Int s.intField;
setq y:Double s.doubleField;
```

### Array construction
```common-lisp
Type[N]{Elem1, ..., ElemN};
```

### Raise and catch exceptions
```common-lisp
raise Exception(Message);
try Expr catch(Expr);
```

### IO syntax
```common-lisp
readline
printline String
```

### Comments
```java
//One line comment
/*
Multi line comment
*/
```

### Syntax of types
```common-lisp
[Type] //array
<StructName> //struct
(ArgTypes) -> ReturnType //func type
```

## Build-in functions
### Arithmetic
```common-lisp
plus(Expr1, Expr2, ...); //Plus function
minus(Expr1, Expr2, ...); //Minus function
mul(Expr1, Expr2, ...); //Multiply function
div(Expr1, Expr2, ...); //Division function
```
>Functions are `(Int, Int, ...) -> Int` or `(Double, Double, ...) -> Double` only

### Boolean
```common-lisp
equals(Expr, Epxr); //(Type, Type) -> Type
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