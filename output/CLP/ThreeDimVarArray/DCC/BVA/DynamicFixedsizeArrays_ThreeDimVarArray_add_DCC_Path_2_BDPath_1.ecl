:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_Path_2_BDPath_1(Self,Arg,Result):-

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
length(Arg_dimensionSizes,Var_1666607455),
length(Self_dimensionSizes,Var_1327006586),
(Var_1327006586 #= Var_1666607455),
nth1(1,Arg_dimensionSizes,Var_899644639),
nth1(1,Self_dimensionSizes,Var_530737374),
(Var_530737374 #= Var_899644639),
nth1(2,Arg_dimensionSizes,Var_1332668132),
nth1(2,Self_dimensionSizes,Var_1147580192),
(Var_1147580192 #\= Var_1332668132),
nth1(3,Arg_dimensionSizes,Var_173099767),
nth1(3,Self_dimensionSizes,Var_112797691),
(Var_112797691 #= Var_173099767),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
