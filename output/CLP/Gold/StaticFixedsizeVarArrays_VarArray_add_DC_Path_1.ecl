:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

solving_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(1,Arg_dimensionSizes,Var_487075464),
nth1(1,Self_dimensionSizes,Var_932285561),
length(Arg_dimensionSizes,Var_2028555727),
length(Self_dimensionSizes,Var_591391158),
((Var_591391158 #\= Var_2028555727) ; (Var_932285561 #\= Var_487075464)),
Result = 'Exception',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
