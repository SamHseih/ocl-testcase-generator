:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_Path_2_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_482082765),
(Var_482082765 #> 0),
nth1(2,Self_dimensionSizes,Var_1754894440),
(Var_1754894440 #> 0),
nth1(3,Self_dimensionSizes,Var_1998767043),
(Var_1998767043 #> 0),
length(Arg_dimensionSizes,Var_1962826816),
length(Self_dimensionSizes,Var_1072410641),
(Var_1072410641 #= Var_1962826816),
nth1(1,Arg_dimensionSizes,Var_283318938),
nth1(1,Self_dimensionSizes,Var_320304382),
(Var_320304382 #= Var_283318938),
nth1(2,Arg_dimensionSizes,Var_361571968),
nth1(2,Self_dimensionSizes,Var_2005169944),
(Var_2005169944 #\= Var_361571968),
nth1(3,Arg_dimensionSizes,Var_2134607032),
nth1(3,Self_dimensionSizes,Var_1470344997),
(Var_1470344997 #= Var_2134607032),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
