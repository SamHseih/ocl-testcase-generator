:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DCC_Path_8(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_1645547422),
length(Self_dimensionSizes,Var_440737101),
(Var_440737101 #= Var_1645547422),
nth1(1,Arg_dimensionSizes,Var_2141817446),
nth1(1,Self_dimensionSizes,Var_369049246),
(Var_369049246 #= Var_2141817446),
length(Result_dimensionSizes,Var_1608297024),
length(Self_dimensionSizes,Var_1841396611),
(Var_1841396611 #= Var_1608297024),
nth1(1,Result_dimensionSizes,Var_1577592551),
nth1(1,Self_dimensionSizes,Var_854587510),
(Var_854587510 #= Var_1577592551),
nth1(1,Arg_dimensionSizes,Var_148626113),
(Dim1 = Var_148626113),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1021436681),nth1(Index0,List_1021436681,Var_1021436681),(It = Var_1021436681),
getArrayElement(Arg_data,[It],Var_1790585734_1),getArrayElement(Self_data,[It],Var_22600334_1),getArrayElement(Result_data,[It],Var_1961173763_1),(Var_1961173763_1 #= (Var_22600334_1+Var_1790585734_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1021436681),nth1(Index0_1,List_1021436681,Var_1021436681_1),(It_1 = Var_1021436681_1),
getArrayElement(Arg_data,[It_1],Var_1790585734_2),getArrayElement(Self_data,[It_1],Var_22600334_2),getArrayElement(Result_data,[It_1],Var_1961173763_2),(Var_1961173763_2 #= (Var_22600334_2+Var_1790585734_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1021436681),nth1(Index0_2,List_1021436681,Var_1021436681_2),(It_2 = Var_1021436681_2),
getArrayElement(Arg_data,[It_2],Var_1790585734_3),getArrayElement(Self_data,[It_2],Var_22600334_3),getArrayElement(Result_data,[It_2],Var_1961173763_3),(Var_1961173763_3 #= (Var_22600334_3+Var_1790585734_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1021436681),nth1(Index0_3,List_1021436681,Var_1021436681_3),(It_3 = Var_1021436681_3),
getArrayElement(Arg_data,[It_3],Var_1790585734_4),getArrayElement(Self_data,[It_3],Var_22600334_4),getArrayElement(Result_data,[It_3],Var_1961173763_4),(Var_1961173763_4 #= (Var_22600334_4+Var_1790585734_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1021436681),nth1(Index0_4,List_1021436681,Var_1021436681_4),(It_4 = Var_1021436681_4),
getArrayElement(Arg_data,[It_4],Var_1790585734_5),getArrayElement(Self_data,[It_4],Var_22600334_5),getArrayElement(Result_data,[It_4],Var_1961173763_5),(Var_1961173763_5 #= (Var_22600334_5+Var_1790585734_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
