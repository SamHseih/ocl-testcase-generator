:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_sub_DCC_Path_3_BDPath_1(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_966739377),
length(Self_dimensionSizes,Var_952562199),
(Var_952562199 #= Var_966739377),
nth1(1,Arg_dimensionSizes,Var_1199673596),
nth1(1,Self_dimensionSizes,Var_2044903525),
(Var_2044903525 #\= Var_1199673596),
nth1(2,Arg_dimensionSizes,Var_982757413),
nth1(2,Self_dimensionSizes,Var_902478634),
(Var_902478634 #= Var_982757413),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
