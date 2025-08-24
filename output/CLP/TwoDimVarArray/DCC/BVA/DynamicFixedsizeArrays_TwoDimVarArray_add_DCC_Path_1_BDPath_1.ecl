:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DCC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1336735375),
(Var_1336735375 #> 0),
nth1(2,Self_dimensionSizes,Var_1754894440),
(Var_1754894440 #> 0),
length(Arg_dimensionSizes,Var_1002021887),
length(Self_dimensionSizes,Var_1712943792),
(Var_1712943792 #= Var_1002021887),
nth1(1,Arg_dimensionSizes,Var_1525919705),
nth1(1,Self_dimensionSizes,Var_842741472),
(Var_842741472 #= Var_1525919705),
nth1(2,Arg_dimensionSizes,Var_1156304131),
nth1(2,Self_dimensionSizes,Var_1766505436),
(Var_1766505436 #\= Var_1156304131),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
