:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_add_DCC_Path_6_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1928931046),
(Dim1 = Var_1928931046),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1998767043),nth1(Index0,List_1998767043,Var_1998767043),(It = Var_1998767043),
getArrayElement(Arg_datas,[It],Var_787738361_1),getArrayElement(Self_datas,[It],Var_607932305_1),getArrayElement(Result_datas,[It],Var_168366_1),(Var_168366_1 #= (Var_607932305_1+Var_787738361_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1998767043),nth1(Index0_1,List_1998767043,Var_1998767043_1),(It_1 = Var_1998767043_1),
getArrayElement(Arg_datas,[It_1],Var_787738361_2),getArrayElement(Self_datas,[It_1],Var_607932305_2),getArrayElement(Result_datas,[It_1],Var_168366_2),(Var_168366_2 #= (Var_607932305_2+Var_787738361_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1998767043),nth1(Index0_2,List_1998767043,Var_1998767043_2),(It_2 = Var_1998767043_2),
getArrayElement(Arg_datas,[It_2],Var_787738361_3),getArrayElement(Self_datas,[It_2],Var_607932305_3),getArrayElement(Result_datas,[It_2],Var_168366_3),(Var_168366_3 #= (Var_607932305_3+Var_787738361_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1998767043),nth1(Index0_3,List_1998767043,Var_1998767043_3),(It_3 = Var_1998767043_3),
getArrayElement(Arg_datas,[It_3],Var_787738361_4),getArrayElement(Self_datas,[It_3],Var_607932305_4),getArrayElement(Result_datas,[It_3],Var_168366_4),(Var_168366_4 #= (Var_607932305_4+Var_787738361_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1998767043),nth1(Index0_4,List_1998767043,Var_1998767043_4),(It_4 = Var_1998767043_4),
getArrayElement(Arg_datas,[It_4],Var_787738361_5),getArrayElement(Self_datas,[It_4],Var_607932305_5),getArrayElement(Result_datas,[It_4],Var_168366_5),(Var_168366_5 #= (Var_607932305_5+Var_787738361_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
