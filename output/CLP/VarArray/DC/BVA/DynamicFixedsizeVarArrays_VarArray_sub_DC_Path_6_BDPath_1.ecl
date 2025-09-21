:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_6_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1031061344),
(Var_1031061344 #> 0),
nth1(1,Self_dimensionSizes,Var_1287934450),
nth1(1,Arg_dimensionSizes,Var_6519275),
length(Self_dimensionSizes,Var_692331943),
length(Arg_dimensionSizes,Var_1741979653),
((Var_1741979653 #= Var_692331943) , (Var_6519275 #= Var_1287934450)),
nth1(1,Result_dimensionSizes,Var_166794956),
nth1(1,Self_dimensionSizes,Var_306612792),
length(Result_dimensionSizes,Var_447212746),
length(Self_dimensionSizes,Var_1496355635),
((Var_1496355635 #= Var_447212746) , (Var_306612792 #= Var_166794956)),
nth1(1,Arg_dimensionSizes,Var_1484171695),
(Dim1 = Var_1484171695),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2127036371),nth1(Idx0,List_2127036371,Var_2127036371),(It = Var_2127036371),
getArrayElement(Arg_data,[It],Var_1529060733_1),getArrayElement(Self_data,[It],Var_106374177_1),getArrayElement(Result_data,[It],Var_1803669141_1),(Var_1803669141_1 #= (Var_106374177_1-Var_1529060733_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2127036371),nth1(Idx0_1,List_2127036371,Var_2127036371_1),(It_1 = Var_2127036371_1),
getArrayElement(Arg_data,[It_1],Var_1529060733_2),getArrayElement(Self_data,[It_1],Var_106374177_2),getArrayElement(Result_data,[It_1],Var_1803669141_2),(Var_1803669141_2 #= (Var_106374177_2-Var_1529060733_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2127036371),nth1(Idx0_2,List_2127036371,Var_2127036371_2),(It_2 = Var_2127036371_2),
getArrayElement(Arg_data,[It_2],Var_1529060733_3),getArrayElement(Self_data,[It_2],Var_106374177_3),getArrayElement(Result_data,[It_2],Var_1803669141_3),(Var_1803669141_3 #= (Var_106374177_3-Var_1529060733_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2127036371),nth1(Idx0_3,List_2127036371,Var_2127036371_3),(It_3 = Var_2127036371_3),
getArrayElement(Arg_data,[It_3],Var_1529060733_4),getArrayElement(Self_data,[It_3],Var_106374177_4),getArrayElement(Result_data,[It_3],Var_1803669141_4),(Var_1803669141_4 #= (Var_106374177_4-Var_1529060733_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
