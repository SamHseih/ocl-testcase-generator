:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DCC_Path_8(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_2143431083),
(Var_2143431083 #> 0),
length(Self_dimensionSizes,Var_963110412),
length(Arg_dimensionSizes,Var_550668305),
(Var_550668305 #= Var_963110412),
nth1(1,Self_dimensionSizes,Var_1219161283),
nth1(1,Arg_dimensionSizes,Var_1624820151),
(Var_1624820151 #= Var_1219161283),
length(Result_dimensionSizes,Var_70807318),
length(Self_dimensionSizes,Var_782378927),
(Var_782378927 #= Var_70807318),
nth1(1,Result_dimensionSizes,Var_1183888521),
nth1(1,Self_dimensionSizes,Var_910091170),
(Var_910091170 #= Var_1183888521),
nth1(1,Arg_dimensionSizes,Var_1052245076),
(Dim1 = Var_1052245076),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2136288211),nth1(Index0,List_2136288211,Var_2136288211),(It = Var_2136288211),
getArrayElement(Arg_data,[It],Var_1990160809_1),getArrayElement(Self_data,[It],Var_77269878_1),getArrayElement(Result_data,[It],Var_200224114_1),(Var_200224114_1 #= (Var_77269878_1-Var_1990160809_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2136288211),nth1(Index0_1,List_2136288211,Var_2136288211_1),(It_1 = Var_2136288211_1),
getArrayElement(Arg_data,[It_1],Var_1990160809_2),getArrayElement(Self_data,[It_1],Var_77269878_2),getArrayElement(Result_data,[It_1],Var_200224114_2),(Var_200224114_2 #= (Var_77269878_2-Var_1990160809_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2136288211),nth1(Index0_2,List_2136288211,Var_2136288211_2),(It_2 = Var_2136288211_2),
getArrayElement(Arg_data,[It_2],Var_1990160809_3),getArrayElement(Self_data,[It_2],Var_77269878_3),getArrayElement(Result_data,[It_2],Var_200224114_3),(Var_200224114_3 #= (Var_77269878_3-Var_1990160809_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2136288211),nth1(Index0_3,List_2136288211,Var_2136288211_3),(It_3 = Var_2136288211_3),
getArrayElement(Arg_data,[It_3],Var_1990160809_4),getArrayElement(Self_data,[It_3],Var_77269878_4),getArrayElement(Result_data,[It_3],Var_200224114_4),(Var_200224114_4 #= (Var_77269878_4-Var_1990160809_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_2136288211),nth1(Index0_4,List_2136288211,Var_2136288211_4),(It_4 = Var_2136288211_4),
getArrayElement(Arg_data,[It_4],Var_1990160809_5),getArrayElement(Self_data,[It_4],Var_77269878_5),getArrayElement(Result_data,[It_4],Var_200224114_5),(Var_200224114_5 #= (Var_77269878_5-Var_1990160809_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
