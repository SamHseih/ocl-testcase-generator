:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_5_BDPath_1(Self,Arg,Result):-

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
nth1(1,Self_dimensionSizes,Var_1128096251),
nth1(1,Arg_dimensionSizes,Var_1559122513),
length(Self_dimensionSizes,Var_2061347276),
length(Arg_dimensionSizes,Var_2081191879),
((Var_2081191879 #= Var_2061347276) , (Var_1559122513 #= Var_1128096251)),
nth1(1,Result_dimensionSizes,Var_1008925772),
nth1(1,Self_dimensionSizes,Var_2136288211),
length(Result_dimensionSizes,Var_1052245076),
length(Self_dimensionSizes,Var_2041605291),
((Var_2041605291 #= Var_1052245076) , (Var_2136288211 #= Var_1008925772)),
nth1(1,Arg_dimensionSizes,Var_1205406622),
(Dim1 = Var_1205406622),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Idx0,List_293907205,Var_293907205),(It = Var_293907205),
getArrayElement(Arg_data,[It],Var_199640888_1),getArrayElement(Self_data,[It],Var_117009527_1),getArrayElement(Result_data,[It],Var_487694075_1),(Var_487694075_1 #= (Var_117009527_1-Var_199640888_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Idx0_1,List_293907205,Var_293907205_1),(It_1 = Var_293907205_1),
getArrayElement(Arg_data,[It_1],Var_199640888_2),getArrayElement(Self_data,[It_1],Var_117009527_2),getArrayElement(Result_data,[It_1],Var_487694075_2),(Var_487694075_2 #= (Var_117009527_2-Var_199640888_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_293907205),nth1(Idx0_2,List_293907205,Var_293907205_2),(It_2 = Var_293907205_2),
getArrayElement(Arg_data,[It_2],Var_199640888_3),getArrayElement(Self_data,[It_2],Var_117009527_3),getArrayElement(Result_data,[It_2],Var_487694075_3),(Var_487694075_3 #= (Var_117009527_3-Var_199640888_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
