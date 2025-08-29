:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DCC_Path_7(Self,Arg,Result):-

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
nth1(1,Self_dimensionSizes,Var_2143431083),
(Var_2143431083 #> 0),
length(Arg_dimensionSizes,Var_363988129),
length(Self_dimensionSizes,Var_306980751),
(Var_306980751 #= Var_363988129),
nth1(1,Arg_dimensionSizes,Var_534906248),
nth1(1,Self_dimensionSizes,Var_1997963191),
(Var_1997963191 #= Var_534906248),
length(Result_dimensionSizes,Var_1169794610),
length(Self_dimensionSizes,Var_71587369),
(Var_71587369 #= Var_1169794610),
nth1(1,Result_dimensionSizes,Var_1307904972),
nth1(1,Self_dimensionSizes,Var_634540230),
(Var_634540230 #= Var_1307904972),
nth1(1,Arg_dimensionSizes,Var_1671846437),
(Dim1 = Var_1671846437),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1422222071),nth1(Index0,List_1422222071,Var_1422222071),(It = Var_1422222071),
getArrayElement(Arg_data,[It],Var_521081105_1),getArrayElement(Self_data,[It],Var_6750210_1),getArrayElement(Result_data,[It],Var_1580297332_1),(Var_1580297332_1 #= (Var_6750210_1+Var_521081105_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1422222071),nth1(Index0_1,List_1422222071,Var_1422222071_1),(It_1 = Var_1422222071_1),
getArrayElement(Arg_data,[It_1],Var_521081105_2),getArrayElement(Self_data,[It_1],Var_6750210_2),getArrayElement(Result_data,[It_1],Var_1580297332_2),(Var_1580297332_2 #= (Var_6750210_2+Var_521081105_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1422222071),nth1(Index0_2,List_1422222071,Var_1422222071_2),(It_2 = Var_1422222071_2),
getArrayElement(Arg_data,[It_2],Var_521081105_3),getArrayElement(Self_data,[It_2],Var_6750210_3),getArrayElement(Result_data,[It_2],Var_1580297332_3),(Var_1580297332_3 #= (Var_6750210_3+Var_521081105_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1422222071),nth1(Index0_3,List_1422222071,Var_1422222071_3),(It_3 = Var_1422222071_3),
getArrayElement(Arg_data,[It_3],Var_521081105_4),getArrayElement(Self_data,[It_3],Var_6750210_4),getArrayElement(Result_data,[It_3],Var_1580297332_4),(Var_1580297332_4 #= (Var_6750210_4+Var_521081105_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
