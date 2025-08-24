:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DCC_Path_5_BDPath_1(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_1610525991),
length(Self_dimensionSizes,Var_1666607455),
(Var_1666607455 #= Var_1610525991),
nth1(1,Arg_dimensionSizes,Var_1327006586),
nth1(1,Self_dimensionSizes,Var_899644639),
(Var_899644639 #= Var_1327006586),
length(Result_dimensionSizes,Var_530737374),
length(Self_dimensionSizes,Var_1332668132),
(Var_1332668132 #= Var_530737374),
nth1(1,Result_dimensionSizes,Var_1147580192),
nth1(1,Self_dimensionSizes,Var_173099767),
(Var_173099767 #= Var_1147580192),
nth1(1,Arg_dimensionSizes,Var_112797691),
(Dim1 = Var_112797691),
(Acc = true),
(Index0 #= 1),
(Index0 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Index0,List_1336996537,Var_1336996537),(It = Var_1336996537),
getArrayElement(Arg_data,[It],Var_7967307_1),getArrayElement(Self_data,[It],Var_2073707154_1),getArrayElement(Result_data,[It],Var_78204644_1),(Var_78204644_1 #= (Var_2073707154_1+Var_7967307_1)),
(Index0_1 #= (Index0+1)),
(Index0_1 #=< Dim1 - 1+ 1),
sequencetoList(1,Dim1,List_1336996537),nth1(Index0_1,List_1336996537,Var_1336996537_1),(It_1 = Var_1336996537_1),
getArrayElement(Arg_data,[It_1],Var_7967307_2),getArrayElement(Self_data,[It_1],Var_2073707154_2),getArrayElement(Result_data,[It_1],Var_78204644_2),(Var_78204644_2 #= (Var_2073707154_2+Var_7967307_2)),
(Index0_2 #= (Index0_1+1)),
(Index0_2 #> Dim1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
