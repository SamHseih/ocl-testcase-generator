:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DCC_Path_8(Self,Arg,Result):-

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
nth1(1,Self_dimensionSizes,Var_299644693),
(Var_299644693 #> 0),
nth1(2,Self_dimensionSizes,Var_2052256418),
(Var_2052256418 #> 0),
length(Arg_dimensionSizes,Var_1769193365),
length(Self_dimensionSizes,Var_1826699684),
(Var_1826699684 #= Var_1769193365),
nth1(1,Arg_dimensionSizes,Var_580718781),
nth1(1,Self_dimensionSizes,Var_769429195),
(Var_769429195 #= Var_580718781),
nth1(2,Arg_dimensionSizes,Var_343856911),
nth1(2,Self_dimensionSizes,Var_1115201599),
(Var_1115201599 #= Var_343856911),
length(Result_dimensionSizes,Var_1374026904),
length(Self_dimensionSizes,Var_536765369),
(Var_536765369 #= Var_1374026904),
nth1(1,Result_dimensionSizes,Var_317071334),
nth1(1,Self_dimensionSizes,Var_2085002312),
(Var_2085002312 #= Var_317071334),
nth1(2,Result_dimensionSizes,Var_1169794610),
nth1(2,Self_dimensionSizes,Var_71587369),
(Var_71587369 #= Var_1169794610),
nth1(1,Arg_dimensionSizes,Var_1307904972),
(D1 = Var_1307904972),
nth1(2,Arg_dimensionSizes,Var_1671846437),
(D2 = Var_1671846437),
(Acc = true),
(Index0 #= 1),
(Index0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_1422222071),nth1(Index0,List_1422222071,Var_1422222071),(It = Var_1422222071),
(Acc2 = true),
(Index1 #= 1),
(Index1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_2005733474),nth1(Index1,List_2005733474,Var_2005733474),(It2 = Var_2005733474),
getArrayElement(Arg_data,[It,It2],Var_2041605291_1),getArrayElement(Self_data,[It,It2],Var_1183888521_1),getArrayElement(Result_data,[It,It2],Var_1552978964_1),(Var_1552978964_1 #= (Var_1183888521_1+Var_2041605291_1)),
(Index1_1 #= (Index1+1)),
(Index1_1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_2005733474),nth1(Index1_1,List_2005733474,Var_2005733474_1),(It2_1 = Var_2005733474_1),
getArrayElement(Arg_data,[It,It2_1],Var_2041605291_2),getArrayElement(Self_data,[It,It2_1],Var_1183888521_2),getArrayElement(Result_data,[It,It2_1],Var_1552978964_2),(Var_1552978964_2 #= (Var_1183888521_2+Var_2041605291_2)),
(Index1_2 #= (Index1_1+1)),
(Index1_2 #> D2 - 1+ 1),
(Index0_1 #= (Index0+1)),
(Index0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
