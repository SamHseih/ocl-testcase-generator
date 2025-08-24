:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_sub_DCC_Path_31_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_384587033),
(Dim1 = Var_384587033),
nth1(2,Arg_dimensionSizes,Var_49752459),
(Dim2 = Var_49752459),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_411506101),nth1(Index0,List_411506101,Var_411506101),(It = Var_411506101),
(Acc2 = true),
(Index1 #= 1),
(Index1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_514455215),nth1(Index1,List_514455215,Var_514455215),(It2 = Var_514455215),
getArrayElement(Arg_datas,[It,It2],Var_1780034814_1),getArrayElement(Self_datas,[It,It2],Var_1360657223_1),getArrayElement(Result_datas,[It,It2],Var_1905485420_1),(Var_1905485420_1 #= (Var_1360657223_1-Var_1780034814_1)),
(Index1_1 #= (Index1+1)),
(Index1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_514455215),nth1(Index1_1,List_514455215,Var_514455215_1),(It2_1 = Var_514455215_1),
getArrayElement(Arg_datas,[It,It2_1],Var_1780034814_2),getArrayElement(Self_datas,[It,It2_1],Var_1360657223_2),getArrayElement(Result_datas,[It,It2_1],Var_1905485420_2),(Var_1905485420_2 #= (Var_1360657223_2-Var_1780034814_2)),
(Index1_2 #= (Index1_1+1)),
(Index1_2 #> Dim2 - 1+ 1),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_411506101),nth1(Index0_1,List_411506101,Var_411506101_1),(It_1 = Var_411506101_1),
(Acc2_1 = true),
(Index1_3 #= 1),
(Index1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_514455215),nth1(Index1_3,List_514455215,Var_514455215_2),(It2_2 = Var_514455215_2),
getArrayElement(Arg_datas,[It_1,It2_2],Var_1780034814_3),getArrayElement(Self_datas,[It_1,It2_2],Var_1360657223_3),getArrayElement(Result_datas,[It_1,It2_2],Var_1905485420_3),(Var_1905485420_3 #= (Var_1360657223_3-Var_1780034814_3)),
(Index1_4 #= (Index1_3+1)),
(Index1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_514455215),nth1(Index1_4,List_514455215,Var_514455215_3),(It2_3 = Var_514455215_3),
getArrayElement(Arg_datas,[It_1,It2_3],Var_1780034814_4),getArrayElement(Self_datas,[It_1,It2_3],Var_1360657223_4),getArrayElement(Result_datas,[It_1,It2_3],Var_1905485420_4),(Var_1905485420_4 #= (Var_1360657223_4-Var_1780034814_4)),
(Index1_5 #= (Index1_4+1)),
(Index1_5 #> Dim2 - 1+ 1),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
