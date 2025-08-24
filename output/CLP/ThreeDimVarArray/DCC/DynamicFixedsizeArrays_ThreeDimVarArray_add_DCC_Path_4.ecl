:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_Path_4(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_1741979653),
length(Self_dimensionSizes,Var_166794956),
(Var_166794956 #= Var_1741979653),
nth1(1,Arg_dimensionSizes,Var_306612792),
nth1(1,Self_dimensionSizes,Var_447212746),
(Var_447212746 #\= Var_306612792),
nth1(2,Arg_dimensionSizes,Var_1496355635),
nth1(2,Self_dimensionSizes,Var_1484171695),
(Var_1484171695 #= Var_1496355635),
nth1(3,Arg_dimensionSizes,Var_2127036371),
nth1(3,Self_dimensionSizes,Var_1529060733),
(Var_1529060733 #= Var_2127036371),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
