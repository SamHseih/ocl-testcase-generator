:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DCC_Path_10(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_2143431083),
(Var_2143431083 #> 0),
length(Arg_dimensionSizes,Var_1115201599),
length(Self_dimensionSizes,Var_790067787),
(Var_790067787 #= Var_1115201599),
nth1(1,Arg_dimensionSizes,Var_102617125),
nth1(1,Self_dimensionSizes,Var_343856911),
(Var_343856911 #= Var_102617125),
length(Result_dimensionSizes,Var_815674463),
length(Self_dimensionSizes,Var_2051853139),
(Var_2051853139 #= Var_815674463),
nth1(1,Result_dimensionSizes,Var_416153648),
nth1(1,Self_dimensionSizes,Var_1453774246),
(Var_1453774246 #= Var_416153648),
nth1(1,Arg_dimensionSizes,Var_1169794610),
(Dim1 = Var_1169794610),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0,List_634540230,Var_634540230),(It = Var_634540230),
getArrayElement(Arg_data,[It],Var_511717113_1),getArrayElement(Self_data,[It],Var_2130772866_1),getArrayElement(Result_data,[It],Var_2129221032_1),(Var_2129221032_1 #= (Var_2130772866_1+Var_511717113_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0_1,List_634540230,Var_634540230_1),(It_1 = Var_634540230_1),
getArrayElement(Arg_data,[It_1],Var_511717113_2),getArrayElement(Self_data,[It_1],Var_2130772866_2),getArrayElement(Result_data,[It_1],Var_2129221032_2),(Var_2129221032_2 #= (Var_2130772866_2+Var_511717113_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0_2,List_634540230,Var_634540230_2),(It_2 = Var_634540230_2),
getArrayElement(Arg_data,[It_2],Var_511717113_3),getArrayElement(Self_data,[It_2],Var_2130772866_3),getArrayElement(Result_data,[It_2],Var_2129221032_3),(Var_2129221032_3 #= (Var_2130772866_3+Var_511717113_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0_3,List_634540230,Var_634540230_3),(It_3 = Var_634540230_3),
getArrayElement(Arg_data,[It_3],Var_511717113_4),getArrayElement(Self_data,[It_3],Var_2130772866_4),getArrayElement(Result_data,[It_3],Var_2129221032_4),(Var_2129221032_4 #= (Var_2130772866_4+Var_511717113_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0_4,List_634540230,Var_634540230_4),(It_4 = Var_634540230_4),
getArrayElement(Arg_data,[It_4],Var_511717113_5),getArrayElement(Self_data,[It_4],Var_2130772866_5),getArrayElement(Result_data,[It_4],Var_2129221032_5),(Var_2129221032_5 #= (Var_2130772866_5+Var_511717113_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0_5,List_634540230,Var_634540230_5),(It_5 = Var_634540230_5),
getArrayElement(Arg_data,[It_5],Var_511717113_6),getArrayElement(Self_data,[It_5],Var_2130772866_6),getArrayElement(Result_data,[It_5],Var_2129221032_6),(Var_2129221032_6 #= (Var_2130772866_6+Var_511717113_6)),
(Index0_6 #= (Index0_5+1)),
(Index0_6 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_634540230),nth1(Index0_6,List_634540230,Var_634540230_6),(It_6 = Var_634540230_6),
getArrayElement(Arg_data,[It_6],Var_511717113_7),getArrayElement(Self_data,[It_6],Var_2130772866_7),getArrayElement(Result_data,[It_6],Var_2129221032_7),(Var_2129221032_7 #= (Var_2130772866_7+Var_511717113_7)),
(Index0_7 #= (Index0_6+1)),
(Index0_7 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
