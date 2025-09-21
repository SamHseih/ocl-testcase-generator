:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_sub_DC_Path_44_BDPath_1(Self,Arg,Result):-

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
nth1(2,Self_dimensionSizes,Var_1353070773),
nth1(1,Self_dimensionSizes,Var_1107024580),
((Var_1107024580 #> 0) , (Var_1353070773 #> 0)),
nth1(2,Arg_dimensionSizes,Var_1926343982),
nth1(2,Self_dimensionSizes,Var_762476028),
nth1(1,Arg_dimensionSizes,Var_966739377),
nth1(1,Self_dimensionSizes,Var_952562199),
length(Arg_dimensionSizes,Var_1199673596),
length(Self_dimensionSizes,Var_2044903525),
(((Var_2044903525 #= Var_1199673596) , (Var_952562199 #= Var_966739377)) , (Var_762476028 #= Var_1926343982)),
nth1(2,Result_dimensionSizes,Var_982757413),
nth1(2,Self_dimensionSizes,Var_902478634),
nth1(1,Result_dimensionSizes,Var_2114444063),
nth1(1,Self_dimensionSizes,Var_294247762),
length(Result_dimensionSizes,Var_918312414),
length(Self_dimensionSizes,Var_1448061896),
(((Var_1448061896 #= Var_918312414) , (Var_294247762 #= Var_2114444063)) , (Var_902478634 #= Var_982757413)),
nth1(1,Arg_dimensionSizes,Var_382750013),
(D1 = Var_382750013),
nth1(2,Arg_dimensionSizes,Var_1240232440),
(D2 = Var_1240232440),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_489349054),nth1(Idx0,List_489349054,Var_489349054),(It = Var_489349054),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_915416632),nth1(Idx1,List_915416632,Var_915416632),(It2 = Var_915416632),
getArrayElement(Arg_data,[It,It2],Var_574434418_1),getArrayElement(Self_data,[It,It2],Var_150268540_1),getArrayElement(Result_data,[It,It2],Var_1130894323_1),(Var_1130894323_1 #= (Var_150268540_1-Var_574434418_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_489349054),nth1(Idx0_1,List_489349054,Var_489349054_1),(It_1 = Var_489349054_1),
(Acc2_1 = true),
(Idx1_2 #= 1),
(Idx1_2 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_915416632),nth1(Idx1_2,List_915416632,Var_915416632_1),(It2_1 = Var_915416632_1),
getArrayElement(Arg_data,[It_1,It2_1],Var_574434418_2),getArrayElement(Self_data,[It_1,It2_1],Var_150268540_2),getArrayElement(Result_data,[It_1,It2_1],Var_1130894323_2),(Var_1130894323_2 #= (Var_150268540_2-Var_574434418_2)),
(Idx1_3 #= (Idx1_2+1)),
(Idx1_3 #> D2 - 1+ 1),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_489349054),nth1(Idx0_2,List_489349054,Var_489349054_2),(It_2 = Var_489349054_2),
(Acc2_2 = true),
(Idx1_4 #= 1),
(Idx1_4 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_915416632),nth1(Idx1_4,List_915416632,Var_915416632_2),(It2_2 = Var_915416632_2),
getArrayElement(Arg_data,[It_2,It2_2],Var_574434418_3),getArrayElement(Self_data,[It_2,It2_2],Var_150268540_3),getArrayElement(Result_data,[It_2,It2_2],Var_1130894323_3),(Var_1130894323_3 #= (Var_150268540_3-Var_574434418_3)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #> D2 - 1+ 1),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
