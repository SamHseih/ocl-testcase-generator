:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_9(Self,Arg,Result):-

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
nth1(1,Self_dimensionSizes,Var_1202683709),
nth1(1,Arg_dimensionSizes,Var_2087885397),
length(Self_dimensionSizes,Var_1002021887),
length(Arg_dimensionSizes,Var_1712943792),
((Var_1712943792 #= Var_1002021887) , (Var_2087885397 #= Var_1202683709)),
nth1(1,Result_dimensionSizes,Var_1525919705),
nth1(1,Self_dimensionSizes,Var_842741472),
length(Result_dimensionSizes,Var_1156304131),
length(Self_dimensionSizes,Var_1766505436),
((Var_1766505436 #= Var_1156304131) , (Var_842741472 #= Var_1525919705)),
nth1(1,Arg_dimensionSizes,Var_771775563),
(Dim1 = Var_771775563),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0,List_1164440413,Var_1164440413),(It = Var_1164440413),
getArrayElement(Arg_data,[It],Var_1610525991_1),getArrayElement(Self_data,[It],Var_1666607455_1),getArrayElement(Result_data,[It],Var_1327006586_1),(Var_1327006586_1 #= (Var_1666607455_1-Var_1610525991_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0_1,List_1164440413,Var_1164440413_1),(It_1 = Var_1164440413_1),
getArrayElement(Arg_data,[It_1],Var_1610525991_2),getArrayElement(Self_data,[It_1],Var_1666607455_2),getArrayElement(Result_data,[It_1],Var_1327006586_2),(Var_1327006586_2 #= (Var_1666607455_2-Var_1610525991_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0_2,List_1164440413,Var_1164440413_2),(It_2 = Var_1164440413_2),
getArrayElement(Arg_data,[It_2],Var_1610525991_3),getArrayElement(Self_data,[It_2],Var_1666607455_3),getArrayElement(Result_data,[It_2],Var_1327006586_3),(Var_1327006586_3 #= (Var_1666607455_3-Var_1610525991_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0_3,List_1164440413,Var_1164440413_3),(It_3 = Var_1164440413_3),
getArrayElement(Arg_data,[It_3],Var_1610525991_4),getArrayElement(Self_data,[It_3],Var_1666607455_4),getArrayElement(Result_data,[It_3],Var_1327006586_4),(Var_1327006586_4 #= (Var_1666607455_4-Var_1610525991_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0_4,List_1164440413,Var_1164440413_4),(It_4 = Var_1164440413_4),
getArrayElement(Arg_data,[It_4],Var_1610525991_5),getArrayElement(Self_data,[It_4],Var_1666607455_5),getArrayElement(Result_data,[It_4],Var_1327006586_5),(Var_1327006586_5 #= (Var_1666607455_5-Var_1610525991_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0_5,List_1164440413,Var_1164440413_5),(It_5 = Var_1164440413_5),
getArrayElement(Arg_data,[It_5],Var_1610525991_6),getArrayElement(Self_data,[It_5],Var_1666607455_6),getArrayElement(Result_data,[It_5],Var_1327006586_6),(Var_1327006586_6 #= (Var_1666607455_6-Var_1610525991_6)),
(Idx0_6 #= (Idx0_5+1)),
(Idx0_6 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1164440413),nth1(Idx0_6,List_1164440413,Var_1164440413_6),(It_6 = Var_1164440413_6),
getArrayElement(Arg_data,[It_6],Var_1610525991_7),getArrayElement(Self_data,[It_6],Var_1666607455_7),getArrayElement(Result_data,[It_6],Var_1327006586_7),(Var_1327006586_7 #= (Var_1666607455_7-Var_1610525991_7)),
(Idx0_7 #= (Idx0_6+1)),
(Idx0_7 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
