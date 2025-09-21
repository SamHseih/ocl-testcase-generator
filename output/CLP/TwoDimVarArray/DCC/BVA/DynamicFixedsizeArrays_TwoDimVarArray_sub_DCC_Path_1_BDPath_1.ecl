:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1353070773),
(Var_1353070773 #> 0),
nth1(2,Self_dimensionSizes,Var_1107024580),
(Var_1107024580 #> 0),
length(Arg_dimensionSizes,Var_2127036371),
length(Self_dimensionSizes,Var_1529060733),
(Var_1529060733 #= Var_2127036371),
nth1(1,Arg_dimensionSizes,Var_106374177),
nth1(1,Self_dimensionSizes,Var_1803669141),
(Var_1803669141 #= Var_106374177),
nth1(2,Arg_dimensionSizes,Var_712609105),
nth1(2,Self_dimensionSizes,Var_1836463382),
(Var_1836463382 #\= Var_712609105),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
