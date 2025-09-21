:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_10_BDPath_1(Self,Arg,Result):-

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
nth1(1,Self_dimensionSizes,Var_1031061344),
(Var_1031061344 #> 0),
nth1(1,Arg_dimensionSizes,Var_2087885397),
nth1(1,Self_dimensionSizes,Var_1002021887),
length(Arg_dimensionSizes,Var_1712943792),
length(Self_dimensionSizes,Var_1525919705),
((Var_1525919705 #= Var_1712943792) , (Var_1002021887 #= Var_2087885397)),
nth1(1,Result_dimensionSizes,Var_842741472),
nth1(1,Self_dimensionSizes,Var_1156304131),
length(Result_dimensionSizes,Var_1766505436),
length(Self_dimensionSizes,Var_771775563),
((Var_771775563 #= Var_1766505436) , (Var_1156304131 #= Var_842741472)),
nth1(1,Arg_dimensionSizes,Var_1164440413),
(Dim1 = Var_1164440413),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0,List_899644639,Var_899644639),(It = Var_899644639),
getArrayElement(Arg_data,[It],Var_530737374_1),getArrayElement(Self_data,[It],Var_1332668132_1),getArrayElement(Result_data,[It],Var_1147580192_1),(Var_1147580192_1 #= (Var_1332668132_1+Var_530737374_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_1,List_899644639,Var_899644639_1),(It_1 = Var_899644639_1),
getArrayElement(Arg_data,[It_1],Var_530737374_2),getArrayElement(Self_data,[It_1],Var_1332668132_2),getArrayElement(Result_data,[It_1],Var_1147580192_2),(Var_1147580192_2 #= (Var_1332668132_2+Var_530737374_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_2,List_899644639,Var_899644639_2),(It_2 = Var_899644639_2),
getArrayElement(Arg_data,[It_2],Var_530737374_3),getArrayElement(Self_data,[It_2],Var_1332668132_3),getArrayElement(Result_data,[It_2],Var_1147580192_3),(Var_1147580192_3 #= (Var_1332668132_3+Var_530737374_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_3,List_899644639,Var_899644639_3),(It_3 = Var_899644639_3),
getArrayElement(Arg_data,[It_3],Var_530737374_4),getArrayElement(Self_data,[It_3],Var_1332668132_4),getArrayElement(Result_data,[It_3],Var_1147580192_4),(Var_1147580192_4 #= (Var_1332668132_4+Var_530737374_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_4,List_899644639,Var_899644639_4),(It_4 = Var_899644639_4),
getArrayElement(Arg_data,[It_4],Var_530737374_5),getArrayElement(Self_data,[It_4],Var_1332668132_5),getArrayElement(Result_data,[It_4],Var_1147580192_5),(Var_1147580192_5 #= (Var_1332668132_5+Var_530737374_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_5,List_899644639,Var_899644639_5),(It_5 = Var_899644639_5),
getArrayElement(Arg_data,[It_5],Var_530737374_6),getArrayElement(Self_data,[It_5],Var_1332668132_6),getArrayElement(Result_data,[It_5],Var_1147580192_6),(Var_1147580192_6 #= (Var_1332668132_6+Var_530737374_6)),
(Idx0_6 #= (Idx0_5+1)),
(Idx0_6 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_6,List_899644639,Var_899644639_6),(It_6 = Var_899644639_6),
getArrayElement(Arg_data,[It_6],Var_530737374_7),getArrayElement(Self_data,[It_6],Var_1332668132_7),getArrayElement(Result_data,[It_6],Var_1147580192_7),(Var_1147580192_7 #= (Var_1332668132_7+Var_530737374_7)),
(Idx0_7 #= (Idx0_6+1)),
(Idx0_7 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_899644639),nth1(Idx0_7,List_899644639,Var_899644639_7),(It_7 = Var_899644639_7),
getArrayElement(Arg_data,[It_7],Var_530737374_8),getArrayElement(Self_data,[It_7],Var_1332668132_8),getArrayElement(Result_data,[It_7],Var_1147580192_8),(Var_1147580192_8 #= (Var_1332668132_8+Var_530737374_8)),
(Idx0_8 #= (Idx0_7+1)),
(Idx0_8 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
