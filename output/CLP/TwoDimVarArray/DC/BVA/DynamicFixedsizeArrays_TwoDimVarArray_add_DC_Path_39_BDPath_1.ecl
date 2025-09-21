:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DC_Path_39_BDPath_1(Self,Arg,Result):-

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
nth1(2,Arg_dimensionSizes,Var_1327006586),
nth1(2,Self_dimensionSizes,Var_899644639),
nth1(1,Arg_dimensionSizes,Var_530737374),
nth1(1,Self_dimensionSizes,Var_1332668132),
length(Arg_dimensionSizes,Var_1147580192),
length(Self_dimensionSizes,Var_173099767),
(((Var_173099767 #= Var_1147580192) , (Var_1332668132 #= Var_530737374)) , (Var_899644639 #= Var_1327006586)),
nth1(2,Result_dimensionSizes,Var_112797691),
nth1(2,Self_dimensionSizes,Var_1045997582),
nth1(1,Result_dimensionSizes,Var_1337335626),
nth1(1,Self_dimensionSizes,Var_1336996537),
length(Result_dimensionSizes,Var_7967307),
length(Self_dimensionSizes,Var_2073707154),
(((Var_2073707154 #= Var_7967307) , (Var_1336996537 #= Var_1337335626)) , (Var_1045997582 #= Var_112797691)),
nth1(1,Arg_dimensionSizes,Var_78204644),
(D1 = Var_78204644),
nth1(2,Arg_dimensionSizes,Var_1287934450),
(D2 = Var_1287934450),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_166794956),nth1(Idx0,List_166794956,Var_166794956),(It = Var_166794956),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_306612792),nth1(Idx1,List_306612792,Var_306612792),(It2 = Var_306612792),
getArrayElement(Arg_data,[It,It2],Var_447212746_1),getArrayElement(Self_data,[It,It2],Var_1496355635_1),getArrayElement(Result_data,[It,It2],Var_1484171695_1),(Var_1484171695_1 #= (Var_1496355635_1+Var_447212746_1)),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_306612792),nth1(Idx1_1,List_306612792,Var_306612792_1),(It2_1 = Var_306612792_1),
getArrayElement(Arg_data,[It,It2_1],Var_447212746_2),getArrayElement(Self_data,[It,It2_1],Var_1496355635_2),getArrayElement(Result_data,[It,It2_1],Var_1484171695_2),(Var_1484171695_2 #= (Var_1496355635_2+Var_447212746_2)),
(Idx1_2 #= (Idx1_1+1)),
(Idx1_2 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_306612792),nth1(Idx1_2,List_306612792,Var_306612792_2),(It2_2 = Var_306612792_2),
getArrayElement(Arg_data,[It,It2_2],Var_447212746_3),getArrayElement(Self_data,[It,It2_2],Var_1496355635_3),getArrayElement(Result_data,[It,It2_2],Var_1484171695_3),(Var_1484171695_3 #= (Var_1496355635_3+Var_447212746_3)),
(Idx1_3 #= (Idx1_2+1)),
(Idx1_3 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_306612792),nth1(Idx1_3,List_306612792,Var_306612792_3),(It2_3 = Var_306612792_3),
getArrayElement(Arg_data,[It,It2_3],Var_447212746_4),getArrayElement(Self_data,[It,It2_3],Var_1496355635_4),getArrayElement(Result_data,[It,It2_3],Var_1484171695_4),(Var_1484171695_4 #= (Var_1496355635_4+Var_447212746_4)),
(Idx1_4 #= (Idx1_3+1)),
(Idx1_4 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_306612792),nth1(Idx1_4,List_306612792,Var_306612792_4),(It2_4 = Var_306612792_4),
getArrayElement(Arg_data,[It,It2_4],Var_447212746_5),getArrayElement(Self_data,[It,It2_4],Var_1496355635_5),getArrayElement(Result_data,[It,It2_4],Var_1484171695_5),(Var_1484171695_5 #= (Var_1496355635_5+Var_447212746_5)),
(Idx1_5 #= (Idx1_4+1)),
(Idx1_5 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_306612792),nth1(Idx1_5,List_306612792,Var_306612792_5),(It2_5 = Var_306612792_5),
getArrayElement(Arg_data,[It,It2_5],Var_447212746_6),getArrayElement(Self_data,[It,It2_5],Var_1496355635_6),getArrayElement(Result_data,[It,It2_5],Var_1484171695_6),(Var_1484171695_6 #= (Var_1496355635_6+Var_447212746_6)),
(Idx1_6 #= (Idx1_5+1)),
(Idx1_6 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
