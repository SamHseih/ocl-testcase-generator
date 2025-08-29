:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_Path_2_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_715378067),
(Var_715378067 #> 0),
nth1(2,Self_dimensionSizes,Var_1262773598),
(Var_1262773598 #> 0),
nth1(3,Self_dimensionSizes,Var_2147046752),
(Var_2147046752 #> 0),
length(Arg_dimensionSizes,Var_1101184763),
length(Self_dimensionSizes,Var_1816147548),
(Var_1816147548 #= Var_1101184763),
nth1(1,Arg_dimensionSizes,Var_2079179914),
nth1(1,Self_dimensionSizes,Var_20049680),
(Var_20049680 #= Var_2079179914),
nth1(2,Arg_dimensionSizes,Var_1437654187),
nth1(2,Self_dimensionSizes,Var_951050903),
(Var_951050903 #\= Var_1437654187),
nth1(3,Arg_dimensionSizes,Var_770947228),
nth1(3,Self_dimensionSizes,Var_590646109),
(Var_590646109 #= Var_770947228),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
