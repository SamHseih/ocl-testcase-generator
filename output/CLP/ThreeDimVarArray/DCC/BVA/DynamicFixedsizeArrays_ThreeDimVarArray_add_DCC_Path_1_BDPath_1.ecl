:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1031061344),
(Var_1031061344 #> 0),
nth1(2,Self_dimensionSizes,Var_1107024580),
(Var_1107024580 #> 0),
nth1(3,Self_dimensionSizes,Var_1010856212),
(Var_1010856212 #> 0),
length(Arg_dimensionSizes,Var_1904253191),
length(Self_dimensionSizes,Var_1021436681),
(Var_1021436681 #= Var_1904253191),
nth1(1,Arg_dimensionSizes,Var_1790585734),
nth1(1,Self_dimensionSizes,Var_22600334),
(Var_22600334 #= Var_1790585734),
nth1(2,Arg_dimensionSizes,Var_1961173763),
nth1(2,Self_dimensionSizes,Var_1202683709),
(Var_1202683709 #= Var_1961173763),
nth1(3,Arg_dimensionSizes,Var_2087885397),
nth1(3,Self_dimensionSizes,Var_1002021887),
(Var_1002021887 #\= Var_2087885397),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
