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
**Alexey Rakov** - type checker and features implementation

## Installation

### Requirements
To build FAF_L you need Java with version 11 (jdk11).

### Build
To install FAF_L you need to download project to your machine.
After that go to folder with project and execute such instruction:
```
./gradlew run --args="PATH TO YOUR PROGRAM ON FAF_L"
```
Where "PATH TO YOU PROGRAM ON FAF_L" is a path where you FAF_L program is located.

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
if Expr1 then Expr2 else Expr3; //Declaring if statement
```
Signatures:

>If statement has signature `if Bool then Type1 else Type1`

Example:
```common-lisp
setq x:Int 3;
setq y:Int 5;
if isgreater(x, y) then setq x:Int y else setq y:Int x;
```

### Functions and lambda-functions
How to work with functions in FAF_L
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
Functions to work with structures
```common-lisp
struct StructType (FieldName1:Type, ...); //Defining new structure StructType
StructType(Arg1, ...); //Creating new structure
setq StructName:<StructType> StructType(Arg1, ...); //Setting structure StructType with name StructName
(StructName).FieldName; //Getting field from structure
```
Example:
```common-lisp
struct IntDoubleStruct (intField:Int, doubleField:Double);
setq s:<IntDoubleStruct> IntDoubleStruct(1, 0.1);
setq x:Int (s).intField;
setq y:Double (s).doubleField;
```

### Arrays
How to work with arrays in FAF_L. Arrays in FAF_L are homogenius.
```common-lisp
Type[Expr1]{Elem1, ..., ElemN}; //Creating array
first(Expr); //Getting the first element in array
last(Expr); //Getting last element in array
array-get(Expr1, Expr2); //Getting element from array by index
array-set(Expr1, Expr2, Expr3); //Setting element from array by index
array-length(Expr1); //Getting length of an array
```
Signatures:
>- Creating array has signature `Type[Int]{Type, ... Type}; -> [Type]`
>- `first` has signature `first([Type]) -> Type`
>- `last` has signature `last([Type]) -> Type`
>- `array-get` has signature `array-get([Type], Int) -> Type`
>- `array-set` has signature `array-get([Type], Int, Type) -> Type`
>- `array-length` has signature `array-length([Type]) -> Int`

Example:
```common-lisp
setq arrayWithInt:[Int] Int[3]{0, 1, 2};
setq a:Int array-get(arrayWithInt, 0);
setq a:Int plus(a, 1);
array-set(arrayWithInt, 0, a);
array-set(arrayWithInt, 1, array-length(arrayWithInt));
```

### Tuples
Functions to work with tuples in FAF_L
```common-lisp
tuple(Expr1, Expr2 ...); //Creating a tuple
tuple-get(Expr, Expr); //Getting element from tuple
tuple-length(Expr); //Getting length of a tuple
```

Signatures:
>- Creating tuple has signature `tuple(Type1, Type1 ...) -> Tuple`
>- Getting element has signature `tuple-get(Tuple, Int) -> Int`
>- Getting length has signature `tuple-length(Tuple) -> Int`

Example:
```common-lisp
setq tuple1:Tuple tuple(0, 1, 2);
setq f:Int tuple-get(tuple1, 0);
setq len:Int tuple-length(tuple1);
```

### Dictionaries
Functions with dictionaries in FAF_L.

```common-lisp
dict DictName <KeyType, ValueType> ((Key1.Value1), (Key2.Value2) ...); //Creating dictionary
dict-set (Dict, (Key.Value)); //Setting dictionary value
dict-get(Dict, Key); //Get value by key in dictionary
dict-remove(Dict, Key); //Remove element in Dict by Key
dict-keys(Dict); //Get keys from Dict
dict-values(Dict); //Get elements from Dict
dict-length(Dict); //Get length of Dict
```

Signatures:

>- Creating dict has signature `dict DictName <Type1, Type2> ((Type1.Type2), (Type1.Type2) ...) -> Dict`
>- Set has signature `dict-set(Dict, (KeyType, ValueType)) -> ValueType`
>- Get has signature `dict-get(Dict, KeyType) -> ValueType`
>- Removing has signature `dict-remove(Dict, Key) -> ValueType`
>- Keys function has signature `dict-keys(Dict) -> [KeyType]`
>- Values function has signature `dict-values(Dict) -> [ValueType]`
>- Length function has signature `dict-length(Dict) -> Int`

Example:

```common-lisp
dict myDict<Int, Double> ((0 . 0.1), (1 . 5.1));
setq x:Double dict-get(myDict, 1);
dict-remove(myDict, 0);
setq y:dict-length(myDict);
```

### Raise and catch exceptions
```common-lisp
raise Exception(Message); //Raising exception
try Expr catch(Expr); //Try-catch statement
```
Signatures:
>- Raising has signature `raise Exception(String)`
>- Try-catch statement has signature `try Expr1 catch(Expr2)`. 
> `Expr2` is an expression that will execute if `Expr1` end with exception

### IO syntax
```common-lisp
readline //Reading line from console
printline String //Printing String to console
```

Signatures:

>- Reading has signature `readline -> String`
>- Printing has signature `pringline String -> String`

### Comments
Comments in FAF_L
```java
//One line comment
/*
Multi line comment
*/
```

### Syntax of types
Types description from FAF_L
```common-lisp
[Type] //array
<StructName> //struct
(ArgTypes) -> ReturnType //func type
```

## Build-in functions
### Arithmetic functions
```common-lisp
plus(Expr1, Expr2, ...); //Plus function
minus(Expr1, Expr2, ...); //Minus function
mul(Expr1, Expr2, ...); //Multiply function
div(Expr1, Expr2, ...); //Division function
```
Signatures:
>Functions are `(Int, Int, ...) -> Int` or `(Double, Double, ...) -> Double` only

### Boolean functions
```common-lisp
equals(Expr1, Expr2); //Return are Expr's equals
isgreater(Expr1, Expr2); //Return is Expr1 greater than Expr2
isless(Expr1, Expr2); //Return is Expr1 less than Expr2
and(Expr1, Expr2); //Bool operation and
or(Expr2, Expr2); //Bool operation or
```
Signatures:
>Function `equals` has signature `(SimpleType, SimpleType) -> Bool`\
>Functions `isgreater` and `isless` have signatures `(Int, Int) -> Bool` or `(Double, Doulbe) -> Bool`\
>Functions `and` and `or` have signature `(Bool, Bool) -> Bool`

### Casting functions
```common-lisp
double(Expr); //Cast to double
int(Expr); //Cast to int
string(Expr); //Cast to string
```
Signatures:
>- Function `double` has signature `(BaseType) -> Double`
>- Function `int` has signature `(BaseType) -> Int`
>- Function `string` has signature `(BaseType) -> String`

## Bad examples that could be useful

Arrays are homogenius! You cannot store elements with different types.
```common-lisp
//BAD CODE
setq arrayWithInt:[Int] Int[3]{0, 1, 2};
array-set(arrayWithInt, 0, 0.1); //ERROR!
```

You cannot set variables from structure to another. If you need you can create new structure.
```common-lisp
//BAD CODE
struct IntDoubleStruct (intField:Int, doubleField:Double);
setq s:<IntDoubleStruct> IntDoubleStruct(1, 0.1);
setq (s).intField:Int 3; //ERROR!
```

FAF_L was implemented with Java. 
All java runtime arithmetic errors will be bad in FAF_L too.
```common-lisp
//BAD CODE
setq x:Int 5;
setq y:Int 0;
setq z:Int div(x, y); //ERROR!
```

FAF_L is strongly typed language. You cannot operate with different type without casting.
```common-lisp
//BAD CODE
setq x:Int 5;
setq y:Double 1;
setq z:Int div(x, y); //ERROR!
```

## Demo programm
>In progress