:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DCC_Path_6(Self,Arg,Result):-

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
nth1(1,Self_dimensionSizes,Var_1353070773),
(Var_1353070773 #> 0),
nth1(2,Self_dimensionSizes,Var_1107024580),
(Var_1107024580 #> 0),
length(Arg_dimensionSizes,Var_369049246),
length(Self_dimensionSizes,Var_1608297024),
(Var_1608297024 #= Var_369049246),
nth1(1,Arg_dimensionSizes,Var_1841396611),
nth1(1,Self_dimensionSizes,Var_1577592551),
(Var_1577592551 #= Var_1841396611),
nth1(2,Arg_dimensionSizes,Var_854587510),
nth1(2,Self_dimensionSizes,Var_148626113),
(Var_148626113 #= Var_854587510),
length(Result_dimensionSizes,Var_1847637306),
length(Self_dimensionSizes,Var_1904253191),
(Var_1904253191 #= Var_1847637306),
nth1(1,Result_dimensionSizes,Var_1021436681),
nth1(1,Self_dimensionSizes,Var_1790585734),
(Var_1790585734 #= Var_1021436681),
nth1(2,Result_dimensionSizes,Var_22600334),
nth1(2,Self_dimensionSizes,Var_1961173763),
(Var_1961173763 #= Var_22600334),
nth1(1,Arg_dimensionSizes,Var_1202683709),
(D1 = Var_1202683709),
nth1(2,Arg_dimensionSizes,Var_2087885397),
(D2 = Var_2087885397),
(Acc = true),
(Index0 #= 1),
(Index0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_1525919705),nth1(Index0,List_1525919705,Var_1525919705),(It = Var_1525919705),
(Acc2 = true),
(Index1 #= 1),
(Index1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_842741472),nth1(Index1,List_842741472,Var_842741472),(It2 = Var_842741472),
getArrayElement(Arg_data,[It,It2],Var_1156304131_1),getArrayElement(Self_data,[It,It2],Var_1766505436_1),getArrayElement(Result_data,[It,It2],Var_771775563_1),(Var_771775563_1 #= (Var_1766505436_1+Var_1156304131_1)),
(Index1_1 #= (Index1+1)),
(Index1_1 #> D2 - 1+ 1),
(Index0_1 #= (Index0+1)),
(Index0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
