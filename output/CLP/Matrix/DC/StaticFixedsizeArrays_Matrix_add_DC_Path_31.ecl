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

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1331923253),
(Dim1 = Var_1331923253),
nth1(2,Arg_dimensionSizes,Var_1853205005),
(Dim2 = Var_1853205005),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2143431083),nth1(Idx0,List_2143431083,Var_2143431083),(It = Var_2143431083),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_331418503),nth1(Idx1,List_331418503,Var_331418503),(It2 = Var_331418503),
getArrayElement(Arg_datas,[It,It2],Var_112302969_1),getArrayElement(Self_datas,[It,It2],Var_6320204_1),getArrayElement(Result_datas,[It,It2],Var_597190999_1),(Var_597190999_1 #= (Var_6320204_1+Var_112302969_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_331418503),nth1(Idx1_1,List_331418503,Var_331418503_1),(It2_1 = Var_331418503_1),
getArrayElement(Arg_datas,[It,It2_1],Var_112302969_2),getArrayElement(Self_datas,[It,It2_1],Var_6320204_2),getArrayElement(Result_datas,[It,It2_1],Var_597190999_2),(Var_597190999_2 #= (Var_6320204_2+Var_112302969_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #> Dim2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2143431083),nth1(Idx0_1,List_2143431083,Var_2143431083_1),(It_1 = Var_2143431083_1),
(Acc2_1 = true),
(Idx1_3 #= 1),
(Idx1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_331418503),nth1(Idx1_3,List_331418503,Var_331418503_2),(It2_2 = Var_331418503_2),
getArrayElement(Arg_datas,[It_1,It2_2],Var_112302969_3),getArrayElement(Self_datas,[It_1,It2_2],Var_6320204_3),getArrayElement(Result_datas,[It_1,It2_2],Var_597190999_3),(Var_597190999_3 #= (Var_6320204_3+Var_112302969_3)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_331418503),nth1(Idx1_4,List_331418503,Var_331418503_3),(It2_3 = Var_331418503_3),
getArrayElement(Arg_datas,[It_1,It2_3],Var_112302969_4),getArrayElement(Self_datas,[It_1,It2_3],Var_6320204_4),getArrayElement(Result_datas,[It_1,It2_3],Var_597190999_4),(Var_597190999_4 #= (Var_6320204_4+Var_112302969_4)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> Dim2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_datas, Arg_datas]).
