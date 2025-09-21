:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Array_add_DCC_Path_6(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [5],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [5],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [5],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_1105423942),
(Dim1 = Var_1105423942),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_904861801),nth1(Index0,List_904861801,Var_904861801),(It = Var_904861801),
getArrayElement(Arg_data,[It],Var_204715855_1),getArrayElement(Self_data,[It],Var_318857719_1),getArrayElement(Result_data,[It],Var_745962066_1),(Var_745962066_1 #= (Var_318857719_1+Var_204715855_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_904861801),nth1(Index0_1,List_904861801,Var_904861801_1),(It_1 = Var_904861801_1),
getArrayElement(Arg_data,[It_1],Var_204715855_2),getArrayElement(Self_data,[It_1],Var_318857719_2),getArrayElement(Result_data,[It_1],Var_745962066_2),(Var_745962066_2 #= (Var_318857719_2+Var_204715855_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_904861801),nth1(Index0_2,List_904861801,Var_904861801_2),(It_2 = Var_904861801_2),
getArrayElement(Arg_data,[It_2],Var_204715855_3),getArrayElement(Self_data,[It_2],Var_318857719_3),getArrayElement(Result_data,[It_2],Var_745962066_3),(Var_745962066_3 #= (Var_318857719_3+Var_204715855_3)),
(Index0_3 #= (Index0_2+1)),
(Index0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_904861801),nth1(Index0_3,List_904861801,Var_904861801_3),(It_3 = Var_904861801_3),
getArrayElement(Arg_data,[It_3],Var_204715855_4),getArrayElement(Self_data,[It_3],Var_318857719_4),getArrayElement(Result_data,[It_3],Var_745962066_4),(Var_745962066_4 #= (Var_318857719_4+Var_204715855_4)),
(Index0_4 #= (Index0_3+1)),
(Index0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_904861801),nth1(Index0_4,List_904861801,Var_904861801_4),(It_4 = Var_904861801_4),
getArrayElement(Arg_data,[It_4],Var_204715855_5),getArrayElement(Self_data,[It_4],Var_318857719_5),getArrayElement(Result_data,[It_4],Var_745962066_5),(Var_745962066_5 #= (Var_318857719_5+Var_204715855_5)),
(Index0_5 #= (Index0_4+1)),
(Index0_5 #> Dim1 - 1+ 1),

%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
