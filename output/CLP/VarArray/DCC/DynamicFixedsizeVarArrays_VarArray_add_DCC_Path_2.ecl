:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DCC_Path_2(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_2143431083),
(Var_2143431083 #> 0),
length(Arg_dimensionSizes,Var_1427381743),
length(Self_dimensionSizes,Var_1427646530),
(Var_1427646530 #= Var_1427381743),
nth1(1,Arg_dimensionSizes,Var_846254484),
nth1(1,Self_dimensionSizes,Var_592983282),
(Var_592983282 #\= Var_846254484),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
