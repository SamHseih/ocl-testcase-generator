:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(3,Arg_dimensionSizes,Var_1888442711),
nth1(3,Self_dimensionSizes,Var_1754894440),
nth1(2,Arg_dimensionSizes,Var_1998767043),
nth1(2,Self_dimensionSizes,Var_787738361),
nth1(1,Arg_dimensionSizes,Var_607932305),
nth1(1,Self_dimensionSizes,Var_168366),
length(Arg_dimensionSizes,Var_1642030774),
length(Self_dimensionSizes,Var_1357563986),
((((Var_1357563986 #\= Var_1642030774) ; (Var_168366 #\= Var_607932305)) ; (Var_787738361 #\= Var_1998767043)) ; (Var_1754894440 #\= Var_1888442711)),
Result = 'Exception',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
