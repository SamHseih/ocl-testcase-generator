:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DCC_Path_11_BDPath_1(Self,Arg,Result):-

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
length(Self_dimensionSizes,Var_2061347276),
length(Arg_dimensionSizes,Var_2081191879),
(Var_2081191879 #= Var_2061347276),
nth1(1,Self_dimensionSizes,Var_1128096251),
nth1(1,Arg_dimensionSizes,Var_1559122513),
(Var_1559122513 #= Var_1128096251),
length(Result_dimensionSizes,Var_1052245076),
length(Self_dimensionSizes,Var_2041605291),
(Var_2041605291 #= Var_1052245076),
nth1(1,Result_dimensionSizes,Var_1008925772),
nth1(1,Self_dimensionSizes,Var_2136288211),
(Var_2136288211 #= Var_1008925772),
nth1(1,Arg_dimensionSizes,Var_1205406622),
(Dim1 = Var_1205406622),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0,List_293907205,Var_293907205),(It = Var_293907205),
getArrayElement(Arg_data,[It],Var_199640888_1),getArrayElement(Self_data,[It],Var_117009527_1),getArrayElement(Result_data,[It],Var_487694075_1),(Var_487694075_1 #= (Var_117009527_1-Var_199640888_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_1,List_293907205,Var_293907205_1),(It_1 = Var_293907205_1),
getArrayElement(Arg_data,[It_1],Var_199640888_2),getArrayElement(Self_data,[It_1],Var_117009527_2),getArrayElement(Result_data,[It_1],Var_487694075_2),(Var_487694075_2 #= (Var_117009527_2-Var_199640888_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_2,List_293907205,Var_293907205_2),(It_2 = Var_293907205_2),
getArrayElement(Arg_data,[It_2],Var_199640888_3),getArrayElement(Self_data,[It_2],Var_117009527_3),getArrayElement(Result_data,[It_2],Var_487694075_3),(Var_487694075_3 #= (Var_117009527_3-Var_199640888_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_3,List_293907205,Var_293907205_3),(It_3 = Var_293907205_3),
getArrayElement(Arg_data,[It_3],Var_199640888_4),getArrayElement(Self_data,[It_3],Var_117009527_4),getArrayElement(Result_data,[It_3],Var_487694075_4),(Var_487694075_4 #= (Var_117009527_4-Var_199640888_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_4,List_293907205,Var_293907205_4),(It_4 = Var_293907205_4),
getArrayElement(Arg_data,[It_4],Var_199640888_5),getArrayElement(Self_data,[It_4],Var_117009527_5),getArrayElement(Result_data,[It_4],Var_487694075_5),(Var_487694075_5 #= (Var_117009527_5-Var_199640888_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_5,List_293907205,Var_293907205_5),(It_5 = Var_293907205_5),
getArrayElement(Arg_data,[It_5],Var_199640888_6),getArrayElement(Self_data,[It_5],Var_117009527_6),getArrayElement(Result_data,[It_5],Var_487694075_6),(Var_487694075_6 #= (Var_117009527_6-Var_199640888_6)),
(Index0_6 #= (Index0_5+1)),
(Index0_6 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_6,List_293907205,Var_293907205_6),(It_6 = Var_293907205_6),
getArrayElement(Arg_data,[It_6],Var_199640888_7),getArrayElement(Self_data,[It_6],Var_117009527_7),getArrayElement(Result_data,[It_6],Var_487694075_7),(Var_487694075_7 #= (Var_117009527_7-Var_199640888_7)),
(Index0_7 #= (Index0_6+1)),
(Index0_7 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Index0_7,List_293907205,Var_293907205_7),(It_7 = Var_293907205_7),
getArrayElement(Arg_data,[It_7],Var_199640888_8),getArrayElement(Self_data,[It_7],Var_117009527_8),getArrayElement(Result_data,[It_7],Var_487694075_8),(Var_487694075_8 #= (Var_117009527_8-Var_199640888_8)),
(Index0_8 #= (Index0_7+1)),
(Index0_8 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
