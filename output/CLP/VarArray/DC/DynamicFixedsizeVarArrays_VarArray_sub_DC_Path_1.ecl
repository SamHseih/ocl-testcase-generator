:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_482082765),
(Var_482082765 #> 0),
nth1(1,Self_dimensionSizes,Var_1287934450),
nth1(1,Arg_dimensionSizes,Var_6519275),
length(Self_dimensionSizes,Var_692331943),
length(Arg_dimensionSizes,Var_1741979653),
nth1(1,Self_dimensionSizes,Var_166794956),
nth1(1,Arg_dimensionSizes,Var_306612792),
length(Self_dimensionSizes,Var_447212746),
length(Arg_dimensionSizes,Var_1496355635),
(((Var_1496355635 #\= Var_447212746) , (Var_306612792 #= Var_166794956)) ; ((Var_1741979653 #= Var_692331943) , (Var_6519275 #\= Var_1287934450))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
