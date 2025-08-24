:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_sub_DC_Path_9(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim1, Result_dim2],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(2,Self_dimensionSizes,Var_1336735375),
nth1(1,Self_dimensionSizes,Var_1754894440),
((Var_1754894440 #> 0) , (Var_1336735375 #> 0)),
nth1(2,Arg_dimensionSizes,Var_2114444063),
nth1(2,Self_dimensionSizes,Var_294247762),
nth1(1,Arg_dimensionSizes,Var_918312414),
nth1(1,Self_dimensionSizes,Var_1448061896),
length(Arg_dimensionSizes,Var_382750013),
length(Self_dimensionSizes,Var_1240232440),
(((Var_1240232440 #= Var_382750013) , (Var_1448061896 #= Var_918312414)) , (Var_294247762 #= Var_2114444063)),
nth1(2,Result_dimensionSizes,Var_489349054),
nth1(2,Self_dimensionSizes,Var_915416632),
nth1(1,Result_dimensionSizes,Var_574434418),
nth1(1,Self_dimensionSizes,Var_150268540),
length(Result_dimensionSizes,Var_1130894323),
length(Self_dimensionSizes,Var_1962826816),
(((Var_1962826816 #= Var_1130894323) , (Var_150268540 #= Var_574434418)) , (Var_915416632 #= Var_489349054)),
nth1(1,Arg_dimensionSizes,Var_1072410641),
(D1 = Var_1072410641),
nth1(2,Arg_dimensionSizes,Var_283318938),
(D2 = Var_283318938),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_320304382),nth1(Idx0,List_320304382,Var_320304382),(It = Var_320304382),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_361571968),nth1(Idx1,List_361571968,Var_361571968),(It2 = Var_361571968),
getArrayElement(Arg_data,[It,It2],Var_2005169944_1),getArrayElement(Self_data,[It,It2],Var_2134607032_1),getArrayElement(Result_data,[It,It2],Var_1470344997_1),(Var_1470344997_1 #= (Var_2134607032_1-Var_2005169944_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_361571968),nth1(Idx1_1,List_361571968,Var_361571968_1),(It2_1 = Var_361571968_1),
getArrayElement(Arg_data,[It,It2_1],Var_2005169944_2),getArrayElement(Self_data,[It,It2_1],Var_2134607032_2),getArrayElement(Result_data,[It,It2_1],Var_1470344997_2),(Var_1470344997_2 #= (Var_2134607032_2-Var_2005169944_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_361571968),nth1(Idx1_2,List_361571968,Var_361571968_2),(It2_2 = Var_361571968_2),
getArrayElement(Arg_data,[It,It2_2],Var_2005169944_3),getArrayElement(Self_data,[It,It2_2],Var_2134607032_3),getArrayElement(Result_data,[It,It2_2],Var_1470344997_3),(Var_1470344997_3 #= (Var_2134607032_3-Var_2005169944_3)),
(Idx1_3 #= (Idx1_2+1)),
(Idx1_3 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
