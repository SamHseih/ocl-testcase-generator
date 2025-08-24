:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_sub_DCC_Path_31(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1028780142),
(Dim1 = Var_1028780142),
nth1(2,Arg_dimensionSizes,Var_2128029086),
(Dim2 = Var_2128029086),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_686466458),nth1(Index0,List_686466458,Var_686466458),(It = Var_686466458),
(Acc2 = true),
(Index1 #= 1),
(Index1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_875016237),nth1(Index1,List_875016237,Var_875016237),(It2 = Var_875016237),
getArrayElement(Arg_datas,[It,It2],Var_105374791_1),getArrayElement(Self_datas,[It,It2],Var_1107024580_1),getArrayElement(Result_datas,[It,It2],Var_1010856212_1),(Var_1010856212_1 #= (Var_1107024580_1-Var_105374791_1)),
(Index1_1 #= (Index1+1)),
(Index1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_875016237),nth1(Index1_1,List_875016237,Var_875016237_1),(It2_1 = Var_875016237_1),
getArrayElement(Arg_datas,[It,It2_1],Var_105374791_2),getArrayElement(Self_datas,[It,It2_1],Var_1107024580_2),getArrayElement(Result_datas,[It,It2_1],Var_1010856212_2),(Var_1010856212_2 #= (Var_1107024580_2-Var_105374791_2)),
(Index1_2 #= (Index1_1+1)),
(Index1_2 #> Dim2 - 1+ 1),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_686466458),nth1(Index0_1,List_686466458,Var_686466458_1),(It_1 = Var_686466458_1),
(Acc2_1 = true),
(Index1_3 #= 1),
(Index1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_875016237),nth1(Index1_3,List_875016237,Var_875016237_2),(It2_2 = Var_875016237_2),
getArrayElement(Arg_datas,[It_1,It2_2],Var_105374791_3),getArrayElement(Self_datas,[It_1,It2_2],Var_1107024580_3),getArrayElement(Result_datas,[It_1,It2_2],Var_1010856212_3),(Var_1010856212_3 #= (Var_1107024580_3-Var_105374791_3)),
(Index1_4 #= (Index1_3+1)),
(Index1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_875016237),nth1(Index1_4,List_875016237,Var_875016237_3),(It2_3 = Var_875016237_3),
getArrayElement(Arg_datas,[It_1,It2_3],Var_105374791_4),getArrayElement(Self_datas,[It_1,It2_3],Var_1107024580_4),getArrayElement(Result_datas,[It_1,It2_3],Var_1010856212_4),(Var_1010856212_4 #= (Var_1107024580_4-Var_105374791_4)),
(Index1_5 #= (Index1_4+1)),
(Index1_5 #> Dim2 - 1+ 1),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
