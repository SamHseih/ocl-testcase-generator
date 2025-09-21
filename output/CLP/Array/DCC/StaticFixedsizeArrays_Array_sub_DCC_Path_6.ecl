:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_sub_DCC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1637290981),
(Dim1 = Var_1637290981),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1888442711),nth1(Index0,List_1888442711,Var_1888442711),(It = Var_1888442711),
getArrayElement(Arg_data,[It],Var_1754894440_1),getArrayElement(Self_data,[It],Var_1998767043_1),getArrayElement(Result_data,[It],Var_787738361_1),(Var_787738361_1 #= (Var_1998767043_1-Var_1754894440_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1888442711),nth1(Index0_1,List_1888442711,Var_1888442711_1),(It_1 = Var_1888442711_1),
getArrayElement(Arg_data,[It_1],Var_1754894440_2),getArrayElement(Self_data,[It_1],Var_1998767043_2),getArrayElement(Result_data,[It_1],Var_787738361_2),(Var_787738361_2 #= (Var_1998767043_2-Var_1754894440_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1888442711),nth1(Index0_2,List_1888442711,Var_1888442711_2),(It_2 = Var_1888442711_2),
getArrayElement(Arg_data,[It_2],Var_1754894440_3),getArrayElement(Self_data,[It_2],Var_1998767043_3),getArrayElement(Result_data,[It_2],Var_787738361_3),(Var_787738361_3 #= (Var_1998767043_3-Var_1754894440_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1888442711),nth1(Index0_3,List_1888442711,Var_1888442711_3),(It_3 = Var_1888442711_3),
getArrayElement(Arg_data,[It_3],Var_1754894440_4),getArrayElement(Self_data,[It_3],Var_1998767043_4),getArrayElement(Result_data,[It_3],Var_787738361_4),(Var_787738361_4 #= (Var_1998767043_4-Var_1754894440_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1888442711),nth1(Index0_4,List_1888442711,Var_1888442711_4),(It_4 = Var_1888442711_4),
getArrayElement(Arg_data,[It_4],Var_1754894440_5),getArrayElement(Self_data,[It_4],Var_1998767043_5),getArrayElement(Result_data,[It_4],Var_787738361_5),(Var_787738361_5 #= (Var_1998767043_5-Var_1754894440_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
