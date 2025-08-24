:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_9_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_482082765),
(Var_482082765 #> 0),
nth1(1,Self_dimensionSizes,Var_1484171695),
nth1(1,Arg_dimensionSizes,Var_2127036371),
length(Self_dimensionSizes,Var_1529060733),
length(Arg_dimensionSizes,Var_106374177),
((Var_106374177 #= Var_1529060733) , (Var_2127036371 #= Var_1484171695)),
nth1(1,Result_dimensionSizes,Var_1803669141),
nth1(1,Self_dimensionSizes,Var_712609105),
length(Result_dimensionSizes,Var_1836463382),
length(Self_dimensionSizes,Var_1388278453),
((Var_1388278453 #= Var_1836463382) , (Var_712609105 #= Var_1803669141)),
nth1(1,Arg_dimensionSizes,Var_934275857),
(Dim1 = Var_934275857),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0,List_1364913072,Var_1364913072),(It = Var_1364913072),
getArrayElement(Arg_data,[It],Var_232307208_1),getArrayElement(Self_data,[It],Var_609962972_1),getArrayElement(Result_data,[It],Var_1818544933_1),(Var_1818544933_1 #= (Var_609962972_1-Var_232307208_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0_1,List_1364913072,Var_1364913072_1),(It_1 = Var_1364913072_1),
getArrayElement(Arg_data,[It_1],Var_232307208_2),getArrayElement(Self_data,[It_1],Var_609962972_2),getArrayElement(Result_data,[It_1],Var_1818544933_2),(Var_1818544933_2 #= (Var_609962972_2-Var_232307208_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0_2,List_1364913072,Var_1364913072_2),(It_2 = Var_1364913072_2),
getArrayElement(Arg_data,[It_2],Var_232307208_3),getArrayElement(Self_data,[It_2],Var_609962972_3),getArrayElement(Result_data,[It_2],Var_1818544933_3),(Var_1818544933_3 #= (Var_609962972_3-Var_232307208_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0_3,List_1364913072,Var_1364913072_3),(It_3 = Var_1364913072_3),
getArrayElement(Arg_data,[It_3],Var_232307208_4),getArrayElement(Self_data,[It_3],Var_609962972_4),getArrayElement(Result_data,[It_3],Var_1818544933_4),(Var_1818544933_4 #= (Var_609962972_4-Var_232307208_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0_4,List_1364913072,Var_1364913072_4),(It_4 = Var_1364913072_4),
getArrayElement(Arg_data,[It_4],Var_232307208_5),getArrayElement(Self_data,[It_4],Var_609962972_5),getArrayElement(Result_data,[It_4],Var_1818544933_5),(Var_1818544933_5 #= (Var_609962972_5-Var_232307208_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0_5,List_1364913072,Var_1364913072_5),(It_5 = Var_1364913072_5),
getArrayElement(Arg_data,[It_5],Var_232307208_6),getArrayElement(Self_data,[It_5],Var_609962972_6),getArrayElement(Result_data,[It_5],Var_1818544933_6),(Var_1818544933_6 #= (Var_609962972_6-Var_232307208_6)),
(Idx0_6 #= (Idx0_5+1)),
(Idx0_6 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1364913072),nth1(Idx0_6,List_1364913072,Var_1364913072_6),(It_6 = Var_1364913072_6),
getArrayElement(Arg_data,[It_6],Var_232307208_7),getArrayElement(Self_data,[It_6],Var_609962972_7),getArrayElement(Result_data,[It_6],Var_1818544933_7),(Var_1818544933_7 #= (Var_609962972_7-Var_232307208_7)),
(Idx0_7 #= (Idx0_6+1)),
(Idx0_7 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
