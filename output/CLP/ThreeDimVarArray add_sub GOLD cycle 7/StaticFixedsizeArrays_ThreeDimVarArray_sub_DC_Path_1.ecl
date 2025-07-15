:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

solving_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(3,Arg_dimensionSizes,Var_1344199921),
nth1(3,Self_dimensionSizes,Var_557023567),
nth1(2,Arg_dimensionSizes,Var_1276504061),
nth1(2,Self_dimensionSizes,Var_597190999),
nth1(1,Arg_dimensionSizes,Var_603443293),
nth1(1,Self_dimensionSizes,Var_510854293),
length(Arg_dimensionSizes,Var_2100961961),
length(Self_dimensionSizes,Var_487075464),
((((Var_487075464 #\= Var_2100961961) ; (Var_510854293 #\= Var_603443293)) ; (Var_597190999 #\= Var_1276504061)) ; (Var_557023567 #\= Var_1344199921)),
Result = 'Exception',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
