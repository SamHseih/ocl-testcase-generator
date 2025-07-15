:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_sub_DC_Path_31(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_178049969),
(Dim1 = Var_178049969),
nth1(2,Arg_dimensionSizes,Var_333683827),
(Dim2 = Var_333683827),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1691185247),nth1(Idx0,List_1691185247,Var_1691185247),(It = Var_1691185247),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_153245266),nth1(Idx1,List_153245266,Var_153245266),(It2 = Var_153245266),
getArrayElement(Arg_datas,[It,It2],Var_1699679644_1),getArrayElement(Self_datas,[It,It2],Var_1782580546_1),getArrayElement(Result_datas,[It,It2],Var_1702940637_1),(Var_1702940637_1 #= (Var_1782580546_1-Var_1699679644_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_153245266),nth1(Idx1_1,List_153245266,Var_153245266_1),(It2_1 = Var_153245266_1),
getArrayElement(Arg_datas,[It,It2_1],Var_1699679644_2),getArrayElement(Self_datas,[It,It2_1],Var_1782580546_2),getArrayElement(Result_datas,[It,It2_1],Var_1702940637_2),(Var_1702940637_2 #= (Var_1782580546_2-Var_1699679644_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> Dim2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1691185247),nth1(Idx0_1,List_1691185247,Var_1691185247_1),(It_1 = Var_1691185247_1),
(Acc2_1 = true),
(Idx1_3 #= 1),
(Idx1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_153245266),nth1(Idx1_3,List_153245266,Var_153245266_2),(It2_2 = Var_153245266_2),
getArrayElement(Arg_datas,[It_1,It2_2],Var_1699679644_3),getArrayElement(Self_datas,[It_1,It2_2],Var_1782580546_3),getArrayElement(Result_datas,[It_1,It2_2],Var_1702940637_3),(Var_1702940637_3 #= (Var_1782580546_3-Var_1699679644_3)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_153245266),nth1(Idx1_4,List_153245266,Var_153245266_3),(It2_3 = Var_153245266_3),
getArrayElement(Arg_datas,[It_1,It2_3],Var_1699679644_4),getArrayElement(Self_datas,[It_1,It2_3],Var_1782580546_4),getArrayElement(Result_datas,[It_1,It2_3],Var_1702940637_4),(Var_1702940637_4 #= (Var_1782580546_4-Var_1699679644_4)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> Dim2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
