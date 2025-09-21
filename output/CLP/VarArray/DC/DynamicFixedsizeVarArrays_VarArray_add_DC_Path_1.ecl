:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1031061344),
(Var_1031061344 #> 0),
nth1(1,Arg_dimensionSizes,Var_1847008471),
nth1(1,Self_dimensionSizes,Var_1076607567),
length(Arg_dimensionSizes,Var_2036127838),
length(Self_dimensionSizes,Var_1509791656),
nth1(1,Arg_dimensionSizes,Var_257608164),
nth1(1,Self_dimensionSizes,Var_306115458),
length(Arg_dimensionSizes,Var_230643635),
length(Self_dimensionSizes,Var_944427387),
(((Var_944427387 #\= Var_230643635) , (Var_306115458 #= Var_257608164)) ; ((Var_1509791656 #= Var_2036127838) , (Var_1076607567 #\= Var_1847008471))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
