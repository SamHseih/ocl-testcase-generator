:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

dynamicFixedsizeArrays_TwoDimVarArray_add_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(2,Arg_dimensionSizes,Var_1637290981),
nth1(2,Self_dimensionSizes,Var_1888442711),
nth1(1,Arg_dimensionSizes,Var_1754894440),
nth1(1,Self_dimensionSizes,Var_1998767043),
length(Arg_dimensionSizes,Var_787738361),
length(Self_dimensionSizes,Var_607932305),
(((Var_607932305 #\= Var_787738361) ; (Var_1998767043 #\= Var_1754894440)) ; (Var_1888442711 #\= Var_1637290981)),
Result = 'Exception',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
