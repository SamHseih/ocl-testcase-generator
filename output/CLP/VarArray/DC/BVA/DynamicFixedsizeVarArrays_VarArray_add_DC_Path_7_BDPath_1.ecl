:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_7_BDPath_1(Self,Arg,Result):-

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
nth1(1,Arg_dimensionSizes,Var_1164440413),
nth1(1,Self_dimensionSizes,Var_1610525991),
length(Arg_dimensionSizes,Var_1666607455),
length(Self_dimensionSizes,Var_1327006586),
((Var_1327006586 #= Var_1666607455) , (Var_1610525991 #= Var_1164440413)),
nth1(1,Result_dimensionSizes,Var_899644639),
nth1(1,Self_dimensionSizes,Var_530737374),
length(Result_dimensionSizes,Var_1332668132),
length(Self_dimensionSizes,Var_1147580192),
((Var_1147580192 #= Var_1332668132) , (Var_530737374 #= Var_899644639)),
nth1(1,Arg_dimensionSizes,Var_173099767),
(Dim1 = Var_173099767),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Idx0,List_1336996537,Var_1336996537),(It = Var_1336996537),
getArrayElement(Arg_data,[It],Var_7967307_1),getArrayElement(Self_data,[It],Var_2073707154_1),getArrayElement(Result_data,[It],Var_78204644_1),(Var_78204644_1 #= (Var_2073707154_1+Var_7967307_1)),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Idx0_1,List_1336996537,Var_1336996537_1),(It_1 = Var_1336996537_1),
getArrayElement(Arg_data,[It_1],Var_7967307_2),getArrayElement(Self_data,[It_1],Var_2073707154_2),getArrayElement(Result_data,[It_1],Var_78204644_2),(Var_78204644_2 #= (Var_2073707154_2+Var_7967307_2)),
(Idx0_2 #= (Idx0_1+1)),
(Idx0_2 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Idx0_2,List_1336996537,Var_1336996537_2),(It_2 = Var_1336996537_2),
getArrayElement(Arg_data,[It_2],Var_7967307_3),getArrayElement(Self_data,[It_2],Var_2073707154_3),getArrayElement(Result_data,[It_2],Var_78204644_3),(Var_78204644_3 #= (Var_2073707154_3+Var_7967307_3)),
(Idx0_3 #= (Idx0_2+1)),
(Idx0_3 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Idx0_3,List_1336996537,Var_1336996537_3),(It_3 = Var_1336996537_3),
getArrayElement(Arg_data,[It_3],Var_7967307_4),getArrayElement(Self_data,[It_3],Var_2073707154_4),getArrayElement(Result_data,[It_3],Var_78204644_4),(Var_78204644_4 #= (Var_2073707154_4+Var_7967307_4)),
(Idx0_4 #= (Idx0_3+1)),
(Idx0_4 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Idx0_4,List_1336996537,Var_1336996537_4),(It_4 = Var_1336996537_4),
getArrayElement(Arg_data,[It_4],Var_7967307_5),getArrayElement(Self_data,[It_4],Var_2073707154_5),getArrayElement(Result_data,[It_4],Var_78204644_5),(Var_78204644_5 #= (Var_2073707154_5+Var_7967307_5)),
(Idx0_5 #= (Idx0_4+1)),
(Idx0_5 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
