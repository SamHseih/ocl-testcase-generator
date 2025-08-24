:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DC_Path_9(Self,Arg,Result):-

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
nth1(2,Arg_dimensionSizes,Var_1337335626),
nth1(2,Self_dimensionSizes,Var_1336996537),
nth1(1,Arg_dimensionSizes,Var_7967307),
nth1(1,Self_dimensionSizes,Var_2073707154),
length(Arg_dimensionSizes,Var_78204644),
length(Self_dimensionSizes,Var_1287934450),
(((Var_1287934450 #= Var_78204644) , (Var_2073707154 #= Var_7967307)) , (Var_1336996537 #= Var_1337335626)),
nth1(2,Result_dimensionSizes,Var_6519275),
nth1(2,Self_dimensionSizes,Var_692331943),
nth1(1,Result_dimensionSizes,Var_1741979653),
nth1(1,Self_dimensionSizes,Var_166794956),
length(Result_dimensionSizes,Var_306612792),
length(Self_dimensionSizes,Var_447212746),
(((Var_447212746 #= Var_306612792) , (Var_166794956 #= Var_1741979653)) , (Var_692331943 #= Var_6519275)),
nth1(1,Arg_dimensionSizes,Var_1496355635),
(D1 = Var_1496355635),
nth1(2,Arg_dimensionSizes,Var_1484171695),
(D2 = Var_1484171695),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_1803669141),nth1(Idx0,List_1803669141,Var_1803669141),(It = Var_1803669141),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_712609105),nth1(Idx1,List_712609105,Var_712609105),(It2 = Var_712609105),
getArrayElement(Arg_data,[It,It2],Var_1836463382_1),getArrayElement(Self_data,[It,It2],Var_1388278453_1),getArrayElement(Result_data,[It,It2],Var_934275857_1),(Var_934275857_1 #= (Var_1388278453_1+Var_1836463382_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_712609105),nth1(Idx1_1,List_712609105,Var_712609105_1),(It2_1 = Var_712609105_1),
getArrayElement(Arg_data,[It,It2_1],Var_1836463382_2),getArrayElement(Self_data,[It,It2_1],Var_1388278453_2),getArrayElement(Result_data,[It,It2_1],Var_934275857_2),(Var_934275857_2 #= (Var_1388278453_2+Var_1836463382_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_712609105),nth1(Idx1_2,List_712609105,Var_712609105_2),(It2_2 = Var_712609105_2),
getArrayElement(Arg_data,[It,It2_2],Var_1836463382_3),getArrayElement(Self_data,[It,It2_2],Var_1388278453_3),getArrayElement(Result_data,[It,It2_2],Var_934275857_3),(Var_934275857_3 #= (Var_1388278453_3+Var_1836463382_3)),
(Idx1_3 #= (Idx1_2+1)),
(Idx1_3 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
