:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_Path_2(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_1712943792),
length(Self_dimensionSizes,Var_1525919705),
(Var_1525919705 #= Var_1712943792),
nth1(1,Arg_dimensionSizes,Var_842741472),
nth1(1,Self_dimensionSizes,Var_1156304131),
(Var_1156304131 #= Var_842741472),
nth1(2,Arg_dimensionSizes,Var_1766505436),
nth1(2,Self_dimensionSizes,Var_771775563),
(Var_771775563 #\= Var_1766505436),
nth1(3,Arg_dimensionSizes,Var_1164440413),
nth1(3,Self_dimensionSizes,Var_1610525991),
(Var_1610525991 #= Var_1164440413),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
