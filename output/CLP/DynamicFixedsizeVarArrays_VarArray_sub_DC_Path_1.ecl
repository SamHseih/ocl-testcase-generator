:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

dynamicFixedsizeVarArrays_VarArray_sub_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_944427387),
nth1(1,Arg_dimensionSizes,Var_1636182655),
length(Self_dimensionSizes,Var_71399214),
length(Arg_dimensionSizes,Var_1932831450),
((Var_1932831450 #\= Var_71399214) ; (Var_1636182655 #\= Var_944427387)),
Result = 'Exception',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
