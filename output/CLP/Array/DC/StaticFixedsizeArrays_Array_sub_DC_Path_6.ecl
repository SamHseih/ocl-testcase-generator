:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_sub_DC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_306115458),
(Dim1 = Var_306115458),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_230643635),nth1(Idx0,List_230643635,Var_230643635),(It = Var_230643635),
getArrayElement(Arg_datas,[It],Var_944427387_1),getArrayElement(Self_datas,[It],Var_1636182655_1),getArrayElement(Result_datas,[It],Var_71399214_1),(Var_71399214_1 #= (Var_1636182655_1-Var_944427387_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_230643635),nth1(Idx0_1,List_230643635,Var_230643635_1),(It_1 = Var_230643635_1),
getArrayElement(Arg_datas,[It_1],Var_944427387_2),getArrayElement(Self_datas,[It_1],Var_1636182655_2),getArrayElement(Result_datas,[It_1],Var_71399214_2),(Var_71399214_2 #= (Var_1636182655_2-Var_944427387_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_230643635),nth1(Idx0_2,List_230643635,Var_230643635_2),(It_2 = Var_230643635_2),
getArrayElement(Arg_datas,[It_2],Var_944427387_3),getArrayElement(Self_datas,[It_2],Var_1636182655_3),getArrayElement(Result_datas,[It_2],Var_71399214_3),(Var_71399214_3 #= (Var_1636182655_3-Var_944427387_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_230643635),nth1(Idx0_3,List_230643635,Var_230643635_3),(It_3 = Var_230643635_3),
getArrayElement(Arg_datas,[It_3],Var_944427387_4),getArrayElement(Self_datas,[It_3],Var_1636182655_4),getArrayElement(Result_datas,[It_3],Var_71399214_4),(Var_71399214_4 #= (Var_1636182655_4-Var_944427387_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_230643635),nth1(Idx0_4,List_230643635,Var_230643635_4),(It_4 = Var_230643635_4),
getArrayElement(Arg_datas,[It_4],Var_944427387_5),getArrayElement(Self_datas,[It_4],Var_1636182655_5),getArrayElement(Result_datas,[It_4],Var_71399214_5),(Var_71399214_5 #= (Var_1636182655_5-Var_944427387_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
