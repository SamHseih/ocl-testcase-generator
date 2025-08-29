:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_Path_1(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_2110756088),
length(Self_dimensionSizes,Var_580871917),
(Var_580871917 #= Var_2110756088),
nth1(1,Arg_dimensionSizes,Var_823723302),
nth1(1,Self_dimensionSizes,Var_1714078840),
(Var_1714078840 #= Var_823723302),
nth1(2,Arg_dimensionSizes,Var_1732502545),
nth1(2,Self_dimensionSizes,Var_1051876890),
(Var_1051876890 #\= Var_1732502545),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
