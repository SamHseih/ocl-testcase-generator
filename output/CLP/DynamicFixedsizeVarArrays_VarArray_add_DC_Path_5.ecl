:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_5(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_667821226),
nth1(1,Self_dimensionSizes,Var_1998767043),
((Var_1998767043 #> 0),
(Var_667821226 #< 10)),
nth1(1,Arg_dimensionSizes,Var_1912962767),
nth1(1,Self_dimensionSizes,Var_452805835),
length(Arg_dimensionSizes,Var_1769190683),
length(Self_dimensionSizes,Var_447981768),
((Var_447981768 #= Var_1769190683),
(Var_452805835 #= Var_1912962767)),
nth1(1,Result_dimensionSizes,Var_1125736023),
nth1(1,Self_dimensionSizes,Var_858952163),
length(Result_dimensionSizes,Var_1201484275),
length(Self_dimensionSizes,Var_1089418272),
((Var_1089418272 #= Var_1201484275),
(Var_858952163 #= Var_1125736023)),
nth1(1,Arg_dimensionSizes,Var_1233990028),
(Dim1 = Var_1233990028),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1509791656),nth1(Idx0,List_1509791656,Var_1509791656),(It = Var_1509791656),
getArrayElement(Arg_data,[It],Var_257608164_1),getArrayElement(Self_data,[It],Var_306115458_1),getArrayElement(Result_data,[It],Var_230643635_1),(Var_230643635_1 #= (Var_306115458_1+Var_257608164_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1509791656),nth1(Idx0_1,List_1509791656,Var_1509791656_1),(It_1 = Var_1509791656_1),
getArrayElement(Arg_data,[It_1],Var_257608164_2),getArrayElement(Self_data,[It_1],Var_306115458_2),getArrayElement(Result_data,[It_1],Var_230643635_2),(Var_230643635_2 #= (Var_306115458_2+Var_257608164_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1509791656),nth1(Idx0_2,List_1509791656,Var_1509791656_2),(It_2 = Var_1509791656_2),
getArrayElement(Arg_data,[It_2],Var_257608164_3),getArrayElement(Self_data,[It_2],Var_306115458_3),getArrayElement(Result_data,[It_2],Var_230643635_3),(Var_230643635_3 #= (Var_306115458_3+Var_257608164_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
