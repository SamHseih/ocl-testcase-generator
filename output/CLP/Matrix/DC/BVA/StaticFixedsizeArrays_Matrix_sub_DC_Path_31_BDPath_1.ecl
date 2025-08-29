:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_sub_DC_Path_31_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_49752459),
(Dim1 = Var_49752459),
nth1(2,Arg_dimensionSizes,Var_411506101),
(Dim2 = Var_411506101),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_514455215),nth1(Idx0,List_514455215,Var_514455215),(It = Var_514455215),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_1780034814),nth1(Idx1,List_1780034814,Var_1780034814),(It2 = Var_1780034814),
getArrayElement(Arg_datas,[It,It2],Var_1360657223_1),getArrayElement(Self_datas,[It,It2],Var_1905485420_1),getArrayElement(Result_datas,[It,It2],Var_551479935_1),(Var_551479935_1 #= (Var_1905485420_1-Var_1360657223_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_1780034814),nth1(Idx1_1,List_1780034814,Var_1780034814_1),(It2_1 = Var_1780034814_1),
getArrayElement(Arg_datas,[It,It2_1],Var_1360657223_2),getArrayElement(Self_datas,[It,It2_1],Var_1905485420_2),getArrayElement(Result_datas,[It,It2_1],Var_551479935_2),(Var_551479935_2 #= (Var_1905485420_2-Var_1360657223_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> Dim2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_514455215),nth1(Idx0_1,List_514455215,Var_514455215_1),(It_1 = Var_514455215_1),
(Acc2_1 = true),
(Idx1_3 #= 1),
(Idx1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_1780034814),nth1(Idx1_3,List_1780034814,Var_1780034814_2),(It2_2 = Var_1780034814_2),
getArrayElement(Arg_datas,[It_1,It2_2],Var_1360657223_3),getArrayElement(Self_datas,[It_1,It2_2],Var_1905485420_3),getArrayElement(Result_datas,[It_1,It2_2],Var_551479935_3),(Var_551479935_3 #= (Var_1905485420_3-Var_1360657223_3)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_1780034814),nth1(Idx1_4,List_1780034814,Var_1780034814_3),(It2_3 = Var_1780034814_3),
getArrayElement(Arg_datas,[It_1,It2_3],Var_1360657223_4),getArrayElement(Self_datas,[It_1,It2_3],Var_1905485420_4),getArrayElement(Result_datas,[It_1,It2_3],Var_551479935_4),(Var_551479935_4 #= (Var_1905485420_4-Var_1360657223_4)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> Dim2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
