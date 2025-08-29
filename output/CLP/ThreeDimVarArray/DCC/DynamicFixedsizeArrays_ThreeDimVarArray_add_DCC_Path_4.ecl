:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DCC_Path_4(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_715378067),
(Var_715378067 #> 0),
nth1(2,Self_dimensionSizes,Var_1262773598),
(Var_1262773598 #> 0),
nth1(3,Self_dimensionSizes,Var_2147046752),
(Var_2147046752 #> 0),
length(Arg_dimensionSizes,Var_1026871825),
length(Self_dimensionSizes,Var_2109798150),
(Var_2109798150 #= Var_1026871825),
nth1(1,Arg_dimensionSizes,Var_1074389766),
nth1(1,Self_dimensionSizes,Var_1136768342),
(Var_1136768342 #\= Var_1074389766),
nth1(2,Arg_dimensionSizes,Var_1484673893),
nth1(2,Self_dimensionSizes,Var_587003819),
(Var_587003819 #= Var_1484673893),
nth1(3,Arg_dimensionSizes,Var_769798433),
nth1(3,Self_dimensionSizes,Var_1665620686),
(Var_1665620686 #= Var_769798433),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
