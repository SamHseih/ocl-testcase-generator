:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DCC_Path_3(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_299644693),
(Var_299644693 #> 0),
nth1(2,Self_dimensionSizes,Var_2052256418),
(Var_2052256418 #> 0),
length(Arg_dimensionSizes,Var_275266973),
length(Self_dimensionSizes,Var_1069716895),
(Var_1069716895 #= Var_275266973),
nth1(1,Arg_dimensionSizes,Var_1521083627),
nth1(1,Self_dimensionSizes,Var_1770642014),
(Var_1770642014 #\= Var_1521083627),
nth1(2,Arg_dimensionSizes,Var_945591847),
nth1(2,Self_dimensionSizes,Var_328827614),
(Var_328827614 #= Var_945591847),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
