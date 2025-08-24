:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_482082765),
(Var_482082765 #> 0),
nth1(1,Arg_dimensionSizes,Var_2087885397),
nth1(1,Self_dimensionSizes,Var_1002021887),
length(Arg_dimensionSizes,Var_1712943792),
length(Self_dimensionSizes,Var_1525919705),
nth1(1,Arg_dimensionSizes,Var_842741472),
nth1(1,Self_dimensionSizes,Var_1156304131),
length(Arg_dimensionSizes,Var_1766505436),
length(Self_dimensionSizes,Var_771775563),
(((Var_771775563 #\= Var_1766505436) , (Var_1156304131 #= Var_842741472)) ; ((Var_1525919705 #= Var_1712943792) , (Var_1002021887 #\= Var_2087885397))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
