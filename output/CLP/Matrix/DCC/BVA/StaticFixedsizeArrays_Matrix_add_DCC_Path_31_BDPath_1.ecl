:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_add_DCC_Path_31_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [2, 2],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [2, 2],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1105423942),
(Dim1 = Var_1105423942),
nth1(2,Arg_dimensionSizes,Var_875016237),
(Dim2 = Var_875016237),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_204715855),nth1(Index0,List_204715855,Var_204715855),(It = Var_204715855),
(Acc2 = true),
(Index1 #= 1),
(Index1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_318857719),nth1(Index1,List_318857719,Var_318857719),(It2 = Var_318857719),
getArrayElement(Arg_data,[It,It2],Var_745962066_1),getArrayElement(Self_data,[It,It2],Var_1637290981_1),getArrayElement(Result_data,[It,It2],Var_1888442711_1),(Var_1888442711_1 #= (Var_1637290981_1+Var_745962066_1)),
(Index1_1 #= (Index1+1)),
(Index1_1 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_318857719),nth1(Index1_1,List_318857719,Var_318857719_1),(It2_1 = Var_318857719_1),
getArrayElement(Arg_data,[It,It2_1],Var_745962066_2),getArrayElement(Self_data,[It,It2_1],Var_1637290981_2),getArrayElement(Result_data,[It,It2_1],Var_1888442711_2),(Var_1888442711_2 #= (Var_1637290981_2+Var_745962066_2)),
(Index1_2 #= (Index1_1+1)),
(Index1_2 #> Dim2 - 1+ 1),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_204715855),nth1(Index0_1,List_204715855,Var_204715855_1),(It_1 = Var_204715855_1),
(Acc2_1 = true),
(Index1_3 #= 1),
(Index1_3 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_318857719),nth1(Index1_3,List_318857719,Var_318857719_2),(It2_2 = Var_318857719_2),
getArrayElement(Arg_data,[It_1,It2_2],Var_745962066_3),getArrayElement(Self_data,[It_1,It2_2],Var_1637290981_3),getArrayElement(Result_data,[It_1,It2_2],Var_1888442711_3),(Var_1888442711_3 #= (Var_1637290981_3+Var_745962066_3)),
(Index1_4 #= (Index1_3+1)),
(Index1_4 #=< Dim2 - 1+ 1),
sequencetoList(1,Dim2,List_318857719),nth1(Index1_4,List_318857719,Var_318857719_3),(It2_3 = Var_318857719_3),
getArrayElement(Arg_data,[It_1,It2_3],Var_745962066_4),getArrayElement(Self_data,[It_1,It2_3],Var_1637290981_4),getArrayElement(Result_data,[It_1,It2_3],Var_1888442711_4),(Var_1888442711_4 #= (Var_1637290981_4+Var_745962066_4)),
(Index1_5 #= (Index1_4+1)),
(Index1_5 #> Dim2 - 1+ 1),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
