:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

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
nth1(1,Arg_dimensionSizes,Var_1738674023),
(Dim1 = Var_1738674023),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1472682156),nth1(Idx0,List_1472682156,Var_1472682156),(It = Var_1472682156),
getArrayElement(Arg_datas,[It],Var_178049969_1),getArrayElement(Self_datas,[It],Var_333683827_1),getArrayElement(Result_datas,[It],Var_1691185247_1),(Var_1691185247_1 #= (Var_333683827_1-Var_178049969_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1472682156),nth1(Idx0_1,List_1472682156,Var_1472682156_1),(It_1 = Var_1472682156_1),
getArrayElement(Arg_datas,[It_1],Var_178049969_2),getArrayElement(Self_datas,[It_1],Var_333683827_2),getArrayElement(Result_datas,[It_1],Var_1691185247_2),(Var_1691185247_2 #= (Var_333683827_2-Var_178049969_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1472682156),nth1(Idx0_2,List_1472682156,Var_1472682156_2),(It_2 = Var_1472682156_2),
getArrayElement(Arg_datas,[It_2],Var_178049969_3),getArrayElement(Self_datas,[It_2],Var_333683827_3),getArrayElement(Result_datas,[It_2],Var_1691185247_3),(Var_1691185247_3 #= (Var_333683827_3-Var_178049969_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1472682156),nth1(Idx0_3,List_1472682156,Var_1472682156_3),(It_3 = Var_1472682156_3),
getArrayElement(Arg_datas,[It_3],Var_178049969_4),getArrayElement(Self_datas,[It_3],Var_333683827_4),getArrayElement(Result_datas,[It_3],Var_1691185247_4),(Var_1691185247_4 #= (Var_333683827_4-Var_178049969_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1472682156),nth1(Idx0_4,List_1472682156,Var_1472682156_4),(It_4 = Var_1472682156_4),
getArrayElement(Arg_datas,[It_4],Var_178049969_5),getArrayElement(Self_datas,[It_4],Var_333683827_5),getArrayElement(Result_datas,[It_4],Var_1691185247_5),(Var_1691185247_5 #= (Var_333683827_5-Var_178049969_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
