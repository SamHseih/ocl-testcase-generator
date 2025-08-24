:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_Path_4(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_573673894),
length(Self_dimensionSizes,Var_1226020905),
(Var_1226020905 #= Var_573673894),
nth1(1,Arg_dimensionSizes,Var_156856360),
nth1(1,Self_dimensionSizes,Var_1617550160),
(Var_1617550160 #\= Var_156856360),
nth1(2,Arg_dimensionSizes,Var_1325124186),
nth1(2,Self_dimensionSizes,Var_461160828),
(Var_461160828 #= Var_1325124186),
nth1(3,Arg_dimensionSizes,Var_1499867659),
nth1(3,Self_dimensionSizes,Var_2012993836),
(Var_2012993836 #= Var_1499867659),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
