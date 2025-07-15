:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_add_DC_Path_31(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_datas,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_datas,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(Arg_datas,Arg_dimensionSizes),
decl_Array(Result_datas,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1629687658),
(Dim1 = Var_1629687658),
nth1(2,Arg_dimensionSizes,Var_1850180796),
(Dim2 = Var_1850180796),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_283383329),nth1(Idx0,List_283383329,Var_283383329),(It = Var_283383329),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_893192050),nth1(Idx1,List_893192050,Var_893192050),(It2 = Var_893192050),
getArrayElement(Arg_datas,[It,It2],Var_644345897_1),getArrayElement(Self_datas,[It,It2],Var_1738674023_1),getArrayElement(Result_datas,[It,It2],Var_1472682156_1),(Var_1472682156_1 #= (Var_1738674023_1+Var_644345897_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_893192050),nth1(Idx1_1,List_893192050,Var_893192050_1),(It2_1 = Var_893192050_1),
getArrayElement(Arg_datas,[It,It2_1],Var_644345897_2),getArrayElement(Self_datas,[It,It2_1],Var_1738674023_2),getArrayElement(Result_datas,[It,It2_1],Var_1472682156_2),(Var_1472682156_2 #= (Var_1738674023_2+Var_644345897_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> Dim2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_283383329),nth1(Idx0_1,List_283383329,Var_283383329_1),(It_1 = Var_283383329_1),
(Acc2_1 = true),
(Idx1_3 #= 1),
(Idx1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_893192050),nth1(Idx1_3,List_893192050,Var_893192050_2),(It2_2 = Var_893192050_2),
getArrayElement(Arg_datas,[It_1,It2_2],Var_644345897_3),getArrayElement(Self_datas,[It_1,It2_2],Var_1738674023_3),getArrayElement(Result_datas,[It_1,It2_2],Var_1472682156_3),(Var_1472682156_3 #= (Var_1738674023_3+Var_644345897_3)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_893192050),nth1(Idx1_4,List_893192050,Var_893192050_3),(It2_3 = Var_893192050_3),
getArrayElement(Arg_datas,[It_1,It2_3],Var_644345897_4),getArrayElement(Self_datas,[It_1,It2_3],Var_1738674023_4),getArrayElement(Result_datas,[It_1,It2_3],Var_1472682156_4),(Var_1472682156_4 #= (Var_1738674023_4+Var_644345897_4)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> Dim2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
