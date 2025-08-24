:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_div_DC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1390869998),
(Dim1 = Var_1390869998),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1820383114),nth1(Idx0,List_1820383114,Var_1820383114),(It = Var_1820383114),
getArrayElement(Arg_datas,[It],Var_1645547422_1),getArrayElement(Self_datas,[It],Var_440737101_1),getArrayElement(Result_datas,[It],Var_2141817446_1),(Var_2141817446_1 #= (Var_440737101_1/Var_1645547422_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1820383114),nth1(Idx0_1,List_1820383114,Var_1820383114_1),(It_1 = Var_1820383114_1),
getArrayElement(Arg_datas,[It_1],Var_1645547422_2),getArrayElement(Self_datas,[It_1],Var_440737101_2),getArrayElement(Result_datas,[It_1],Var_2141817446_2),(Var_2141817446_2 #= (Var_440737101_2/Var_1645547422_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1820383114),nth1(Idx0_2,List_1820383114,Var_1820383114_2),(It_2 = Var_1820383114_2),
getArrayElement(Arg_datas,[It_2],Var_1645547422_3),getArrayElement(Self_datas,[It_2],Var_440737101_3),getArrayElement(Result_datas,[It_2],Var_2141817446_3),(Var_2141817446_3 #= (Var_440737101_3/Var_1645547422_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1820383114),nth1(Idx0_3,List_1820383114,Var_1820383114_3),(It_3 = Var_1820383114_3),
getArrayElement(Arg_datas,[It_3],Var_1645547422_4),getArrayElement(Self_datas,[It_3],Var_440737101_4),getArrayElement(Result_datas,[It_3],Var_2141817446_4),(Var_2141817446_4 #= (Var_440737101_4/Var_1645547422_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1820383114),nth1(Idx0_4,List_1820383114,Var_1820383114_4),(It_4 = Var_1820383114_4),
getArrayElement(Arg_datas,[It_4],Var_1645547422_5),getArrayElement(Self_datas,[It_4],Var_440737101_5),getArrayElement(Result_datas,[It_4],Var_2141817446_5),(Var_2141817446_5 #= (Var_440737101_5/Var_1645547422_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
