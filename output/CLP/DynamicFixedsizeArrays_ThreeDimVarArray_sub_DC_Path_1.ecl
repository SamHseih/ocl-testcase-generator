:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(3,Arg_dimensionSizes,Var_1076607567),
nth1(3,Self_dimensionSizes,Var_2036127838),
nth1(2,Arg_dimensionSizes,Var_1509791656),
nth1(2,Self_dimensionSizes,Var_257608164),
nth1(1,Arg_dimensionSizes,Var_306115458),
nth1(1,Self_dimensionSizes,Var_230643635),
length(Arg_dimensionSizes,Var_944427387),
length(Self_dimensionSizes,Var_1636182655),
((((Var_1636182655 #\= Var_944427387) ; (Var_230643635 #\= Var_306115458)) ; (Var_257608164 #\= Var_1509791656)) ; (Var_2036127838 #\= Var_1076607567)),
Result = 'Exception',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
